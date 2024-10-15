# Conversor de Monedas en Java
### Primer desafío de Alura para desarrolladores Backend

### Descripción
<P>Este proyecto es un conversor de monedas desarrollado en Java que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio en tiempo real obtenidas de una API. El programa también guarda un historial de conversiones tanto en un archivo de texto como en un archivo JSON.</P>

### Características

- Conversión entre tipos de monedas (USD, CLP, BRL).
- Integración con una API para obtener tasas de cambio actualizadas `ExchangeRate-API`.
- Almacenamiento del historial de conversiones en dos formatos: texto y JSON.
- Opción para ver el historial de conversiones desde la consola.
- Registro de la fecha y hora de cada conversión.

### Estructura del Proyecto
El proyecto se compone de las siguientes clases:
1. `ConversorDeMoneda`: Clase principal que maneja la interacción con el usuario y el menú de opciones. Es responsable de mostrar las opciones y recibir la entrada del usuario para realizar las conversiones.
2. `GestorHistorial`: Esta clase gestiona el almacenamiento y la visualización del historial de conversiones en un archivo de texto. Permite agregar nuevas conversiones al historial y mostrarlas en la consola.
3. `GestorJson`: Gestiona el almacenamiento del historial de conversiones en un archivo JSON. Permite agregar nuevas conversiones y guardar los datos en formato JSON para facilitar su lectura y manipulación.
4. `ServicioConversion`: Esta clase se encarga de realizar las conversiones de moneda utilizando la clase `GestorHttp`. Llama a la API para obtener la tasa de cambio y calcula el resultado de la conversión.
5. `GestorHttp`: Se encarga de las solicitudes y respuestas HTTP a la API de conversión de monedas (`ExchangeRate-API`). Este componente maneja la creación de la solicitud, envía la solicitud a la API y analiza la respuesta JSON para extraer la tasa de cambio.

### Requisitos para desarrollar el proyecto
- Java 11 o superior.
- Dependencias de la biblioteca Gson para manejar JSON.
- Una API para obtener las tasas de cambio `ExchangeRate-API`.
- Tener instalado `Intellij IDEA`.

### Ejemplo de uso de la Aplicación
Al iniciar la aplicación, el usuario verá el siguiente menú:
![Menu_conversor_monedas](https://github.com/user-attachments/assets/9095fbd1-fb3e-4ad9-9b34-81696aa2e139)
<p>El usuario puede seleccionar una opción y seguir las instrucciones en pantalla para realizar la conversión o ver el historial.</P>

### Historial de Conversiones en Formato JSON
Un ejemplo de cómo se verá el archivo `Historial_conversiones.json`:

![formato_json](https://github.com/user-attachments/assets/f4c9a871-229a-44d7-9092-3c725e4eaf23)

### Historial de Conversiones en Formato de Texto:
Un ejemplo de cómo se verá el archivo `Historial_conversiones.txt`:

![historial_texto](https://github.com/user-attachments/assets/34e914ab-383a-4dbf-97e1-5c13290ab489)

### Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, siéntete libre de hacerlo.
