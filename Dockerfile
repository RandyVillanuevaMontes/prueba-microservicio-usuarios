# Tomcat con Java 11
FROM tomcat:9.0-jdk11

# Eliminar apps default
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar WAR
COPY target/microservicio.war /usr/local/tomcat/webapps/ROOT.war

# Puerto
EXPOSE 8080