package com.chatmate.chatmatechats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ChatmateChatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatmateChatsApplication.class, args);
    }
}
