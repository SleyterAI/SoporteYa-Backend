# Mini Mesa de Ayuda Interna: SoporteYa-Backend
_____________________________________________
Proyecto FullStack, que permite gestionar tickets
creación, obtención y actualización, validación de 
workflow de estado de cada ticket. 
Cuenta con validación de roles para usuario y admin
para visualizar características únicas de admin.

# Tecnologías usadas backend:
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JJWT

# Base de datos:
- MySQL

# Herramientas:
- IntelliJ IDEA
- Postman
- Git y GitHub

# Funcionalidades:
# Usuario:
- Login
- Creación de tickets
- Visualización de su propios tickets
- Filtro por estado de tickets
- Visualización de tickets propios atraves de token
# Admin:
- Login
- Kanban de todos los tickets
- Lista general de tickets
- Creación de tickets
- Visualización de su propios tickets
- Filtro por estado de tickets y prioridad
- Visualización de tickets propios atraves de token

# Arquitectura:
- Cors
- GlobalException
- Security
- Controller
- Service
- Dto
- Mapper
- Repository
- Entity

# Colección de endpoints

# Obtener tickets:
GET: http://localhost:8081/api/tickets

Filtro de tickets por prioridad y estado
GET: http://localhost:8081/api/tickets?estado=EN_PROGRESO&prioridad=ALTA

Obtener ticket por ID:
GET: http://localhost:8081/api/tickets/15

Crear nuevo ticket:
POST: http://localhost:8081/api/tickets

Actualizar estado del ticket:
PATCH: http://localhost:8081/api/tickets/15/estado
Se valida con el workflow 
ABIERTO -> EN_PROGRESO -> RESUELTO -> CERRADO

Obtener ticket del usuario autenticado con email
GET: http://localhost:8081/api/tickets/user
Auth: Bearer Token

Obtener User Id by Email
GET: http://localhost:8081/api/user/id
Auth: Bearer Token

Actualizar ticket prioridad
PATCH: 	http://localhost:8081/api/tickets/15/prioridad

# Registrar usuario
POST: http://localhost:8081/api/user/register

Obtener usuario
GET: http://localhost:8081/api/user

Autenticar usuario
POST: http://localhost:8081/api/auth/login

# Obtener categorías
GET: http://localhost:8081/api/categorias

# Ejecución del proyecto 
Clonar del repositorio
git clone

Instalar las dependencias
npm install

Backend:
mvn spring-boot:run
port: 8081

# Seguridad del proyecto
Autenticación con JJWT y autorizacion roles en backend

## Autor: Sleyter Astete Ibañez
