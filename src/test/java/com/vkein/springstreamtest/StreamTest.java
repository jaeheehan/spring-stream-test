package com.vkein.springstreamtest;

import com.vkein.springstreamtest.stream.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;

@SpringBootTest
public class StreamTest {

    @Autowired
    @Qualifier("messageProcessor")
    private Consumer<Event<Integer, String>> messageProcessor;


    @Test
    public void sendMessage() {
        messageProcessor.accept(new Event<>(Event.Type.CREATE, 1, "data"));
    }

}
