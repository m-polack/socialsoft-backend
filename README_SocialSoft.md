# SocialSoft Backend

Proyecto académico desarrollado como parte de una evaluación final, enfocado en la implementación de servicios backend para la gestión de suscripciones de usuarios a canales.

## Tecnologías

- Java
- Jakarta EE
- JAX-RS (REST)
- JAX-WS (SOAP)
- JDBC
- MySQL
- Maven

## Funcionalidades principales

- Registro de una suscripción mediante un servicio REST.
- Consulta de suscripciones de un usuario mediante un servicio SOAP.
- Acceso a datos mediante procedimientos almacenados en MySQL.
- Separación por capas: modelo, persistencia, lógica de negocio y servicios web.
- Manejo de conexiones y transacciones con JDBC.

## Estructura del backend

- `SocialSoftModel`: entidades del dominio.
- `SocialSoftPersistance`: acceso a datos y ejecución de procedimientos almacenados.
- `SocialSoftNegocio`: lógica de negocio.
- `SocialSoftDBManager`: gestión de la conexión a MySQL.
- `SocialSoftWS`: exposición de servicios REST/SOAP.

## Base de datos

El repositorio incluye scripts SQL para crear la estructura de la base de datos, cargar datos de prueba y definir los procedimientos almacenados utilizados por la aplicación.

> Las credenciales de conexión no forman parte del repositorio público. La configuración de base de datos debe realizarse localmente.

## Nota

Este proyecto corresponde a una entrega académica y su alcance está limitado a los requerimientos planteados en la evaluación.

El código fuente será añadido próximamente. Actualmente se encuentra en proceso de organización y limpieza para su publicación.
