package com.example.streaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StreamingApplication extends SpringBootServletInitializer {

    // For deploying to external Tomcat
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StreamingApplication.class);
    }

    // For running locally (e.g., `mvn spring-boot:run`)
    public static void main(String[] args) {
        SpringApplication.run(StreamingApplication.class, args);
    }
}
