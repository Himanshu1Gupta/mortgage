FROM amazoncorretto:17
RUN mkdir -p /var/log/apps_logs
VOLUME /tmp
EXPOSE 8080


RUN mkdir app
COPY start.sh /app/start.sh
ADD target/web*.jar app.jar
ADD newrelics/newrelic.jar /var/newrelic/newrelic.jar
ADD newrelics/newrelic.yml /var/newrelic/newrelic.yml
ENTRYPOINT ["sh", "/app/start.sh"]