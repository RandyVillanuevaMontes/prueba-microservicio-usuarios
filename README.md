# Proyecto Microservicio Java, Spring Framework, Docker, Tomcat.

# 1. Limpiar el Proyecto de compilaciones anteriores.
mvn clean package

# 2. Detener todo y borrar volúmenes viejos
docker-compose down -v

# 3. Reconstruir la imagen y levantar el servicio al mismo tiempo.
docker-compose up --build

# 4. Solo levantar el servicio.
docker-compose up