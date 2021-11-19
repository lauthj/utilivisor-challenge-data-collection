package com.utilivisor.challenge.datacollection.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.utilivisor.challenge.datacollection.csvPojo;
import com.utilivisor.challenge.datacollection.csvToPojo;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PointHistory {
	public static List<csvPojo> pojoList = new ArrayList<csvPojo>();
	static ObjectMapper objectMapper = new ObjectMapper();
	static List<PointHistory> ppl2;
	
	public static void addList(List list) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		pojoList = csvToPojo.getPojoList();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String arrayToJson = objectMapper.writeValueAsString(pojoList);
		
		// 1. convert JSON array to Array objects
		PointHistory[] pp1 = mapper.readValue(arrayToJson, PointHistory[].class); 	
		
		// 2. convert JSON array to List of objects
		ppl2 = Arrays.asList(mapper.readValue(arrayToJson, PointHistory[].class));
//		for(int i=0;i<ppl2.size();i++){
//		    System.out.println("In PointHistory object :" + ppl2.get(i));
//		}

	}
}