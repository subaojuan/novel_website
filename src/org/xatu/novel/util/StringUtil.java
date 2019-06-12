package org.xatu.novel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串工具类。
 * 主要对格式为："冯劲松你真帅，36 志哥你真帅，30 默默你真帅，9"  的字符串进行处理。
 * @author Feng
 * 2019年4月26日下午9:24:03
 */
public class StringUtil {

	/**
	 * 截取字符串操作。函数内部调用获取榜单的方法，并将得到的数据截取成指定格式。
	 * @return
	 */
	public static Map<String, String> getTops(){
		String bangDan = RedisUtil.getBangDan();
		String[] strs = bangDan.split(" ");
		// LinkedHashMap支持有序存储=取出
		Map<String, String> map = new LinkedHashMap<String, String>();
		for(String s : strs) {
			String[] data = s.split(",");
			map.put(data[0], data[1]);
		}
		return map;
	}
	
	/**
	 * 将数据库中的CLOB格式数据转换成字符串
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
    public static String ClobToString(Clob clob) throws SQLException, IOException {
        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
	        sb.append(s);
	        s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }
    
    /**
     * 在指定字符串中的句号后，换行。
     * 比如：句号后换行
     *  那天的天气怎样，景耀没有注意，可是那天见到的人却改变了他今后的生活。
     *  景耀是一名a市的高三学生，在这个风骚时代，他一直是默默无闻的，老师不在意，也不招女孩子喜欢，从小到大就没和女孩子说过几句话。
     * @param data
     * @return
     */
    public static List<String> format(String data) {
    	String[] datas = data.split("。");
    	
    	List<String> list = new ArrayList<String>();
    	for (int i = 0; i < datas.length; i++) {
			list.add(datas[i] + "。");
		}
    	return list;
    }
    
    /**
     * 将数据编码格式更改为UTF-8
     * @param value
     * @return
     */
    public static String IOStoUTF8(String value) {
    	String res = null;
    	try {
			res = new String(value.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return res;
    }
    
    
    // 测试
    public static void main(String[] args) {
		System.out.println(format("那天的天气怎样，景耀没有注意，可是那天见到"
				+ "的人却改变了他今后的生活。  景耀是一名a市的高三学生，在这个风骚时代，"
				+ "他一直是默默无闻的，老师不在意，也不招女孩子喜欢，从小到大就没和女"
				+ "孩子说过几句话。然而今天他变了，他居然主动和女生搭讪了。  景耀有一个"
				+ "好基友（当然是不乱搞的那种），叫作马小利。这厮整天就想着玩电脑游戏，老"
				+ "爱玩英雄联盟，马小利还玩qq飞车，什么闪电漂移的说的很棒似的。实际上就骗"
				+ "骗外行。景耀就整天学习，因为他暗恋上了班花～～杨富美。但是女神确老是考"
				+ "试在班里排前十，人家压根就不正眼瞧他。但是这货确实是爱的无法自拔了。于"
				+ "是乎在他的不懈努力下，终于考到了班级第一，然而事情却并不是他想的那样，"
				).get(4));
	}

}
