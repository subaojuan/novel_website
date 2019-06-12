package org.test.commons;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.xatu.novel.util.MapUtil;

public class MapUtilTest {

	@Test
	public void print() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "111");
		map.put("2", "222");
		map.put("3", "333");
		map.put("4", "444");
		
		MapUtil.foreach(map);
		System.out.println(map.get("6"));
	}
	

	
}
