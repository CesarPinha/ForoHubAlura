# ForoHubAlura
**ForoHubAlura** es una aplicación de consola, diseñada para simular un foro de discusión, inspirada en la plataforma de Alura Latam. Permite a los usuarios publicar preguntas, responder a otras publicaciones y participar en debates sobre temas diversos, todo a través de la consola.

## 🚀 Funcionalidades Principales

*   **Creación de Hilos de Discusión:** Los usuarios pueden iniciar nuevos temas de discusión con un título y una descripción.
*   **Respuestas:** Los usuarios pueden responder a hilos de discusión existentes, fomentando la conversación.
*   **Interacción por Consola:** Toda la interacción con el foro se realiza mediante comandos ingresados en la consola.
*   **Fácil de Usar:** Menús intuitivos guían al usuario a través de las funcionalidades del foro.
*   **Registro y Login:** Los usuarios pueden crear cuentas y acceder al foro para publicar y comentar.

## 💻 Tecnologías Utilizadas

*   **Backend:**
    *   Java 
    *   Spring Boot
    *   Spring Security
    *   JPA/Hibernate
*   **Base de Datos:**
    *   MySQL

## ⚙️ Cómo Ejecutar el Proyecto

Sigue estos pasos para configurar y ejecutar ForoHubAlura en tu entorno local:

1.  **Clona el Repositorio:**
    ```bash
    git clone https://github.com/CesarPinha/ForoHubAlura.git
    cd ForoHubAlura
    ```

2.  **Configura la Base de Datos:**
    *   Asegúrate de tener MySQL instalado y corriendo.
    *   Crea una base de datos llamada `forohubalura`.
    *   Configura las credenciales de la base de datos en el archivo `application.properties` del proyecto.

3.  **Ejecuta la Aplicación:**
    *   Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.).
    *   Ejecuta la clase principal de la aplicación Spring Boot. Generalmente se encuentra en `src/main/java/com/.../ForoHubAluraApplication.java`.
    *   La aplicación se iniciará y podrás interactuar con ella a través de la consola del IDE.

## 📝 Próximas Mejoras

*   **Sistema de Notificaciones (Consola):** Implementar notificaciones en la consola para los usuarios cuando se respondan a sus publicaciones.
*   **Búsqueda:** Añadir una funcionalidad de búsqueda por palabras clave en los hilos de discusión.
*   **Edición y Eliminación:** Permitir que los usuarios editen o eliminen sus propios hilos y respuestas.
*   **Mejoras en la Interfaz de Consola:** Refinar la presentación de información en la consola para una mejor experiencia.
*   **Pruebas:** Agregar más pruebas unitarias y de integración para garantizar la estabilidad.


## 📜 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Desarrollador

*   **Cesar Pinha** - [GitHub](https://github.com/CesarPinha)

## 🔗 Enlaces

*   **Repositorio:** [https://github.com/CesarPinha/ForoHubAlura](https://github.com/CesarPinha/ForoHubAlura)
