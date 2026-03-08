# Weather App (Spring Boot)

A small Spring Boot application that exposes weather-related endpoints. This project was scaffolded as part of a mini-project and includes a REST controller, service layer, and a simple client module.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Run / Build](#run--build)

# Weather App (Spring Boot)

A small Spring Boot application that exposes weather-related endpoints. It includes a REST controller, service layer, and a simple client that calls an external weather API.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Run / Build](#run--build)
- [Configuration](#configuration)
- [Available Endpoints](#available-endpoints)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Notes & Next Steps](#notes--next-steps)

## Prerequisites

- Java 21 (the project's `pom.xml` targets Java 21)
- Maven (or use the included Maven wrapper)
- (Optional) An API key for the external weather provider (see Configuration)

## Run / Build

This repository has a nested Maven project. From the repo root run the commands inside the inner `weather-app` folder.

From PowerShell (from the repository root):

```powershell
cd weather-app
# Build
.\mvnw.cmd clean package

# Run with the Maven wrapper
.\mvnw.cmd spring-boot:run

# Or run the packaged jar (after build)
java -jar target\*.jar
```

If you have Maven installed system-wide, you can run the `mvn` equivalents inside the `weather-app` folder.

## IDE (IntelliJ IDEA)

If you use IntelliJ IDEA (Community or Ultimate), here are quick steps to open and run the project:

1. Open IntelliJ and choose "Open" then select the `weather-app` folder (the inner folder with `pom.xml`).
2. IntelliJ will detect it's a Maven project and import the dependencies. If it doesn't, right-click `pom.xml` and choose "Add as Maven Project".
3. To run the application from the IDE:

- Open `src/main/java/com/miniproject/weather_app/WeatherAppApplication.java` and click the green Run icon next to the `main` method, or
- Create a new "Application" run configuration: set the main class to `com.miniproject.weather_app.WeatherAppApplication` and use the project SDK (Java 21).

4. If you need to provide the external API key locally during development, add it to `Run/Debug Configuration -> Environment variables` (for example: `WEATHER_API_KEY=your_key`) or add it to `weather-app/src/main/resources/application.properties` (but avoid committing secrets).
5. IntelliJ will show the `.idea/` folder in the project root (this repo already contains an `.idea` folder). You can keep it local or add it to `.gitignore` depending on your team preferences.

These steps let you iterate quickly inside the IDE without using the Maven wrapper from the terminal.

## Configuration

Application configuration lives in `weather-app/src/main/resources/application.properties`.

Important configuration items:

- External API key for the weather provider. NOTE: the current implementation in `Client.java` contains a hard-coded API key (not recommended). Move this value into `application.properties` or supply via environment variable and reference it in `Client`.
- Server port (e.g., `server.port=8080`)
- Any client-specific timeouts or base URLs

Do not commit secrets to source control. Use environment variables, a secrets manager, or external configuration for sensitive values.

## Available Endpoints

The application exposes the following endpoint (from the real controller code):

- GET /api/v1/weather/temp?cityName=<cityName>

Description: Returns the current weather information for the specified city. The implementation proxies a call to WeatherAPI's `current.json` endpoint and returns the JSON response.

Example request:

```http
GET /api/v1/weather/temp?cityName=London HTTP/1.1
Host: localhost:8080
```

Response: the JSON body returned by the external weather API (see `clients/Client.java`), typically including location and current conditions.

## Project Structure

Key locations (relative to the repo root):

- `weather-app/src/main/java/com/miniproject/weather_app/` — application sources
  - `clients/` — external API client(s) (e.g., `Client.java`)
  - `controllers/` — REST controllers (`WeatherController.java`)
  - `services/` — business logic (`WeatherService.java`)
- `weather-app/src/main/resources/` — application resources and properties
- `weather-app/src/test/java/` — unit/integration tests
- `weather-app/pom.xml` — build configuration for the inner project
