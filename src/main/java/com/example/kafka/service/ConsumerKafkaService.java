package com.example.kafka.service;

import com.example.kafka.entity.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafkaService {

//    @KafkaListener(topics = "topic1")
//    public void listen(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
//    }

//    @KafkaListener(topics = "topic1",
//            containerFactory = "filterKafkaListenerContainerFactory")
//    public void listen(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
//    }

//    @KafkaListener(
//            topicPartitions = @TopicPartition(topic = "topic1",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "1", initialOffset = "0")}),
//            containerFactory = "partitionsKafkaListenerContainerFactory")
//    public void listen(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
//    }

//    @KafkaListener(topicPartitions
//            = @TopicPartition(topic = "topic1", partitions = { "0" }))
//    public void listen(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
//    }

//    @KafkaListener(topicPartitions
//            = @TopicPartition(topic = "topic1", partitions = { "0", "1" }))
//    public void listen(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
    }
}
