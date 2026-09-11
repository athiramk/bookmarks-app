FROM eclipse-temurin:21.0.5_11-jre

# 1. This creates a folder named /app and moves inside it
WORKDIR /app

# 2. Now, this copies the jar into /app/app.jar
ADD target/*.jar app.jar

# 3. This touches the file inside /app
RUN sh -c 'touch app.jar'

EXPOSE 8080

# 4. Runs the app from the /app folder
ENTRYPOINT [ "sh", "-c", "java -jar app.jar" ]