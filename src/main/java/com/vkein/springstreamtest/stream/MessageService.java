package com.vkein.springstreamtest.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final StreamBridge streamBridge;

    public void sendMessage(Event.Type eventType, Integer key, String data) {
        streamBridge.send("products-out-0", new Event<>(eventType, key, data));
    }


}
