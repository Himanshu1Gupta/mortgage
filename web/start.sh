if [[ $NEWRELIC_ENABLE = yes ]]; then
  java -Dspring.profiles.active=$ENV_PROFILE -XX:MaxRAMPercentage=60.0 -Dnewrelic.environment=$ENV_PROFILE -javaagent:/var/newrelic/newrelic.jar -jar /app.jar
else
  java -Dspring.profiles.active=$ENV_PROFILE -XX:MaxRAMPercentage=60.0 -Dnewrelic.environment=$ENV_PROFILE -jar /app.jar
fi