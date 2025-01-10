rem rebuild project
mvn clean package -DargLine="-Dspring.profiles.active=docker"