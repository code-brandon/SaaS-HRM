# app.jar  Dockerfile  logs  nohup.out

FROM lwieske/java-8

#容器元信息，帮助信息，Metadata，类似于代码注释
MAINTAINER 1911298402@qq.com

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5555"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 创建目录
RUN mkdir -p /ihrm-eureka

# 工作目录
WORKDIR /ihrm-eureka

# 暴露端口
EXPOSE 10000

# 将本地Jar添加到Docker镜像中
ADD ./ihrm-eureka.jar ./

# 睡眠5秒 启动Jar包
CMD sleep 5;java $JAVA_OPTS "-Dfile.encoding=UTF-8" -jar ihrm-eureka.jar