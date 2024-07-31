# Use an official Node.js image as the base image
FROM node:20

# Install Java (e.g., OpenJDK 17)
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean;

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Set working directory
WORKDIR /app

# Copy the rest of your application code
COPY . .

# Make sure mvnw is executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean install

# Command to run your application
CMD ["mvnw", "spring-boot:run"]