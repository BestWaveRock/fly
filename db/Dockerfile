FROM registry.cn-hangzhou.aliyuncs.com/dockerhub_mirror/mysql-server:8.0.32

MAINTAINER liangjx(liangjiaxin8@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY fly.sql /docker-entrypoint-initdb.d

COPY fly_config.sql /docker-entrypoint-initdb.d

EXPOSE 3306
