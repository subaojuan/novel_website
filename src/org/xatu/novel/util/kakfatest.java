package org.xatu.novel.util;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kakfatest {
     public static void main(String[] args) {
    	 Properties props = new Properties();
 		//集群地址，多个服务器用"，"分隔
 		//192.168.43.97
         props.put("bootstrap.servers", "111.18.43.156:9092");
         //key、value的序列化，此处以字符串为例，使用kafka已有的序列化类
         props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
         props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
         //props.put("partitioner.class", "com.kafka.demo.Partitioner");//分区操作，此处未写
         props.put("request.required.acks", "1");
         // 生产者对象
         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
         // 向first发送hello, kafka
         System.out.println("4");
         producer.send(new ProducerRecord<String, String>("bangdan", "123"));
         System.out.println("5");

         producer.close();
	}
}
