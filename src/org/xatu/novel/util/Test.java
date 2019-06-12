package org.xatu.novel.util;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Test {
	public static void main(String[] args) {
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "192.168.1.125:9092");
	    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	 
	    Producer<String, String> producer = new KafkaProducer<>(props);
	    for(int i = 0; i < 100; i++)
	      producer.send(new ProducerRecord<>("bangdan", Integer.toString(i), Integer.toString(i)));
	 
	    producer.close();
	  }

}
