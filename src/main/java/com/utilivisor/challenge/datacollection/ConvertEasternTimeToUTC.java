package com.utilivisor.challenge.datacollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class ConvertEasternTimeToUTC {
	
    static ZoneId europeanZoneId = ZoneId.of("Europe/London");
    static TimeZone europeanTimeZone = TimeZone.getTimeZone("Europe/London"); //Target timezone
	
	private String timeOut;

	String convertTimeToUTC(String timeIn){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa");
        String dateInString = timeIn;

        try {

            Date date = formatter.parse(dateInString);
            formatter.setTimeZone(europeanTimeZone);
            timeOut = formatter.format(date);//GMT UTC

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		return timeOut;
		
	}

}
