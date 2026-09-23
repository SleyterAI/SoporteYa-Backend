Mini Mesa de Ayuda Interna 
_____________________________________________
Proyecto FullStack, que permite gestionar tickets
creación, obtención y actualización, validación de 
workflow de estado de cada ticket. 
Cuenta con validación de roles para usuario y admin
para visualizar características únicas de admin.

Tecnologías usadas
 Backend:
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JJWT

Frontend:
- Angular 20
- Typescript
- Interceptors 
- Guards
- Cookies

Base de datos:
- MySQL

Herramientas:
- VSC
- IntelliJ IDEA
- Postman
- Git y GitHub

Funcionalidades:
Usuario:
- Login
- Creación de tickets
- Visualización de su propios tickets
- Acceso a base de conocimiento
- Acceso a configuración
- Filtro por estado de tickets

Admin:
- Login
- Kanban de todos los tickets
- Lista general de tickets
- Creación de tickets
- Visualización de su propios tickets
- Acceso a base de conocimiento
- Acceso a configuración
- Filtro por estado de tickets y prioridad

Arquitectura 
Backend:
- Cors
- GlobalException
- Security
- Controller
- Service
- Dto
- Mapper
- Repository
- Entity

Frontend:
- Components
- core
	- interceptos
	- guards
	- pipes
- environments
- features
	- knowledge-base
	- settings
	- tickets
	- user
- layout
	- full-page
	- sidebar
	- topbar
	- services
- shared

Colección de endpoints

Obtener tickets:
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

Actualizar prioridad del ticket:
PATCH: http://localhost:8081/api/tickets/15/prioridad

Obtener ticket del usuario autenticado con email
GET: http://localhost:8081/api/tickets/user
Auth: Bearer Token

Registrar usuario
POST: http://localhost:8081/api/user/register

Obtener usuario
GET: http://localhost:8081/api/user

Autenticar usuario
POST: http://localhost:8081/api/auth/login

Obtener categorías
GET: http://localhost:8081/api/categorias

Ejecución del proyecto 
Clonar del repositorio
git clone

Instalar las dependencias
npm install

Frontend:
ng serve -o
port: 4200

Backend:
mvn spring-boot:run
port: 8081

Seguridad del proyecto
Backend:
Autenticación con JJWT y autorizacion roles en backend

Frontend:
Uso de cookie para validar la autenticación y rol
Uso de guards para validar el rol

Autor: Sleyter Astete Ibañez