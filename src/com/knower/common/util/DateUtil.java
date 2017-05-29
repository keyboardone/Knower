package com.knower.common.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author:zsf
 * @date:Apr 9, 2013 3:04:22 PM
 * @phone:
 * @email:
 * @copyright:pactera
 */
public class DateUtil {
	
	public static int YEAR_BASE = 1900;

	public static final String YEAR = "0";

	public static String HALFYEAR = "1";

	public static String SEASONONE = "2";

	public static String SEASON = "3";

	public static String MONTH = "4";

	public static String TENDAY = "5";

	public static String WEEK = "6";

	public static String DAY = "8";

	public static String YEAR_C = "y";

	public static String SEASON_C = "s";

	public static String MONTH_C = "m";

	public static String DAY_C = "d";
	
	public static String WEAK_C = "w";

	public static String DATE_FORMAT = "yyyy-MM-dd";

	public static String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DateUtil() {
	}
	
	//ȥ�����ڵ�ʱ�䲿��
	public static Date trimTime(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}

	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	public static String getDate() {
		return getDateTime("yyyy-MM-dd");
	}

	public static String getYM(){
		return getDateTime("yyyy-MM");
	}
	
	public static String getDateTime() {
		return getDateTime("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * @param dates
	 *            ����Ϊ6λ��8λ��14λ���ڵ��ַ�
	 * @return 6λ��8λ��14λ���ڸ�ʽת��Ϊ�����յĸ�ʽ
	 */
	public static String dateToTime(String dates) {
		String time = dates;
		if (time != null && time.length() == 14) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			String date = time.substring(6, 8);
			String hour = time.substring(8, 10);
			String minute = time.substring(10, 12);
			String second = time.substring(12, 14);
			time = year + "��" + month + "��" + date + "�� " + hour + "ʱ" + minute
					+ "��" + second + "��";
		}
		if (time != null && time.length() == 8) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			String date = time.substring(6, 8);
			time = year + "��" + month + "��" + date + "��";
		}
		if (time != null && time.length() == 6) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			time = year + "�� " + month + "��";
		}
		if (time != null && time.length() == 5) {
			String year = time.substring(0, 4);
			String month = "0" + time.substring(4, 5);
			time = year + "�� " + month + "��";
		}
		return time;
	}
	
	//��õ�ǰ����ǰһ��
	public static String getPreDate(){
		Date cur = Calendar.getInstance().getTime();
		Date pre = new Date(cur.getTime()-24*60*60*1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(pre);
	}
	   //��õ�ǰ����ǰһ��
    public static String getPreDate(Date cur,int date){
       if(cur == null){
         cur = Calendar.getInstance().getTime();
       }
        Date pre = new Date(cur.getTime()-date*24*60*60*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(pre);
    }
	//��õ�ǰ������ǰ��7��(����(��ǰ����)
	public static String[] getWeekDate(Date pre){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		date=pre;
		String[] dates=new String[7];
		for(int i=1;i<=7;i++){
			Date day=new Date(date.getTime()-i*24*60*60*1000);
			dates[i-1]=dateFormat.format(day);
		}
		return dates;
		
	}
	//��õ�������
	public static String getCurDate(){
		Date date=new Date();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date curdate=new Date();
			String curdatestr=dateFormat.format(curdate);
			date=dateFormat.parse(curdatestr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return formateDateToString(date);
	}
	public static String getCurDate(String parten){
		Date date=new Date();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(parten);
			Date curdate=new Date();
			String curdatestr=dateFormat.format(curdate);
			date=dateFormat.parse(curdatestr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return formateDateToString(date);
	}
	//�õ���һ������
	public static Date getLastDate(Date date,String pattern){
		Date pre = new Date(date.getTime()+24*60*60*1000);		
		return pre;
	}
	
	//�õ���һ������
	public static Date getLastDate(String datestr,String pattern){
		Date date = parse(datestr, pattern);
		Date pre = new Date(date.getTime()+24*60*60*1000);		
		return pre;
	}
	//�õ�ָ�����ڵ�ǰһ��
	public static String getPreDate(String datestr,String pattern){
		Date date = parse(datestr, pattern);
		Date pre = new Date(date.getTime()-24*60*60*1000);
		return formateDateToString(pre);
	}
	public static String getPreDateTime(){
		Date cur = Calendar.getInstance().getTime();
		Date pre = new Date(cur.getTime()-24*60*60*1000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(pre);
	}
	
	
	/**
	 * @param date
	 * @param newFormat
	 * @return ��"yyyy-MM-dd"��ʽ���ַ�����һ��ָ����ʽת�����ַ�
	 */
	public static String formatDateString(String date, String newFormat) {
		return formatDateString(date, DATE_FORMAT, newFormat);
	}
	
	
	//��õ�ǰ�µĵ�һ��
	public static String getFirstDayOfMonth(){
		Calendar	c   =   Calendar.getInstance(); 
		Calendar   calfirst   =   Calendar.getInstance();  
		int   now   =   c.get(Calendar.DAY_OF_MONTH);   
		calfirst.add(Calendar.DATE,1-now);  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(calfirst.getTime());
	}

	//����������������µĵ�һ��
	public static String getFirstDayOfMonth(String dateStr){
		dateStr = dateStr.substring(0, 8);
		return dateStr+"01";
	}

	//�����������������ĵ�һ�� 
	public static String getFirstDayOfYear(String dateStr){
		dateStr = dateStr.substring(0, 4);
		return dateStr+"-01-01";
	}
	
	public static String getDateTime(String pattern) {
		Date datetime = Calendar.getInstance().getTime();
		return getDateTime(datetime, pattern);
	}

	public static String getDateTime(Date date, String pattern) {
		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	/**
	 * ��ȡ��ʽ�����ʱ���
	 * @return
	 */
	public static Date getTimeStampDate() {
		Date date = new Date();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new Date());
			 date = df.parse(now);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int getCurrentYear() {
		return Calendar.getInstance().get(1);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(2) + 1;
	}

	public static int getCurrentDay() {
		return Calendar.getInstance().get(5);
	}

	public static Date addDays(int days) {
		return add(getNow(), days, 5);
	}

	public static Date addDays(Date date, int days) {
		return add(date, days, 5);
	}

	public static Date addMinutes(Date date, int minutes) {
		return add(date,minutes,Calendar.MINUTE);
	}
	
	public static Date addMonths(int months) {
		return add(getNow(), months, 2);
	}

	public static Date addMonths(Date date, int months) {
		return add(date, months, 2);
	}
	
	/**
	 * ��ȡǰһ��
	 * @param curYear
	 * @return
	 */
	public static String getPreYear(String curYear){
		int curY = Integer.parseInt(curYear);
		int preY = curY-1;
		return preY+"";
	}
	
	private static Date add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	public static long diffDays(Date one, Date two) {
		return (one.getTime() - two.getTime()) / 0x5265c00L;
	}
	
	public static long diffMinutes(Date one, Date two) {
		return (one.getTime() - two.getTime()) / 1000 / 60;
	}
	
	public static long diffHours(Date one, Date two) {
		return (one.getTime() - two.getTime()) / 1000 / 60 / 60;
	}

	public static int diffMonths(Date one, Date two) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(one);
		int yearOne = calendar.get(1);
		int monthOne = calendar.get(2);
		calendar.setTime(two);
		int yearTwo = calendar.get(1);
		int monthTwo = calendar.get(2);
		return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
	}

	public static Date parse(String datestr, String pattern) {
		if (datestr == null || "".equals(datestr))
			return null;
		Date date = null;
		String p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(p);
			date = dateFormat.parse(datestr);
		} catch (ParseException parseexception) {
		}
		return date;
	}

	public static Date parseExcelDate(int dateInt) {
		Date date = parse("1900-01-01","");
		return addDays(date,dateInt-2);
		//���м�2��ԭ��
		//1.EXCEL��ʱ��ο���1900-1-0 0:00 Ϊ1,��java��ʱ��ο�����1900-1-1 0:00 Ϊ0,����Excel����һ��1;
		//2.����EXCEL����Ϊ1900��������(������ж������ǣ��ܱ�4��400���,�����ܱ�100�������Ϊ����)�����������������EXCEL�ְ��������1��.

	}

	public static String format(Date date, String pattern) {
		String p;
		p = pattern;
		if (pattern == null || "".equals(pattern))
			p = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(p);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getMonthLastDay() {
		return getMonthLastDay(getNow());
	}

	public static Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(1), calendar.get(2) + 1, 1);
		calendar.add(5, -1);
		return calendar.getTime();
	}
	
	/**
	 * ���ַ��������Ͱ���ʽת��ΪDate����
	 * @param strDate
	 * @return
	 */
	public static Date formateStringToDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dt = null;
		try {
			dt = sdf.parse(strDate);
		} catch (ParseException e) {

		}
		return dt;
	}
	
	/**
	 * ��date���͵����ת�����ַ�
	 * 
	 * @param date
	 * @return
	 */
	public static String formateDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	public static boolean isFreq(String date, String freq) {
		DateFormat fmt = new SimpleDateFormat(DATE_FORMAT);
		Date d = null;
		try {
			d = fmt.parse(date);
			// freq ==w����Ƶ�ȣ�
			if(WEAK_C.equals(freq)){
				Calendar c = new GregorianCalendar();
				c.clear();
//				c.setFirstDayOfWeek(Calendar.MONDAY);
				c.setTime (d);
				if(c.get(Calendar.DAY_OF_WEEK) == 6){ //6Ϊ����
					
					return true;
				}else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		int year = d.getYear() + YEAR_BASE;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		return (makeDecision(year, month, day, freq));
	}
	
	public static boolean makeDecision(int year, int month, int day, String freq) {
		// ��
		if (DAY.equals(freq) || DAY_C.equals(freq)) {
			return true;
		}
		// ��
		else if (MONTH.equals(freq) || MONTH_C.equals(freq)) {
			if ((month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12)
					&& (day == 31)) {
				return true;
			} else if ((month == 4 || month == 6 || month == 9 || month == 11)
					&& (day == 30)) {
				return true;
			} else if (month == 2) {
				if ((year % 4 == 0 && day == 29)
						|| (year % 4 != 0 && day == 28)) {
					return true;
				} else {
					return false;
				}
			}

		}
		// ��
		else if (SEASON.equals(freq) || SEASON_C.equals(freq)) {
			if ((month == 3 && day == 31) || (month == 6 && day == 30)
					|| (month == 9 && day == 30) || (month == 12 && day == 31)) {
				return true;
			} else {
				return false;
			}
		}
		// ��
		else if (YEAR.equals(freq) || YEAR_C.equals(freq)) {
			if (month == 12 && day == 31) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	/**
	 * @param date
	 * @param oriFormat
	 * @param newFormat
	 * @return ��ָ����ʽ���ַ�����һ��ָ����ʽת�����ַ�
	 */
	public static String formatDateString(String date, String oriFormat,
			String newFormat) {
		// ����ָ����ʽ�����ַ��DATE
		DateFormat dtFmt = new SimpleDateFormat(oriFormat);
		Date d = null;
		try {
			d = dtFmt.parse(date);
		} catch (ParseException e) {
			return null;
		}
		// ��DATE���µ�ָ����ʽת�����ַ�
		DateFormat strFmt = new SimpleDateFormat(newFormat);
		return strFmt.format(d);
	}
	
	/**
	 * ����ת������,Ĭ��ת��Ϊyyyy-MM-dd HH:mm:ss��ʽ
	 * @param dateString ���ڸ�ʽ
	 * @param partten ��ʽģ��(�磺yyyy-MM-dd)
	 * @author sunhaiguo
	 * @return StringToDate ����ת���������
	 * @since Jun 15, 2010
	 */
	public static Date StringToDate(String dateString, String partten){
		if(partten==null)
		{
			partten=FULL_DATE_FORMAT;
		}
		SimpleDateFormat df = new SimpleDateFormat(partten);
		Date date = null;
		try{
			date = df.parse(dateString);
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("����ת���쳣");
		}
		return date;
	}
	
	public static String getNowFullDateString() {
		return getNowDateString(FULL_DATE_FORMAT);
	}
	
	public static String getNowDateString(String format) {
		Date d = new Date();
		return new SimpleDateFormat(format).format(d);
	}
	
}
