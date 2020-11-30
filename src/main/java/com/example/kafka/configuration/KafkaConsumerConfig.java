package com.example.kafka.configuration;

import com.example.kafka.entity.Greeting;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${kafka.groupId}")
    private String groupId;

    @Bean
    public ConsumerFactory<Integer, Greeting> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        return new DefaultKafkaConsumerFactory<>(props, new IntegerDeserializer(), new JsonDeserializer<>(Greeting.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, Greeting> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, Greeting> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<Integer, Greeting>
//    filterKafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<Integer, Greeting> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setRecordFilterStrategy(
//                record -> record.value().contains("World"));
//        return factory;
//    }
}
