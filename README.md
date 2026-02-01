# interntracker
Internship tracking REST API built with Spring Boot, JWT, PostgreSQL, MapStruct and pagination support.

# Internship Tracker API

## 🇹🇷 Türkçe
### Proje Amacı
Bu proje, staj başvurularını tek yerde takip etmek için geliştirilmiş bir REST API’dir.
Şirket (Company), Pozisyon (Position) ve Başvuru (Application) kayıtlarını yönetir.

### Özellikler
- Katmanlı mimari (Controller / Service(interface+impl) / Repository)
- PostgreSQL + Spring Data JPA
- DTO + MapStruct
- Validation (@Valid) ve Global Exception Handling
- Pagination / Sorting / Filtering (Applications endpoint)
- Swagger UI dokümantasyonu
- JWT Authentication (Bearer Token)

### Teknolojiler
- Java 21
- Spring Boot (Web, Data JPA, Validation, Security)
- PostgreSQL
- MapStruct
- Springdoc OpenAPI (Swagger)
- JWT (jjwt)

### Kurulum
1) PostgreSQL’de veritabanı oluştur:
    - db: `interntracker`
2) `application.properties` dosyasında kullanıcı/şifreyi ayarla.
3) Projeyi çalıştır:
    - `mvn clean install`
    - `mvn spring-boot:run`

### Swagger
- Swagger UI: `http://localhost:8080/swagger`
- OpenAPI JSON: `http://localhost:8080/api-docs`

### JWT Kullanımı
1) Register:
    - `POST /api/auth/register`
2) Login:
    - `POST /api/auth/login`
    - Response içinden token al
3) Swagger’da “Authorize” butonuna tıkla:
    - `Bearer <TOKEN>`

### Örnek Akış
- Company oluştur → Position oluştur → Application oluştur
- Application listele:
    - `/api/applications?status=APPLIED&page=0&size=10&sort=appliedDate,desc`

---

## 🇬🇧 English
### Project Goal
A REST API to track internship applications in one place.
It manages Companies, Positions and Applications.

### Features
- Layered architecture (Controller / Service(interface+impl) / Repository)
- PostgreSQL + Spring Data JPA
- DTO + MapStruct
- Validation (@Valid) + Global Exception Handling
- Pagination / Sorting / Filtering (Applications endpoint)
- Swagger UI documentation
- JWT Authentication (Bearer Token)

### Tech Stack
- Java 21
- Spring Boot (Web, Data JPA, Validation, Security)
- PostgreSQL
- MapStruct
- Springdoc OpenAPI (Swagger)
- JWT (jjwt)

### Setup
1) Create database in PostgreSQL:
    - db: `interntracker`
2) Configure credentials in `application.yml`.
3) Run:
    - `mvn clean install`
    - `mvn spring-boot:run`

### Swagger
- Swagger UI: `http://localhost:8080/swagger`
- OpenAPI JSON: `http://localhost:8080/api-docs`

### JWT Usage
1) Register:
    - `POST /api/auth/register`
2) Login:
    - `POST /api/auth/login`
    - Get token from response
3) Swagger → Authorize:
    - `Bearer <TOKEN>`
