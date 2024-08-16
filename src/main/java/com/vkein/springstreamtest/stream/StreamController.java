package com.vkein.springstreamtest.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StreamController {

    private final MessageService messageService;

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "test";
    }

    @PostMapping("/test")
    public void testPost(@RequestBody String body) {
        log.info("testPost");
        messageService.sendMessage(Event.Type.CREATE, 1, body);
    }

}
