# Challenge AccuWeather

Proyecto basado en Java que recupera datos meteorológicos de la API de AccuWeather. La aplicación utiliza el marco Spring Boot y proporciona una interfaz para consultar el pronóstico del tiempo en una ubicación específica.

### Requisitos

- Java 8 o superior
- Maven

### Dependencias

- Spring Boot
- Spring Web
- Spring Test
- Jackson (para el manejo de JSON)

### Cómo ejecutar

Clonar el repositorio:

`git clone https://github.com/yourusername/accuweather-challenge.git`


Navegar al directorio del proyecto: 

`cd accuweather-challenge`

Compilar y empaquetar el proyecto utilizando Maven:
`mvn clean package`

Ejecutar la aplicación.
`java -jar target/accuweather-challenge-0.0.1-SNAPSHOT.jar`


### Cómo utilizar

La aplicación expone un punto final REST para obtener datos meteorológicos basados en la clave de ubicación proporcionada.

Testeo en postman:
http://localhost:8080/api/weather/{locationKey}

### Obtener locationKeys 

Para obtener facilmente location keys de AccuWeather, puedes seguir los siguientes pasos:

1) Ingresa al sitio web de AccuWeather (https://www.accuweather.com/).
2) Busca la ubicación que te interese en la barra de búsqueda ubicada en la parte superior de la página y haz clic en ella.
3) Selecciona la ubicación exacta que te interese en el mapa que aparece.
4) Copia la URL de la página que aparece en la barra de direcciones del navegador.
5) La location key aparece en la URL después de la palabra "details" y antes de la barra diagonal "/". Por ejemplo, si la URL es  https://www.accuweather.com/en/us/new-york-ny/10007/weather-forecast/349727, la location key sería "349727".

Ten en cuenta que algunas ubicaciones pueden tener varias location keys asociadas a ellas, dependiendo de la forma en que se dividen geográficamente.
