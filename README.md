# cpimgroup

Explicación del Diagrama:

1- Cliente:
REaliza una solicitud HTTP POST a la API para crear un nuevo usuario, mediante un json
2- UsuarioController:
REcibe solicitud y envia datos a UsuarioSErvice
3- UsuarioService:
Realiza validación en contraseña.
Verifica si el correo ya existe en base de datos
Genera token unico (UUID) para el nuevo usuario
Crea un objeto UsuarioModel con los datos del token
Llama al UsuarioRepository para persistir los datos en la base de datos.
4- UsuarioRepository:
Interactua con la base de datos para guardar UsuarioModel
5- Bse de Datos:
LA Base de datos almacena los datos del usuario, incluida la pk (ID), nombre, correo,token, etc.
6- UsuarioResponseDTO:
El servicio genera un DTO (Data TRansfer OBject) con los datos y el token.
7- Controlador:
Envía el UsuarioREsponseDTO como respuesta al cliente, quien ahora tiene acceso al token y los datos del usuario creado.


------------------------------------------------ ° ------------------------------------------------

Para poder ejecutar el proyecto Clonar proyecto, ejecutar Spring Boot App y al levantar el servidor.
al estar "arriba" el servidor.
En postman o donde gusten probar la API; deberan agregar esta url (localhost:8080/usuario/)
Get (Obtiene todos los usuarios)
Post(Registra usuario): PAra la contraseña considerar: almenos 8 caracteres, una letra (mayuscula), Número y caracteres especiales.
Put(Modifica Usuario)

* al iniciar el protyecto este no posee objetos en memoria, por lo tanto primero deberan registrar un usuario (POST).
  



