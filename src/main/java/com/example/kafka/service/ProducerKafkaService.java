package com.example.kafka.service;

import com.example.kafka.entity.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@RequiredArgsConstructor
public class ProducerKafkaService {

    private final KafkaTemplate<Integer, Greeting> kafkaTemplate;

    public void save(Integer key, Greeting greeting) {
        ListenableFuture<SendResult<Integer, Greeting>> future = kafkaTemplate.send("topic1", key, greeting);
//        future.addCallback(System.out::println, System.out::println);
    }
}
