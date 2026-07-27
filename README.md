# JStore Backend

Backend desarrollado para la gestión de productos de una tienda online mediante una API REST.

Proyecto realizado durante el proceso formativo de Análisis y Desarrollo de Software (ADSO).

---

## Descripción

JStore Backend permite administrar productos mediante operaciones CRUD:

- Crear productos
- Consultar productos
- Actualizar productos
- Eliminar productos

La aplicación implementa una arquitectura organizada por capas utilizando buenas prácticas de desarrollo backend.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate ORM
- MySQL 8
- Maven
- Lombok
- Jakarta Validation
- Swagger / OpenAPI

---

## Arquitectura del proyecto

```text
com.jstore

├── controller
│   └── ProductController
│
├── service
│   ├── interfaces
│   └── impl
│
├── repository
│   └── ProductRepository
│
├── entity
│   └── Product
│
├── dto
│   ├── request
│   ├── response
│   └── error
│
├── mapper
│   └── ProductMapper
│
├── exception
│   ├── ResourceNotFoundException
│   └── GlobalExceptionHandler
│
└── config
    └── OpenApiConfig


Base de datos

Motor utilizado:
MySQL 8
Base de datos:
jstore

Ejecución del proyecto
Compilar:
mvn clean compile

Ejecutar:
mvn spring-boot:run

Servidor:
http://localhost:8080


Endpoints principales
| Método | Endpoint           | Descripción         |
| ------ | ------------------ | ------------------- |
| GET    | /api/products      | Listar productos    |
| GET    | /api/products/{id} | Buscar producto     |
| POST   | /api/products      | Crear producto      |
| PUT    | /api/products/{id} | Actualizar producto |
| DELETE | /api/products/{id} | Eliminar producto   |

Características implementadas

✅ Arquitectura por capas
✅ DTO Request / Response
✅ Validaciones con Jakarta Validation
✅ Manejo global de excepciones
✅ Mapper Entity - DTO
✅ CRUD completo
✅ Persistencia MySQL
✅ Documentación Swagger/OpenAPI

Autor

Juan Salgado

Proyecto JStore Backend
