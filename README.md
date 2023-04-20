Desafío AccuWeather

El Desafío AccuWeather es un proyecto basado en Java que recupera datos meteorológicos de la API de AccuWeather. La aplicación utiliza el marco Spring Boot y proporciona una interfaz para consultar el pronóstico del tiempo en una ubicación específica.

Requisitos

Java 8 o superior
Maven
Dependencias

Spring Boot
Spring Web
Spring Test
Jackson (para el manejo de JSON)
Estructura del proyecto

El proyecto se organiza en paquetes y clases principales:

com.accuweatherchallenge.accuweatherchallenge: Paquete principal que contiene la aplicación de Spring Boot.
AccuWeatherChallengeApplication: Clase principal de la aplicación Spring Boot.
com.accuweatherchallenge.accuweatherchallenge.service: Paquete que contiene los servicios.
AccuWeatherApiClient: Clase que se comunica con la API de AccuWeather para obtener datos meteorológicos.
com.accuweatherchallenge.accuweatherchallenge.model: Paquete que contiene los modelos de datos.
WeatherData: Clase que representa la información meteorológica obtenida de la API de AccuWeather.
com.accuweatherchallenge.accuweatherchallenge: Paquete que contiene las pruebas.
AccuWeatherApiClientTest: Clase que contiene pruebas unitarias para el cliente AccuWeatherApiClient.
Cómo ejecutar

Clonar el repositorio.
bash
Copy code
git clone https://github.com/yourusername/accuweather-challenge.git
Navegar al directorio del proyecto.
bash
Copy code
cd accuweather-challenge
Compilar y empaquetar el proyecto utilizando Maven.
go
Copy code
mvn clean package
Ejecutar la aplicación.
bash
Copy code
java -jar target/accuweather-challenge-0.0.1-SNAPSHOT.jar
Cómo utilizar

La aplicación expone un punto final REST para obtener datos meteorológicos basados en la clave de ubicación proporcionada.

bash
Copy code
GET /weather/{locationKey}
Para utilizar el punto final, reemplace {locationKey} con la clave de ubicación de la ciudad para la que desea obtener información meteorológica. Por ejemplo:

bash
Copy code
GET /weather/12345
La aplicación devolverá datos meteorológicos en formato JSON.
