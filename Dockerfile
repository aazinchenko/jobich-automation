FROM mcr.microsoft.com/playwright/java:v1.48.0-jammy

WORKDIR /app

# Нужен xdpyinfo для xvfb-run — без него xvfb-run зависает навсегда
RUN apt-get update && apt-get install -y x11-utils && rm -rf /var/lib/apt/lists/*

# Копируем pom.xml отдельно — чтобы Docker кэшировал зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем весь проект
COPY . .

CMD ["sh", "-c", "xvfb-run mvn test -DsuiteXmlFile=src/test/resources/testng.xml"]