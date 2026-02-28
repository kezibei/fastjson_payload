```
sudo iptables -I DOCKER-USER 1 -m conntrack --ctstate ESTABLISHED,RELATED -j ACCEPT
sudo iptables -I DOCKER-USER 2 -s 172.17.0.0/16 -o eth0 -j DROP

sudo docker build --no-cache -t fj_plus:randomjdk .
sudo docker run --cap-drop ALL --security-opt no-new-privileges -d -p 8078:8078 --name fj_test fj_plus:randomjdk
```
