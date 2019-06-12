package org.test.kafka;

import org.junit.Test;
import org.xatu.novel.util.KafkaProductor;
import org.xatu.novel.util.RedisUtil;
import org.xatu.novel.util.StringUtil;

import redis.clients.jedis.Jedis;





public class KafkaTest {

	/**
	 * 测试:发送字符串到kafka
	 */
	@Test
	public void test() {
		for (int i = 0; i < 12; i++) {
			KafkaProductor.producer("斗破苍穹");	
		}
		for (int i = 0; i < 4; i++) {
			KafkaProductor.producer("钢铁侠");	
		}
		for (int i = 0; i < 7; i++) {
			KafkaProductor.producer("神雕");	
		}
		for (int i = 0; i < 9; i++) {
			KafkaProductor.producer("蟒蛇传");	
		}
		for (int i = 0; i < 11; i++) {
			KafkaProductor.producer("倚天屠龙记");	
		}
		for (int i = 0; i < 1; i++) {
			KafkaProductor.producer("天龙八部");	
		}
		
		
	}
	/**
	 * 测试:发送字符串到kafka
	 */
	@Test
	public void test3() {
		for (int i = 0; i < 40; i++) {
			KafkaProductor.producer("默默你真帅");	
		}
		
	}
	
	@Test
	public void test5() {
		//创建Jedis对象
				Jedis jedis=new Jedis("192.168.43.97", 6379);

				String string=jedis.get("bangdan");
				System.out.println(string);
				//关闭jedis
				jedis.close();	
	}
	
	
	/**
	 * 测试连接到redis
	 */
	@Test
	public void test1() {
		System.out.println(RedisUtil.getBangDan());
	}
	
	
	@Test
	public void test4() {
		System.out.println(StringUtil.getTops());
	}
	
	// 问题1：jdk版本与kafka运行的环境不一致。
	// 解决，找了低版本支持jdk1.7的kafka的jar
	/**
	 * java.lang.UnsupportedClassVersionError: org/apache/kafka/common/serialization/StringSerializer : Unsupported major.minor version 52.0
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:800)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:449)
	at java.net.URLClassLoader.access$100(URLClassLoader.java:71)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:361)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:355)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:354)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:425)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
	at org.xatu.novel.util.KafkaProductor.producer(KafkaProductor.java:27)
	at org.test.kafka.KafkaTest.test(KafkaTest.java:10)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:44)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:41)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:69)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:48)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:292)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:541)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:763)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:463)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:209)
	 */
}
