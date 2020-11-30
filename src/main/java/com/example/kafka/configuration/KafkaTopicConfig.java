package com.example.kafka.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaTopicConfig {


    /*$ bin/kafka-topics.sh --create \
            --zookeeper localhost:2181 \
            --replication-factor 1 --partitions 1 \
            --topic topic*/


    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("topic1")
                .partitions(2)
                .replicas(1)
//                .compact()
                .build();
    }


//    @Bean
//    public NewTopic topic2() {
//        return TopicBuilder.name("topic2")
//                .partitions(10)
//                .replicas(3)
//                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
//                .build();
//    }
//
//    @Bean
//    public NewTopic topic3() {
//        return TopicBuilder.name("topic3")
//                .assignReplicas(0, Arrays.asList(0, 1))
//                .assignReplicas(1, Arrays.asList(1, 2))
//                .assignReplicas(2, Arrays.asList(2, 0))
//                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
//                .build();
//    }

}
