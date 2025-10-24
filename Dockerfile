# Copy JAR
COPY target/service-0.0.1-SNAPSHOT.jar .

# Expose port
EXPOSE 8080

# Run the app using the original JAR name
ENTRYPOINT ["java","-jar","service-0.0.1-SNAPSHOT.jar"]
