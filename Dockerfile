FROM maven:3.9.9-amazoncorretto-17-alpine AS builder
ENV TZ=Asia/Bangkok
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:24-ea-17-slim-bullseye
ENV APPNAME aps-0.0.1
COPY --from=builder /app/target/${APPNAME}.jar /${APPNAME}.jar

CMD ["sh", "-c", "java -jar ${APPNAME}.jar"]