Metodos - semana 5
Documentación Breve: Decisiones de Diseño del Proyecto
1. Estructura del Proyecto
El proyecto sigue una estructura estándar de Maven, lo que facilita la organización y el mantenimiento del código:

java: Contiene el código fuente principal.
java: Reservado para pruebas unitarias (aunque no se han implementado aún).
pom.xml: Archivo de configuración de Maven para gestionar dependencias y configuraciones del compilador.
2. Clases y Responsabilidades
El diseño sigue el principio de responsabilidad única, donde cada clase tiene un propósito claro:

Biblioteca: Gestiona la lógica principal de la biblioteca, como agregar libros, registrar usuarios, realizar préstamos y generar informes.
Libro: Representa un libro con atributos como título, autor, ISBN, y estado de disponibilidad.
Usuario: Representa un usuario con atributos como ID, nombre, email y una lista de préstamos actuales.
Prestamo: Representa un préstamo, asociando un libro, un usuario y las fechas relevantes (préstamo y devolución).
Main: Clase principal para ejecutar y probar las funcionalidades del sistema.
3. Uso de Colecciones
Se utilizan listas (List) para almacenar libros, usuarios y préstamos, lo que permite una gestión dinámica de los datos:

ArrayList: Elegido por su simplicidad y eficiencia en operaciones de búsqueda y adición.
4. Sobrecarga de Métodos
Se implementa sobrecarga en métodos clave para ofrecer flexibilidad:

agregarLibro: Permite agregar libros usando un objeto Libro o especificando los atributos directamente.
registrarUsuario: Permite registrar usuarios usando un objeto Usuario o especificando los atributos directamente.
5. Encapsulamiento
Los atributos de las clases son privados y se acceden mediante métodos getter y setter, asegurando el control sobre los datos y promoviendo el encapsulamiento.

6. Gestión de Disponibilidad
La clase Libro incluye métodos específicos para marcar libros como prestados o disponibles, asegurando que el estado del libro se gestione de manera centralizada.

7. Cálculo de Retrasos
La clase Prestamo incluye un método para calcular los días de retraso en la devolución, utilizando la API de fechas de Java (java.time).

8. Informes y Consultas
La clase Biblioteca incluye métodos para generar informes y realizar búsquedas de libros por título o autor, facilitando la consulta de información.

9. Extensibilidad
El diseño permite agregar nuevas funcionalidades fácilmente, como:

10. Legibilidad y Mantenimiento
El código está diseñado para ser legible y fácil de mantener:

Uso de nombres descriptivos para clases, métodos y variables.
Separación clara de responsabilidades entre las clases.
Este diseño modular y orientado a objetos asegura que el sistema sea escalable, fácil de entender y adaptable a futuros cambios.
