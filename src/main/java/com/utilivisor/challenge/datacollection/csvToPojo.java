package com.utilivisor.challenge.datacollection;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class csvToPojo {
//	private static CSVRecord record;
	TimeZone tz = TimeZone.getTimeZone("Etc/GMT0");
	//head auto detection
	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("./wide-csv-example.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		List<csvPojo> pojoList = new ArrayList<csvPojo>();
		csvPojo pojo = null;
		ObjectMapper objectMapper = new ObjectMapper();
	    //Set pretty printing of json
	    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	    
		for (CSVRecord record : records) {
		    String timeStamp = record.get("timestamp");
		    String first  = record.get("EV_01_15B_2331_SHERIDAN_CONDMT_value");
		    String second = record.get("EV_02_67B_RYAN_HALL_CHW_TON_HR_value");
		    String third = record.get("EV_01_19B_2347_SHERIDAN_CONDMT_value");
		    String fourth = record.get("EV_01_47B_717_UNIVERSITY_CONDMT_value");
		    String fifth = record.get("EV_02_62D_SLIVKA_CON_MT_KLBS_value");
		    
		    pojo = new csvPojo(timeStamp,first,second,third,fourth,fifth);
		    //Convert Eastern time to UTC
		    ConvertEasternTimeToUTC convertTime = new ConvertEasternTimeToUTC();
		    String UTC_Time = convertTime.convertTimeToUTC(pojo.getTimeStamp());
		    
		    pojo.setTimeStamp(UTC_Time);
		    pojo.set_01_15B_2331_SHERIDAN_CONDMT(first);
		    pojo.set_02_67B_RYAN_HALL_CHW_TON_HR(second);
		    pojo.set_01_19B_2347_SHERIDAN_CONDMT(third);
		    pojo.set_01_47B_717_UNIVERSITY_CONDMT(fourth);
		    pojo.set_02_62D_SLIVKA_CON_MT_KLBS(fifth);
		    
		    pojoList.add(pojo);
		    

			
		}
		
		//1. Convert List of pojo objects to JSON
        String arrayToJson = objectMapper.writeValueAsString(pojoList);
        System.out.println("1. Convert List of pojo objects to JSON :");
        System.out.println(arrayToJson);
        
        try {
            FileWriter file = new FileWriter("./output.json");
            file.write(arrayToJson.toString());
            file.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
         System.out.println("JSON file created: ");
	}

}