FROM openjdk:8
EXPOSE 8080
ADD target/springboot-cicd-repo.jar springboot-cicd-repo.jar
ENTRYPOINT ["java", "-jar", "/springboot-cicd-repo"]