package com.utilivisor.challenge.datacollection.web;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.utilivisor.challenge.datacollection.csvPojo;
import com.utilivisor.challenge.datacollection.csvToPojo;

public class PointHistory {
	public static List<csvPojo> pojoList = new ArrayList<csvPojo>();
	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static void addList(List list) throws JsonProcessingException {
		pojoList = csvToPojo.getPojoList();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String arrayToJson = objectMapper.writeValueAsString(pojoList);
	}

}
