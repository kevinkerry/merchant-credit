package com.sdp.mc.common.spring.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addSpecificMapping(Date.class, new JsonSerializer<Date>() {
			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
		});
		this.setSerializerFactory(factory);
	}
}
