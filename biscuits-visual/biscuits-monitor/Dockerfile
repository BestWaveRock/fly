FROM registry.cn-hangzhou.aliyuncs.com/dockerhub_mirror/java:21-anolis

WORKDIR /biscuits-monitor

ARG JAR_FILE=target/biscuits-monitor.jar

COPY ${JAR_FILE} app.jar

EXPOSE 5001

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod"

CMD sleep 50; java $JAVA_OPTS -jar app.jar
