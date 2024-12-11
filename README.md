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

