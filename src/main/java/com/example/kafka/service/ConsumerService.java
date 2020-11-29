package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "demo")
//    @KafkaListener(
//            topicPartitions = @TopicPartition(topic = "demo",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "3", initialOffset = "0")}),
//            containerFactory = "partitionsKafkaListenerContainerFactory")

//    @KafkaListener(topicPartitions
//            = @TopicPartition(topic = "demo", partitions = { "0", "1" }))
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
        System.out.printf("Received message: %s from partition: %s with key: %s", message, partition, key);
    }
}
