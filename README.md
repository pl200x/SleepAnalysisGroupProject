# Sleep Analysis

A Spring Boot web app that analyzes a sleep-health dataset and provides personalized insights.

## Requirements

- Java 21
- Maven (or use the bundled `./mvnw`)

## Run

```bash
./mvnw spring-boot:run
```

Then open <http://localhost:8080>.

## Email feature (optional)

To enable the "email me a copy" option, edit `src/main/resources/application.properties` and fill in:

```properties
spring.mail.username=your.address@gmail.com
spring.mail.password=your-app-password
```

You must use a [Gmail App Password](https://support.google.com/accounts/answer/185833), not your regular password. Restart the app after editing.

## Authors

Minqi Huang · Peilin Wang · David M. S. Conselvan
