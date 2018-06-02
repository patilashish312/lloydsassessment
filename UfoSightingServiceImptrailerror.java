package app.lloyds.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import oracle.net.aso.b;

public class UfoSightingServiceImptrailerror implements UfoSightingService {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		/*System.out.println("Please provide full UFO file path for process:");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		char[] chararr=new char[Integer.MAX_VALUE];
		BufferedReader bReader = new BufferedReader(
				new FileReader(filePath));
		*/
		Date date=new Date();
		Map<String, String> map=new HashMap<String, String>();
		map.put("20180101","null1");
		map.put("20180102", "null2");
		map.put("20180202", "null3");
		//System.out.println(map);
		//System.out.println(date);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		//System.out.println(dateFormat.format(date));
		//Calendar calendar=dateFormat.getCalendar();
		//System.out.println(calendar.get(Calendar.YEAR));
		//System.out.println(calendar.get(Calendar.MONTH));
		//System.out.println(calendar.get(Calendar.DATE));
		/*System.out.println(dateFormat.getCalendar().get(Calendar.YEAR));
		System.out.println(dateFormat.getCalendar().getMaximum(Calendar.MONTH));
		*/
		
		List<Date> d=new ArrayList<Date>();
		List<String> s=new ArrayList<String>();
		List<StringBuilder> s1=new ArrayList<StringBuilder>();
		//Collections.copy(s1, s);
		//d.add(dateFormat.parse("20180101"));
		//d.add(dateFormat.parse("20180102"));
		//d.add(dateFormat.parse("20180103"));
		d.add(dateFormat.parse("20180104"));
		d.add(dateFormat.parse("20180201"));
		d.add(dateFormat.parse("20181201"));
		d.add(dateFormat.parse("00000000"));
		Calendar calendar=Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.MONTH,Calendar.DECEMBER);
		List<Long> d2=new ArrayList<Long>();
		Calendar cal2=Calendar.getInstance();
		
		for(Date date2: d){
			cal2.setTime(date2);
			d2.add(cal2.getTimeInMillis());
		}		
		if(d2.contains(calendar.getTimeInMillis()))
		{
			System.out.println("inside if");
			System.out.println(d2);
			System.out.println(calendar.getTimeInMillis());
		}
	}

	@Override
	public List<UfoSighting> getAllSightings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UfoSighting> search(int yearSeen, int monthSeen) {
		// TODO Auto-generated method stub
		return null;
	}

}
