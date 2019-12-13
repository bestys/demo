package com.ys;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * created by yuans on 2019/12/10
 **/
public class MyConsumer {
    public static void main(String[] args) {
//        System.out.println(Math.abs("MyKafkaConsumerDemo".hashCode())%50);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.9.216:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"MyKafkaConsumerDemo");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        Consumer<Integer, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singleton("myTopic"));
        while(true){
            ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord record : records){
                System.out.println("consumer: " + record.value());
            }
        }
//        consumer.close();
    }
}
