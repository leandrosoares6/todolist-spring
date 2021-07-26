
FROM maven:3.8.1-jdk-11

WORKDIR /app

COPY . .

# Link Java install directory to our previously defined "docker-java-home" folder
RUN ln -s "${JAVA_HOME}" /docker-java-home

EXPOSE 8080
