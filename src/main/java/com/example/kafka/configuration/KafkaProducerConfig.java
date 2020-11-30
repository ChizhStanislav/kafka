package com.example.kafka.configuration;


import com.example.kafka.entity.Greeting;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<Integer, Greeting> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        return new DefaultKafkaProducerFactory<>(configProps, new IntegerSerializer(), new JsonSerializer<>());
    }

    @Bean
    public KafkaTemplate<Integer, Greeting> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
