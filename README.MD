# Book Management API

This API allows you to manage books and authors, ensuring that authors are not duplicated. When adding books, the authors are either created or linked to existing ones.

## Prerequisites

Before you can run the project, make sure you have the following installed:

- Java 11 or higher
- Maven
- PostgreSQL (or any other database if you change the connection configuration)
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Postman (for testing APIs)

## Setup and Installation

### Step 1: Clone the Repository

```bash
git clone <repository-url>
```

### Step 2: Configure Database

1. **Set up PostgreSQL Database**:

   Ensure PostgreSQL is running and create a new database.

   ```bash
   CREATE DATABASE book_management;
   ```

2. **Update `application.properties`**:

   Open the `src/main/resources/application.properties` file and configure your database connection:

   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/book_management
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### Step 3: Build the Project

You can build the project using Maven.

```bash
mvn clean install
```

### Step 4: Run the Project

To run the Spring Boot application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on port `8080` by default.

---
## Users
**Admin**:
**Username**:`admin`
**PassWord**:`admin123`

**User**:
**Username**:`user`
**PassWord**:`user123`
---
## API Endpoints

### 1. **Create a Book**

- **URL**: `/books`
- **Method**: `POST`
- **Request Body**:

```
{
  "isbn": "1234567890",
  "title": "Spring Boot in Action",
  "year": 2021,
  "price": 499.99,
  "genre": "Technology",
  "authors": [
    {
      "name": "Craig Walls",
      "birthday": "1975-08-20"
    }
  ]
}
```

- **Response**:

```bash
{
  "isbn": "1234567890",
  "title": "Spring Boot in Action",
  "year": 2021,
  "price": 499.99,
  "genre": "Technology",
  "authors": [
    {
      "id": 1,
      "name": "Craig Walls",
      "birthday": "1975-08-20"
    }
  ]
}
```

### 2. **Get All Books**

- **URL**: `/books/all`
- **Method**: `GET`
- **Response**:

```bash
[
  {
    "isbn": "1234567890",
    "title": "Spring Boot in Action",
    "year": 2021,
    "price": 499.99,
    "genre": "Technology",
    "authors": [
      {
        "id": 1,
        "name": "Craig Walls",
        "birthday": "1975-08-20"
      }
    ]
  },
  {
    "isbn": "978-1-23-456789-0",
    "title": "Java Programming",
    "year": 2023,
    "price": 39.99,
    "genre": "Programming",
    "authors": []
  }
]
```

### 3. **Get Book by title**

- **URL**: `/books/{title}`
- **Method**: `GET`
- **Parameters**: `title` (Path parameter)
- **Response**:

```bash
{
  "isbn": "1234567890",
  "title": "Spring Boot in Action",
  "year": 2021,
  "price": 499.99,
  "genre": "Technology",
  "authors": [
    {
      "id": 1,
      "name": "Craig Walls",
      "birthday": "1975-08-20"
    }
  ]
}
```

### 4. **Update a Book**

- **URL**: `/books/{title}`
- **Method**: `PUT`
- **Parameters**: `title` (Path parameter)
- **Request Body**:

```bash
{
  "isbn": "1234567890",
  "title": "Spring Boot in Action - Updated",
  "year": 2022,
  "price": 499.99,
  "genre": "Technology",
  "authors": [
    {
      "name": "Craig Walls",
      "birthday": "1975-08-20"
    }
  ]
}
```

- **Response**:

```bash
{
  "isbn": "1234567890",
  "title": "Spring Boot in Action - Updated",
  "year": 2022,
  "price": 499.99,
  "genre": "Technology",
  "authors": [
    {
      "id": 1,
      "name": "Craig Walls",
      "birthday": "1975-08-20"
    }
  ]
}
```

### 5. **Delete a Book**

- **URL**: `/books/delete/{title}`
- **Method**: `DELETE`
- ***Role**: Admin
- **Parameters**: `title` (Path parameter)
- **Response**:

```bash
{
  "message": "Book deleted successfully"
}
```






---

## Error Handling

The API will return the following error responses in case of invalid input:

- **400 Bad Request**: When the request body is malformed or missing required fields.
- **404 Not Found**: When the requested resource (book or author) is not found.
- **500 Internal Server Error**: If something goes wrong on the server side.

---

## Conclusion

This API allows you to create, read, update, and delete books and authors while ensuring that authors are not duplicated. The system uses a `Many-to-Many` relationship between books and authors, so authors can be linked to multiple books.
