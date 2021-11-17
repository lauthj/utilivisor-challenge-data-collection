package com.utilivisor.challenge.datacollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class ExampleDate {

    private static String datestamp;
    static ZoneId newYokZoneId = ZoneId.of("America/New_York");
    static ZoneId europeanZoneId = ZoneId.of("Europe/London");
    static TimeZone europeanTimeZone = TimeZone.getTimeZone("Europe/London"); //Target timezone
	public static void main(String[] argv) {
		
		csvPojo pojo = new csvPojo("10-Jan-21 2:15:00 PM", "first", "second", "third", "fourth", "fifth");
		try {
			datestamp = pojo.getTimeStamp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa");
        String dateInString = datestamp;

        try {

            Date date = formatter.parse(dateInString);
            String zoneId ="America/New_York";
            System.out.println(formatter.format(date));
            formatter.setTimeZone(europeanTimeZone);
            String utcTime = formatter.format(date);//GMT UTC
            System.out.println(utcTime);
            System.out.println("TimeZone : " + newYokZoneId); //Eastern time

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
