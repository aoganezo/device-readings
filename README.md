# device-readings Service
A service for processing device readings and surfacing information about past readings.
The service includes 3 APIs:
- `/device/readings`
- `/device/readings/{deviceId}/latest/timestamp`
- `/device/readings/{deviceId}/count`

 ### Running the service
1. Java 21 can be installed via `brew install openjdk@21` if brew is available, or reference java documentation.
2. Run `./gradlew clean build` to install dependencies like Spring Boot
3. Run the service either via `./gradlew bR`, or however you start your Java applications. It will start on port 8080 by default.
4. Test via postman, or your preferred method of testing APIs. Healthcheck is available at `localhost:8080/actuator/health`
5. Once running you can check available data by connecting to the [h2 console](http://localhost:8080/h2-console/). No password is needed, just hit connect.
6. NOTE: This project uses slf4j for access to easy logging and Spring Data JPA for easy data querying.

### Sending device readings 
1. Use a POST call to `localhost:8080/device/readings`
2. Use a JSON body. Sample:
```
{
    "id": "36d5658a-6908-479e-887e-a949ec199272",
    "readings": [
        {
        "timestamp": "2024-09-29T16:08:15+01:00",
        "count": 2
        },
        {
        "timestamp": "2024-09-29T16:09:15+01:00",
        "count": 15
        }
    ]
}
```

### Reading the latest timestamp from past sent queries
1. Use a GET call to `localhost:8080/device/readings/36d5658a-6908-479e-887e-a949ec199272/latest/timestamp`
2. You need to use a UUID from a created reading.

### Reading the cumulative count for all readings from a previous upload
1. Use a GET call to `localhost:8080/device/readings/36d5658a-6908-479e-887e-a949ec199272/count`
2. You need to use a UUID from a created reading.

### Assumptions Made
1. Timestamp and Count will always be available for a given device ID.
2. No database persistence is required.

### Project Structure
The project includes a lot of boilerplate Spring Boot + Gradle files to get it up and running. Within that, the `/src/main/java`
directory holds the main service code and its properties. In `src/main/java/bright/device/reader` we have 4 directories,
- controller: to store our controllers for our APIs. No business logic is performed here.
- model: holds our data model for requests and responses.
- repository: holds our database repository and the code we use to interface with it, along with the database entities (separate from the data models).
- service: holds our services for business logic.