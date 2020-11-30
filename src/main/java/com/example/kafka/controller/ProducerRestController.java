package com.example.kafka.controller;

import com.example.kafka.entity.Greeting;
import com.example.kafka.service.ProducerKafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("producer")
public class ProducerRestController {

    private final ProducerKafkaService producerKafkaService;

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@PathVariable("id") Integer id, @RequestBody Greeting greeting) {
        producerKafkaService.save(id, greeting);
    }
}
