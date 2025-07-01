
# PlaceInfo Microservices Project

This project is a **Java Spring Boot microservices application** that integrates with the **GeoNames Wikipedia Search API**, stores location-related data in a database, and exposes client endpoints to retrieve or search this data.

---

##  Features

 **GeoNames Wikipedia Search API Integration**
- Fetches place information from [GeoNames](http://www.geonames.org/wikipedia.html) based on keywords.

 **Database Caching Layer**
- Checks if requested data exists in the local database.
- If not found, retrieves from GeoNames API, saves into the database, then returns to client.

 **Keyword-based Search**
- Allows clients to perform keyword-based searches directly on locally stored data without calling the external service.

 **Layered Architecture**
- Separation of concerns with clear Controller, Service, Repository layers.
- Dedicated external client service library to handle GeoNames API calls.

---

## 🏗 Project Structure

```
.
├── PlaceInfoApplication          # Main Spring Boot application
│   ├── src/main/java/com/example
│   │   └── PlaceInfoApplication
│   │       ├── Controller        # REST Controllers
│   │       └── ...               # Main app classes
│   └── src/main/resources
│       └── application.properties
│
├── PlaceInfoClientServiceLib     # External service client library
│   ├── src/main/java/com/example/client/placeInfo
│   │   ├── PlaceInfoClient       # Handles HTTP calls to GeoNames
│   │   ├── config                # RestTemplate configuration
│   │   └── dto                   # Data transfer objects
│   └── src/main/resources
│
├── pom.xml                       # Maven multi-module configuration
├── .gitignore
└── README.md

....
```

---

## ⚙️ How it works

1️⃣ **Client makes a request**
- Either to get data by keyword or to perform a local search.

2️⃣ **Check local database**
- If data exists, returns immediately.

3️⃣ **Else, call GeoNames API**
- Retrieves data, saves into DB, then returns to the client.

---

##  Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA / Hibernate**
- **H2 / PostgreSQL** (or your preferred DB)
- **RestTemplate / WebClient** for external API calls
- **Maven** multi-module build
- **IntelliJ IDEA** (recommended IDE)

---

## Running the project

Make sure you have Java & Maven installed.



## 📝 License

This project is licensed under the MIT License.  
See [LICENSE](LICENSE) file for details.

---

## 🙌 Contributing

PRs are welcome!  
Feel free to fork, clone, and create pull requests.

---