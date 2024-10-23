# Real-Time Weather Monitoring System

## Overview
This application is a real-time data processing system for monitoring weather conditions using the OpenWeatherMap API. It retrieves weather data for major metros in India, calculates daily aggregates, and provides alerts for specific weather conditions.

## Features
- Real-time weather data retrieval from OpenWeatherMap API.
- Daily weather summaries including average, maximum, and minimum temperatures.
- Alerts for temperature thresholds.
- Easy configuration for city selection and alert thresholds.
- Simple console-based output for weather conditions.

## Technologies Used
- Java 17
- Gson (for JSON parsing)
- JUnit (for testing)

## System Requirements
- Java Development Kit (JDK) 17
- Maven (for dependency management)
- Internet connection (to access the OpenWeatherMap API)

## Dependencies
The following dependencies are required to run the application. You can manage these dependencies using Maven:

### Maven Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
