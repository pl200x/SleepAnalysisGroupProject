# Sleep Analysis

A Spring Boot web app that analyzes a sleep-health dataset and provides both population-level analytics and personalized sleep insights from a short user intake form.

Built for the Columbia *Programming in Java* group project.

## Stack

- **Backend** — Java 21, Spring Boot 4.0.6 (`spring-boot-starter-webmvc`, `spring-boot-starter-mail`)
- **Frontend** — single-file `index.html` served as a static asset, Tailwind v4 (browser CDN), Chart.js 4.4.6 (CDN), vanilla JS — no build step
- **Data** — `src/main/resources/data/SleepHealthDataset.csv` (loaded lazily into memory on the first API request)

## Requirements

- Java 21
- Maven (or use the bundled `./mvnw`)

## Run

```bash
./mvnw spring-boot:run
```

Then open <http://localhost:8080>.

## Project layout

```
src/main/java/com/example/SleepAnalysis/
  SleepAnalysisApplication.java       Spring Boot entrypoint
  controller/                         REST endpoints
    cmd/UserInputCMD.java             intake form DTO
    VO/                               response DTOs (each wraps a BaseVO + payload)
  service/                            interfaces
  service/impl/                       implementations
  entity/                             domain + analysis result models
  util/CsvDataLoader.java             CSV → List<SleepRecord>
  exception/                          custom exceptions
src/main/resources/
  application.properties              Spring + SMTP config
  data/SleepHealthDataset.csv         dataset
  static/index.html                   frontend
```

## API

All responses are wrapped in a `BaseVO { code, time, success, errorMessage }` envelope plus a payload. `time` is the request duration in ms, measured by the controller.

| Method | Path | Description |
|---|---|---|
| `GET` | `/sleep_data/launch` | Loads the CSV into memory; returns the record count. |
| `GET` | `/sleep_data/summary` | Dataset-wide averages: sleep duration, sleep quality, stress level. |
| `GET` | `/analysis/summary` | Full analytics: grouped results by stress level, activity tier, and BMI category. |
| `POST` | `/personal/analyze` | Personalized sleep insight for a single user (JSON body: `UserInputCMD`). |
| `POST` | `/personal/analyze-and-email` | Same as `/personal/analyze`, plus emails the report. Requires `?email=<address>` query param. |

### `UserInputCMD` (request body for `/personal/*`)

```json
{
  "gender": "Male",
  "age": 30,
  "occupation": "Engineer",
  "sleepDuration": 7.0,
  "physicalActivityLevel": 60,
  "stressLevel": 5,
  "bmiCategory": "Normal",
  "bloodPressure": "120/80",
  "heartRate": 70,
  "dailySteps": 8000
}
```

## How analysis works

### Population analytics — `/analysis/summary`

`AnalysisServiceImpl` groups records three ways and returns aggregates per group:

- **Stress** — grouped by integer stress level. Per group: count, avg sleep quality, avg sleep duration.
- **Activity tier** — derived from physical activity level: `<40` Low, `40–60` Medium, `>60` High. Per group: count, avg quality, avg duration.
- **BMI** — grouped by BMI category. Per group: count, avg quality, **disorder rate** (fraction of records with a non-`None` `sleepDisorder`). `Normal Weight` is normalized to `Normal` so the two CSV variants merge into one bucket.

### Personal insight — `/personal/analyze`

`PersonalInsightServiceImpl` does the following:

1. **Find a similar cohort** in the dataset: age within ±5, same BMI category (case-insensitive), stress level within ±1.
2. **Estimated sleep quality** — averaged across that cohort. If no one matches, it falls back to the dataset-wide average.
3. **Quality category** — `≥8` High, `≥6` Medium, otherwise Low.
4. **Risk factors** — flagged when the user is worse than the dataset average on stress, activity, or sleep duration; or when heart rate ≥ 80; or BMI is Overweight/Obese.
5. **Recommendations** — rule-based on the user's own input (high stress → relaxation; low activity → exercise; short sleep → aim for 7–8 hrs; low daily steps → walk more).

The response includes the estimated quality, category, cohort size, and the two lists.

## Frontend

`src/main/resources/static/index.html` is the entire UI:

- Fetches `/analysis/summary` on load and renders three Chart.js charts (stress, activity, BMI).
- Posts the intake form to `/personal/analyze` (or `/personal/analyze-and-email`) and renders the result in place.
- Tailwind v4 is loaded via the browser CDN — styles compile at runtime, so an internet connection is required.

## Email feature (optional)

To enable the "email me a copy" option, edit `src/main/resources/application.properties` and fill in:

```properties
spring.mail.username=your.address@gmail.com
spring.mail.password=your-app-password
```

You must use a [Gmail App Password](https://support.google.com/accounts/answer/185833), not your regular password. Restart the app after editing.

## Dataset

`SleepHealthDataset.csv` — 13 columns: `Person ID, Gender, Age, Occupation, Sleep Duration, Quality of Sleep, Physical Activity Level, Stress Level, BMI Category, Blood Pressure, Heart Rate, Daily Steps, Sleep Disorder`. `CsvDataLoader` parses the file with a plain `BufferedReader` and `String.split(",")` and returns a `List<SleepRecord>`; `SleepDataServiceImpl` triggers the load on the first API request that needs data.

## Authors

Minqi Huang · Peilin Wang · David M. S. Conselvan
