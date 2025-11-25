# Examinationsuppgift 3 – REST Web Services (D0031N)

Detta projekt är en prototyp som visar hur **REST-baserade webbtjänster** kan användas för att registrera studieresultat i enlighet med en **Service-Oriented Architecture (SOA)**.  
Applikationen bygger vidare på det tidigare arbetet med *Administration av studieresultat* och implementerar en fungerande version av den föreslagna målarkitekturen.

---

## Översikt

Systemet består av tre webbtjänster + ett GUI (Swagger):

| Komponent | Funktion | Endpoint-exempel |
|------------|-----------|------------------|
| **Epok-service** | Hämtar kursmoduler för en kurskod | `GET /epok/modul/{kurskod}` |
| **StudentITS-service** | Hämtar personnummer baserat på studentens användarnamn | `GET /studentits/personnummer/{anv}` |
| **Ladok-service** | Tar emot och registrerar studieresultat | `POST /ladok/resultat` |
| **Swagger UI** | Webbaserat gränssnitt för att testa API:erna | `http://localhost:8080/swagger-ui.html` |
| **H2 Console** | Inbyggd databasvy | `http://localhost:8080/h2` |

Alla delar körs i **ett och samma Spring Boot-projekt**, men simulerar separata system.

---

## Teknologier

| Typ | Teknik |
|------|--------|
| **Språk** | Java 17 |
| **Ramverk** | Spring Boot |
| **Moduler** | Spring Web, Spring Data JPA, Spring Validation |
| **Databas** | H2 (in-memory) |
| **Dokumentation / Test** | Springdoc OpenAPI (Swagger UI) |
| **Kodbibliotek** | Lombok |
| **Testning** | JUnit 5 |
| **Byggverktyg** | Maven |

---

## Kom igång

### 1. Klona projektet
```bash
git clone https://github.com/Fabbediklabbe/soa-ladok-projekt.git
cd studieresultat
```

### 2. Bygg och starta
```bash
./mvnw spring-boot:run
```

### Applikationen körs nu på "lokalhost:8080"

### 3. Öppna Swagger (API-gränssnitt)
```bash
http://localhost:8080/swagger-ui.html
```

## H2 Console (Databas)

### 1. Gå till http://localhost:8080/h2

### 2. Fyll i följande
```bash
JDBC URL: jdbc:h2:mem:studieresultat
User Name: sa
Password: (lämna tomt)
```

### 3. Klicka **Connect**

Exempel på SQL kommandon:
```bash
SELECT * FROM MODULES;
SELECT * FROM STUDENTS;
SELECT * FROM RESULTS;
```