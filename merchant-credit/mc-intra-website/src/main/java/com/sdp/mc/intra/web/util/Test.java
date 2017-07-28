package com.sdp.mc.intra.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test {
//	public static void main(String[] args) throws Exception {
//		// 'FROZEN_QUOTA_RESTORE','FROZEN_QUOTA_LIMITATION','FROZEN_QUOTA_USED'
//		List<Map<String, Object>> list=converProper(new File("E:\\ss.txt"));
//		for(Map<String, Object> map:list){
//			System.out.println(map);
//		}
//
//	}
//
//	private static HashMap<String, Object> json2HashMap(String object) {
//		System.out.println(object);
//		HashMap<String, Object> data = new HashMap<String, Object>();
//		// 将json字符串转换成jsonObject
//		JSONObject jsonObject = JSONObject.fromObject(object);
//		Iterator it = jsonObject.keys();
//		// 遍历jsonObject数据，添加到Map对象
//		while (it.hasNext()) {
//			String key = String.valueOf(it.next());
//			Object value = jsonObject.get(key);
//			data.put(key, value);
//		}
//		return data;
//	}

//	public static List<Map<String, Object>> converProper(File file) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf8"));
//		StringBuffer buffer = new StringBuffer();
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		while (br.ready()) {
//			String line = br.readLine();
//			System.out.println(line);
//			if (line != null) {
//				line=line.replaceAll("\"\"", "\"");
//				HashMap<String, Object> map=json2HashMap(line.substring(1,line.length()-1));
//				System.out.println(map);
//				String bizId=map.get("bizId").toString();
//				String forzenLimitation=map.get("forzenLimitation").toString();
//				if(!"null".equals(forzenLimitation)&&!"0".equals(forzenLimitation)){
//					list.add(map);
//				}
//				String bizId=map.get("bizId").toString();
//			}
//		}
//		return list;
//
//	}
}
