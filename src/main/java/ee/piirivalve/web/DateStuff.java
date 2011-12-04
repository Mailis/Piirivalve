package ee.piirivalve.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStuff {
	public static final Date END_OF_TIME = parseStr("31.12.9999");
	
	public static Date parseStr(String s){
		DateFormat f = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return f.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}
}
