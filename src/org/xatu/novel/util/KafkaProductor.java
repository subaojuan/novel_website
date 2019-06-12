package org.xatu.novel.util;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * 传送数据到Kafka。
 * 要求：使用kafka-clients-2.0.0.jar。
 * 连接指定ip、端口
 * @author Feng
 * 2019年4月26日下午7:17:18
 */
public class KafkaProductor {

	/**
	 * 将参数{@code novelName}发送到kafka中。
	 * @param novelName
	 */
	public static void producer(String novelName) {
		Properties props = new Properties();
		//集群地址，多个服务器用"，"分隔
		//192.168.43.97
        props.put("bootstrap.servers", "127.0.0.1:9092");
        //key、value的序列化，此处以字符串为例，使用kafka已有的序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //props.put("partitioner.class", "com.kafka.demo.Partitioner");//分区操作，此处未写
        props.put("request.required.acks", "1");
        // 生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        // 向first发送hello, kafka
        producer.send(new ProducerRecord<String, String>("bangdan", novelName));

        producer.close();
	}
	
	
}
