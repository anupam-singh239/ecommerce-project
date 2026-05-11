FROM tomcat:9.0

COPY ./E-commerce /usr/local/tomcat/webapps/E-commerce

EXPOSE 8080

CMD ["catalina.sh", "run"]
