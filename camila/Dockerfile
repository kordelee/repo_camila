# alpine linux included openjdk 17
FROM openjdk:17-alpine

# project directory
ENV project="camila"

# set timezone
RUN apk add tzdata && ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

# create project directory
RUN mkdir ${project}

#COPY build/libs/*.jar /${workdir}/spring-base.jar
COPY build/libs/*.jar /${project}/${project}.jar

# exec jar without env
ENTRYPOINT ["sh", "-c", "java -jar /${project}/${project}.jar"]