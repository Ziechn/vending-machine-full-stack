# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk

# Set working directory
WORKDIR /app

# Copy the rest of your application code
COPY . .

# Make sure mvnw is executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean install

# Command to run your application
CMD ["./mvnw", "spring-boot:run"]