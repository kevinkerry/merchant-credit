package com.sdp.mc.test;

import net.sf.json.JSONObject;

import org.junit.Test;

public class TestJSON {

	@Test
	public void testString2Json(){
		String str="{\"hasOATxn\":\"1\"}";
		JSONObject json=JSONObject.fromObject(str);
		System.out.println(json.getString("hasOATxn"));
	}
}
