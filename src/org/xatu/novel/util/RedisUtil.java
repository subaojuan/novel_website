package org.xatu.novel.util;

import redis.clients.jedis.Jedis;

/**
 * 对Redis进行操作。
 * @author Feng
 * 2019年4月26日下午8:37:23
 */
public class RedisUtil {

	/**
	 * 获取榜单数据。
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String getBangDan() { 
		// 获取存储的数据并返回
		return new Jedis("127.0.0.1").get("bangdan");
	}
}
