# SocialSoft Backend

Proyecto académico orientado al desarrollo backend para la gestión de suscripciones de usuarios a canales. La solución incluye servicios **REST** y **SOAP**, acceso a datos con **JDBC**, procedimientos almacenados en **MySQL** y una organización por capas.

## Tecnologías

- Java
- Jakarta EE
- JAX-RS (REST)
- JAX-WS (SOAP)
- JDBC
- MySQL
- Maven

## Funcionalidades principales

- Registro de suscripciones mediante un servicio REST.
- Consulta de suscripciones de un usuario mediante un servicio SOAP.
- Acceso a datos mediante procedimientos almacenados.
- Separación por capas: modelo, persistencia, lógica de negocio y servicios web.
- Manejo de conexiones y transacciones con JDBC.

## Estructura

```text
REST/Backend/SocialSoftSolution/   Backend del servicio REST
SOAP/Backend/SocialSoftSolution/   Backend del servicio SOAP
database/                          Scripts de base de datos
```

Los módulos principales del backend son:

- `SocialSoftModel`: entidades del dominio.
- `SocialSoftPersistance`: acceso a datos y ejecución de procedimientos almacenados.
- `SocialSoftNegocio`: lógica de negocio.
- `SocialSoftDBManager`: gestión de la conexión a MySQL.
- `SocialSoftWS`: exposición de los servicios web.

## Base de datos

Ejecutar los scripts de la carpeta `database` en este orden:

1. `01_schema.sql`
2. `02_datos_prueba.sql`
3. `03_procedimientos.sql`

`99_drop.sql` se incluye únicamente para eliminar las tablas del esquema cuando sea necesario.

Los archivos `datos.properties` contienen únicamente una configuración local de ejemplo. Las credenciales reales no deben publicarse en el repositorio.

## Servicios implementados

- **REST:** registro de una suscripción de usuario a un canal.
- **SOAP:** listado de suscripciones asociadas a un usuario.

## Nota

Este proyecto corresponde a una entrega académica y su alcance está limitado a los requerimientos planteados en la evaluación. Para esta versión pública se conservaron únicamente los componentes backend y los procedimientos almacenados utilizados por la solución.
