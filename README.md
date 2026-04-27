# Proyecto Microservicio Java, Spring Framework, Docker, Tomcat.

# 1. Limpiar el Proyecto de compilaciones anteriores.
``` 
mvn clean package 

```

# 2. Construir la imagen y levantar el servicio al mismo tiempo.
```
docker-compose up --build

```

# 3. Solo levantar el servicio.
```
docker-compose up

```

# 4. En caso de problemas en la creación del contenedor detener todo y borrar volúmenes viejos.
```
docker-compose down -v

```