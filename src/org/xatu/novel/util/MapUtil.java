package org.xatu.novel.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * Map工具类。
 * @author Feng
 * 2019年1月18日下午6:21:10
 */
public class MapUtil {

	/**
	 * 遍历Map。
	 * @param map
	 */
	public static <K, V> void foreach(Map<K, V> map) {
		Set<Map.Entry<K,V>> entrySet = map.entrySet();
		K k;
		V v;
		for (Entry<K, V> entry : entrySet) {
			k = entry.getKey();
			v = entry.getValue();
			System.out.println("[" + k + "," + v + "]");
		}
		
		
	}
	
}
