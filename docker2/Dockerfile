FROM openjdk:11.0.8

COPY CVE-2022-25845-In-Spring-1.2-SNAPSHOT.jar /app.jar

RUN set -eux; \
    RAND_DIR="/opt/jdk-$(tr -dc a-z0-9 </dev/urandom | head -c 16)"; \
    mkdir -p "$RAND_DIR"; \
    JAVA_REAL_PATH="$(readlink -f $(which java))"; \
    JDK_HOME="$(dirname $(dirname "$JAVA_REAL_PATH"))"; \
    mv "$JDK_HOME" "$RAND_DIR/jdk"

RUN chmod 555 /opt/jdk-*/jdk/lib/*.so*
RUN chmod 555 /lib/x86_64-linux-gnu/*.so*
RUN chmod 555 /usr/lib/x86_64-linux-gnu/*.so*

CMD ["sh", "-c", "exec $(find /opt -type f -path '*/jdk/bin/java' -perm -111 | head -n 1) -jar /app.jar"]


EXPOSE 8078
