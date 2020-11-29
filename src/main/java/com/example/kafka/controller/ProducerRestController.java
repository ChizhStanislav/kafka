package com.example.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("producer")
public class ProducerRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    private void save(String key, String value) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("demo", key, value);
        future.addCallback(System.out::println, System.out::println);
    }
}
