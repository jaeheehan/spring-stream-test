package com.vkein.springstreamtest.stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageProcessorConfig {

    @Bean
    public Consumer<Event<Integer, String>> messageProcessor(){
        return event -> {
            System.out.println("Process message created at " + event.getEventCreatedAt());
            switch (event.getEventType()) {
                case CREATE:
                    System.out.println("Create product with ID: " + event.getData());
                    break;
                case DELETE:
                    System.out.println("Delete product with ID: " + event.getKey());
                    break;
                default:
                    throw new RuntimeException("Incorrect event type: " + event.getEventType() + ", expected a CREATE or DELETE event");
            }
            System.out.println("Message processing done!");
        };
    }
}
