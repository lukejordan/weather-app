#!
export WAR_NAME=weather-app
mvn clean package
java -jar target/${WAR_NAME}*.jar