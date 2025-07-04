
# PlaceInfo Microservices Project

This is a modular Spring Boot application that demonstrates a clean architecture for fetching and managing place information.  
It is divided into multiple Maven modules for better separation of concerns.
---


---
## 🚀 Modules

```
PlaceInfo/
├── PlaceInfoApplication/          # Main Spring Boot application (API entry)
├── PlaceInfoRepositoryLib/        # Data access layer (Repositories & Entities)
├── PlaceInfoServiceLib/           # Business logic layer (Services & Mappers)
├── PlaceInfoClientServiceLib/     # External API clients (GeoNames, etc.)
```

---

## 📁 Project Structure

```
PlaceInfo-main/
│
├── PlaceInfoApplication/
│   ├── src/main/java/com/example/PlaceInfoApplication/
│   │   ├── PlaceInfoApplication.java      # Spring Boot entry point
│   │   └── Controller/
│   │       └── PlaceInfoController.java   # REST endpoints
│   └── resources/application.properties
│
├── PlaceInfoRepositoryLib/
│   ├── src/main/java/com/example/repository/
│   │   ├── IPlaceInfoRepository.java      # JPA Repository interfaces
│   │   └── IPlaceRepository.java
│   ├── entity/
│   │   ├── Place.java
│   │   └── PlaceInfo.java                 # JPA entities
│   └── dal/PlaceInfoRepositoryHelper.java
│
├── PlaceInfoServiceLib/
│   ├── src/main/java/com/example/service/
│   │   ├── PlaceInfoAppService.java       # Main business service
│   │   └── mapper/
│   │       └── PlaceInfoServiceMapper.java# DTO mapper
│
├── PlaceInfoClientServiceLib/
│   └── (under development or external API client logic)
│
└── pom.xml files (per module) + parent aggregation
```

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL (configurable)
- Maven multi-module
- RestTemplate (for external GeoNames API calls)

---

## ▶️ How to Run

### 1️⃣ Build
```bash
mvn clean install
```

This will build all modules (`repository`, `service`, `client`, `application`) and create the full package.

### 2️⃣ Run the application
Go to `PlaceInfoApplication` module and start:

```bash
cd PlaceInfoApplication
mvn spring-boot:run
```

By default it will start on `http://localhost:8080`.

---

## 🚀 Example Endpoints

| Endpoint                  | Description                     |
|----------------------------|--------------------------------|
| `GET /db/place?q=istanbul` | Fetch place info from DB       |
| `GET /client/place?q=rome` | Fetch from GeoNames directly   |
| `POST /db/place`           | Save a new place info record   |

---

## 📝 Configuration

Edit `application.properties` in each module as needed, e.g.:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
geonames.username=YOUR_USERNAME
```

---

## ✅ Tests

Each module contains its own test suite under `src/test/java`.

Run all tests via:

```bash
mvn test
```

---

## 📄 License

MIT License. See [LICENSE](./LICENSE) for details.

---

## 🤝 Contributing

Pull requests welcome!  
If you want to propose a feature, open an issue first to discuss.

---

## ✨ Author

- Onur Özcan ([imozcan](https://github.com/imOzcan))
- Çağla Çakır ([imcakir](https://github.com/imCakir))
