# Proyecto Microservicio Java, Spring Framework, Docker, Tomcat.

# 1. Limpieza y Compilación Para eliminar compilaciones anteriores y generar el nuevo archivo `.jar` / `.war`:
``` mvn clean package 
```

# 2. Construir y levantar (Primera vez o cambios), crea la imagen desde el Dockerfile y levanta el servicio:
```docker-compose up --build
```

# 3. Solo levantar el servicio e iniciar los contenedores ya existentes:.
```docker-compose up
```

# 4. En caso de problemas en la creación del contenedor detener todo y borrar volúmenes viejos.
```docker-compose down -v
```