To create the skeleton run:

curl https://start.spring.io/starter.zip \
-d dependencies=web,actuator \
-d type=maven-project \
-d groupId=com.example \
-d artifactId=frontend-service \
-d name=frontend-service \
-d packageName=com.example.frontend \
-d javaVersion=21 \
-o frontend-service.zip

Build:

mvn clean package

Run:

In dev mode:

mvn spring-boot:run


Run Locally:

java -jar target/frontend-service-1.0.0-SNAPSHOT.jar


Run in Docker on WSL:

docker build -t frontend-service .
docker run -p 8080:8080 frontend-service



