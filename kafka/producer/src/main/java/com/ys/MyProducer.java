package com.ys;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * created by yuans on 2019/12/10
 **/
public class MyProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.16.9.216:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"MyKafkaProducerDemo");
        props.put(ProducerConfig.ACKS_CONFIG,"-1");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer<Integer, String> producer = new KafkaProducer<>(props);
        int i  = 0;
        while(true){
            RecordMetadata myTopic = producer.send(new ProducerRecord<Integer, String>("myTopic", "my-record-test" + i++)).get();
            System.out.println(myTopic.offset() + "-->" + myTopic.partition());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        producer.close();
    }
}
