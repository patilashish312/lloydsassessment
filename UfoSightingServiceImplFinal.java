package app.lloyds.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;


public class UfoSightingServiceImplFinal implements UfoSightingService {

	/**
	 * @param args
	 */
	private Map<Date, List<UfoSighting>> parser() throws Exception {
		Map<Date, List<UfoSighting>> map = new HashMap<Date, List<UfoSighting>>();
		List<UfoSighting> ls1 = new ArrayList<UfoSighting>();
		Date dateseen;
		Date daterep;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String regex = "^((19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])$";
		Calendar calendar = Calendar.getInstance();
		System.out.println("Please provide full file path for parse:");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		int fieldNo = UfoSighting.class.getDeclaredFields().length;
		String datavalue[] = new String[fieldNo];
		Calendar calendar3 = Calendar.getInstance();
		Date datekey;
		BufferedReader bReader = new BufferedReader(new FileReader(filePath));
		int c;
		StringBuilder builder = new StringBuilder();
		while ((c = bReader.read()) != -1) {
			if ((char) c != '\n') {
				builder.append((char) c);
			} else {
				datavalue = builder.toString().split("\t", -1);
				for (int i = 0; i < datavalue.length; ++i) {
					if ("".equals(datavalue[i])) {
						datavalue[i] = null;
					}
				}
				if (datavalue.length < fieldNo)
					datavalue = Arrays.copyOf(datavalue, fieldNo);
				//handling junk date.
				if ("0000".equals(datavalue[0]) || "0000".equals(datavalue[1])){
					datavalue[0]="00000000";
					datavalue[1]="00000000";
				}
				/*if ((null != datavalue[1]) && (null != datavalue[0])
						&& datavalue[0].matches(regex)
						&& datavalue[1].matches(regex)) {*/
					dateseen = dateFormat.parse(datavalue[0]);
					daterep = dateFormat.parse(datavalue[1]);
					//if ((dateseen.before(daterep) || dateseen.equals(daterep))) {
						calendar.clear();
						calendar.setTime(dateseen);
						calendar3.clear();
						calendar3.set(Calendar.YEAR,
								calendar.get(Calendar.YEAR));
						calendar3.set(Calendar.MONTH,
								calendar.get(Calendar.MONTH));
						datekey = calendar3.getTime();
						if (map.containsKey(datekey)) {
							ls1 = map.get(datekey);
						} else {
							ls1 = new ArrayList<UfoSighting>();
						}
						ls1.add(new UfoSighting(datavalue[0], datavalue[1],
								datavalue[2], datavalue[3], datavalue[4],
								datavalue[5]));
						map.put(datekey, ls1);
					//}
					//builder.setLength(0);
			//	}
				builder.setLength(0);
			}
		}
		return map != null ? map : null;
	}
	
	@Override
	public List<UfoSighting> getAllSightings() {
		List<UfoSighting> list = new ArrayList<UfoSighting>();
		try {
			Collection<List<UfoSighting>> list1 = parser().values();
			Iterator<List<UfoSighting>> itr = list1.iterator();
			while (itr.hasNext()) {
				list.addAll(Arrays.asList(itr.next().toArray(
						new UfoSighting[] {})));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list != null ? list : null;
	}

	@Override
	public List<UfoSighting> search(int yearSeen, int monthSeen) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, yearSeen);
		calendar.set(Calendar.MONTH, monthSeen - 1);
		List<UfoSighting> list = new ArrayList<UfoSighting>();
		try {
			list = parser().get(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list != null ? list : null;
	}
}
