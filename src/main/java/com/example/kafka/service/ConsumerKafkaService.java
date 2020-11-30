package com.example.kafka.service;

import com.example.kafka.entity.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafkaService {

    @KafkaListener(topics = "topic1", groupId = "1")
    public void listenGroupOne(
            Greeting greeting,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
        System.out.println(String
                .format("Consumer 1 received message: %s with name: %s, key: %s and partition %s",
                        greeting.getMessage(),
                        greeting.getName(),
                        key,
                        partitionId));
    }

    @KafkaListener(topics = "topic1", groupId = "2", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenGroupTwo(
            Greeting greeting,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
        System.out.println(String
                .format("Consumer 2 received message: %s with name: %s, key: %s and partition %s",
                        greeting.getMessage(),
                        greeting.getName(),
                        key,
                        partitionId));
    }

//    @KafkaListener(groupId = "3",
//            topicPartitions = @TopicPartition(topic = "topic1",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "1", initialOffset = "0")}),
//            containerFactory = "partitionsKafkaListenerContainerFactory")
//    public void listenGroupThree(
//            Greeting greeting,
//            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
//        System.out.println(String
//                .format("Consumer 3 received message: %s with name: %s, key: %s and partition %s",
//                        greeting.getMessage(),
//                        greeting.getName(),
//                        key,
//                        partitionId));
//    }

    @KafkaListener(groupId = "4", topicPartitions = @TopicPartition(topic = "topic1", partitions = {"0"}))
    public void listenGroupFour(
            Greeting greeting,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId) {
        System.out.println(String
                .format("Consumer 4 received message: %s with name: %s, key: %s and partition %s",
                        greeting.getMessage(),
                        greeting.getName(),
                        key,
                        partitionId));
    }
}
