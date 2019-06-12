package org.xatu.novel.controller;

import redis.clients.jedis.Jedis;

public class test {
    public static void main(String[] args) {
    	//创建Jedis对象
    			Jedis jedis=new Jedis("192.168.43.97", 6379);

    			//设置对象
    			//jedis.set("bangdan", "jedis test");
    			String string=jedis.get("bangdan");
    			System.out.println(string);
    			//关闭jedis
    			jedis.close();	
	}
}
