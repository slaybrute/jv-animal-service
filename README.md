# Animal Service API

This API provides functionalities for uploading, processing, and retrieving animal records stored in CSV and XML files.
It supports object mapping to POJOs, validation, categorization based on price, and advanced filtering capabilities.

## Features

- **File Upload**: Supports uploading CSV and XML files containing animal data.
- **Data Validation**: Ensures that all records include mandatory fields: name, type, gender, weight, and cost. Records
  missing these fields are ignored.
- **Categorization**: Animals are categorized into four price ranges:
    - Category 1: Price 0-20
    - Category 2: Price 21-40
    - Category 3: Price 41-60
    - Category 4: Price 61 and above
- **Data Retrieval**: Filters and sorts animals based on name, type, sex, weight, cost, category, and any other field
  present in the objects.
- **Persistent Storage**: Implements a storage solution that preserves data across service restarts.

## API Endpoints

### POST `/animals/files/uploads/csv`

Uploads a CSV file containing animal data. Each record must include name, type, gender, weight, and cost.

**Parameters:**

- `file`: A CSV file.

**Response:**

- `200 OK`: File processed successfully, animals stored in the database.
- `400 Bad Request`: File format not supported or missing required fields.

### POST `/animals/files/uploads/xml`

Uploads an XML file containing animal data. Each record must include name, type, gender, weight, and cost.

**Parameters:**

- `file`: An XML file.

**Response:**

- `200 OK`: File processed successfully, animals stored in the database.
- `400 Bad Request`: File format not supported or missing required fields.

### GET `/animals/search`

Retrieves animals based on specified filters and sorting parameters.

**Query Parameters:**

- `names`: Names of animals (optional).
- `types`: Types of animals (optional).
- `sexes`: Sexes of animals (optional).
- `weights`: Weights of animals (optional).
- `costs`: Costs of animals (optional).
- `categories`: Price categories (optional).
- `sort`: Field to sort the results by (optional).

**Response:**

- `200 OK`: Successfully retrieved animals.
- JSON array of animal objects.

## Setup and Installation

### Prerequisites

- Java JDK 17 or newer
- Maven

### Running the API

1. Clone the repository:
   ```bash
   git clone https://github.com/slaybrute/jv-animal-service.git

2. Move to project directory
    ```bash
   cd jv-animal-service/

3. Change application.properties file

 - `Setup connection to your database by modifying the src/main/resources/application.properties file. Ensure the
   database URL, username, and password are correctly configured.`

4. Build project
    ```bash
   mvn clean install

5. Run application
    ```bash
   java -jar target/animal-service-0.0.1-SNAPSHOT.jar
