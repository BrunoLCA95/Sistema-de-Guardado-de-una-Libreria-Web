# Sistema de Guardado de una Librería Web
El objetivo de este ejercicio consiste en el desarrollo de un sistema web de guardado de
libros en JAVA utilizando una base de datos MySQL, JPA Repository para persistir
objetos y Spring Boot como framework de desarrollo web.
# Diagrama entidad-relacion
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905954865526755368/ulm.PNG)

# Resultado
## Autor
### Listado de Autores
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905956848274923530/autorlist.PNG)
### Nuevo Autor
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905957386974552075/nuevoautor.PNG)
### Modificar Autor
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905957962927984651/modificarA.PNG)

## Editorial
### Listado de Editoriales
![alt text]()
### Nuevo Editorial
![alt text]()
### Modificar Editorial
![alt text]()

## Libros
### Listado de Libros
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905959849228111872/as.PNG)
### Nuevo Libro
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905960084138520626/a.PNG)
### Modificar Libro
![alt text](https://cdn.discordapp.com/attachments/905954770672554037/905960329723392090/asd.PNG)

## Prueba del Ejercicio
### Creacion de la DB
CREATE DATABASE libreria;
### Requerimientos
-Instalar JDK 11
```
https://jdk.java.net/archive/
```
-Instalar Maven
```
https://maven.apache.org/download.cgi
```
### Configuracion de application.properties
>/src/main/resources/application.properties
#### Cambiar direccion del servidor sql
  > spring.datasource.url=jdbc:mysql://localhost:3306/libreria?serverTimezone=UTC
#### Cambiar usuario del servidor sql
  > spring.datasource.username=root
#### Cambiar password del servidor sql
  > spring.datasource.password=root

