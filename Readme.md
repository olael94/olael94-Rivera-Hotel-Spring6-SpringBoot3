# Rivera Hotel

This project is a culmination of my hands-on experience following the [LinkedIn Learning course](https://www.linkedin.com/learning/learning-spring-6-with-spring-boot-3/learn-the-premier-framework-for-the-jvm?u=54864305) on Spring 6 and Spring Boot 3. The course, instructed by Frank P Moley III, provided an in-depth exploration of the Spring framework, focusing on rapid web development at an enterprise scale using Spring Boot 3.

## Project Overview

The Rivera Hotel project is a demo application I built using Spring Boot 3. It showcases various features and best practices of the Spring framework, including:

- **Spring Boot**: Simplifies the development of production-ready applications.
- **Spring Data JPA**: Provides easy integration with relational databases.
- **Spring Web**: Facilitates the creation of RESTful web services.
- **Thymeleaf**: A modern server-side Java template engine for web and standalone environments.

## Prerequisites

To run this project, you will need:

- Java 21
- Maven
- Docker

## Getting Started

1. **Clone the repository**:
    ```shell
    git clone https://github.com/your-username/local?currentSchema=LIL
    cd rivera-hotel
    ```

2. **Start PostgreSQL using Docker**: Install [Docker](https://www.docker.com/). Once you have Docker installed and running, Run the following script to start a PostgreSQL database:
    ```shell
    ./bin/postgresql/start_postgres.sh
    ```

3. **Set up environment variables**:
   Use the username, password, and port info (the one used in the docker script line you have just used to create your docker database) to create a file named `EnvVariables.env` in the root directory with the following content:
    ```plaintext
    JDBC_DATABASE_URL=jdbc:postgresql://yourlocalhost:[your-port]/local?currentSchema=LIL
    JDBC_DATABASE_USERNAME=[your-username] (default is postgres)
    JDBC_DATABASE_PASSWORD=[your-script-generated-password]
    ```

4. **Run the application**:
    ```shell
    mvn spring-boot:run
    ```

## Project Structure

- `src/main/java`: Contains the Java source code.
- `src/main/resources`: Contains the application properties and static resources.
- `bin/postgresql`: Contains scripts to manage the PostgreSQL database.
- `pom.xml`: Maven configuration file.

## License

This project is licensed under the MIT License.

## Acknowledgements

- [LinkedIn Learning course](https://www.linkedin.com/learning/learning-spring-6-with-spring-boot-3/learn-the-premier-framework-for-the-jvm?u=54864305) by Frank P Moley III