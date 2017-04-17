package com.steven.gantt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	protected static int count = 0;

	public static synchronized String getUUID() {
		count++;
		long time = System.currentTimeMillis();
		String uuid = "G" + Long.toHexString(time) + Integer.toHexString(count) + Long.toHexString(Double.doubleToLongBits(Math.random()));
		uuid = uuid.substring(0, 24).toUpperCase();
		return uuid;
	}

	public static Date parseString(String format, String date) {

		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		try {
			return dateformat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date parseString(String date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateformat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String parseDate(Date date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(null != date) {
			return dateformat.format(date);
		}else {
			return null;
		}
	}
	
	public static String parseDate(String format,Date date) {
		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.format(date);
	}

	private static String stringTmp1 = "<?xml version='1.0' encoding='UTF-8'?><orderRequest><company>";
	private static String stringTmp2 = "</company><number>";
	private static String stringTmp3 = "</number><from>";
	private static String stringTmp4 = "</from><to>";
	private static String stringTmp6 = "</callbackurl></parameters></orderRequest>";


	public static boolean isNullOrEmpty(String ss)
	{
		if (ss == null || ss.trim().length() < 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isNullByInt(Integer ss){
		if(ss == null){
			return true;
		}else {
			return false;
		}
	}
    public static boolean isNullByLong(Long ss){
        if(ss == null){
            return true;
        }else {
            return false;
        }
    }

	public static boolean isNullByDate(Date ss){
		if(ss == null){
			return true;
		}else {
			return false;
		}
	}


}
