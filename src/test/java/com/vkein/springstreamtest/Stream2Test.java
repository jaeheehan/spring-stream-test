package com.vkein.springstreamtest;

import com.vkein.springstreamtest.stream.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;

@SpringBootTest
@Import({TestChannelBinderConfiguration.class})
public class Stream2Test {

    @Autowired
    private OutputDestination target;

    @Autowired
    private StreamBridge streamBridge;

    @Test
    void publishMessageTest(){

        streamBridge.send("productsTest-out-0", new Event<>(Event.Type.CREATE, 1, "test"));
        Message<byte[]> message = target.receive(0, "products-test");
        System.out.println(new String(message.getPayload()));
    }


}
