package com.moodpo.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;

/**
 * <p>Title: 时间处理器</p>
 * <p>Description: 本类的主要作用是处理时间为各种需要的格式</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: framework</p>
 * @author zhangjin
 * @version 1.1
 */
public class DateBuilder {
  private static String dateFormatToMonth = "yyyy-MM";
  private static String dateFormatToDay = "yyyy-MM-dd";
  private static String dateFormatToMM = "yyyy-MM-dd HH:mm";
  private static String dateFormatToSec = "yyyy-MM-dd HH:mm:ss";
  private static String dateFormatToMillisecond = "yyyy-MM-dd HH:mm:ss SSS";
  
  public static String UNIT_YEAR = "0";
  public static String UNIT_MONTH = "1";
  public static String UNIT_DAY = "2";
  
  /**
   * 天数为30天数的月份
   */
  private static final int monthEnd30[] = {
      4, 6, 9, 11};

  /**
   * 该方法获取系统的当前时间并将其转换为"yyyy-MM"格式字符串
   * @return String 当前时间的"yyyy-MM格式化字符串
   */
  public static String getTimeToMonth() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMonth);
    return dateFormat.format(new Date());
  }

  /**
   * 该方法把传入的时间转化为"yyyy-MM"格式的字符串
   * @param date Date 时间对象
   * @return String 传入时间的"yyyy-MM"格式化字符串
   */
  public static String getTimeToMonth(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMonth);
    return dateFormat.format(date);
  }

  /**
   * 该方法获取系统的当前时间并将其转换为"yyyy-MM-dd HH:mm"格式字符串
   * @return String 当前时间的"yyyy-MM-dd HH:mm"格式化字符串
   */
  public static String getTimeToMM() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMM);
    return dateFormat.format(new Date());
  }

  /**
   * 该方法把传入的时间转化为"yyyy-MM-dd HH:mm"格式的字符串
   * @param date Date 时间对象
   * @return String 传入时间的"yyyy-MM-dd HH:mm"格式化字符串
   */
  public static String getTimeToMM(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMM);
    return dateFormat.format(date);
  }

  /**
   * 该方法获取系统的当前时间并将其转换为"yyyy-MM-dd"格式字符串
   * @return String 当前时间的"yyyy-MM-dd"格式化字符串
   */
  public static String getTimeToDay() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToDay);
    return dateFormat.format(new Date());
  }

  /**
   * 该方法把传入的时间转化为"yyyy-MM-dd"格式的字符串
   * @param date Date 时间对象
   * @return String 传入时间的"yyyy-MM-dd"格式化字符串
   */
  public static String getTimeToDay(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToDay);
    return dateFormat.format(date);
  }

  /**
   * 该方法获取系统的当前时间并将其转换为"yyyy-MM-dd HH:mm:ss"格式字符串
   * @return String 当前时间的"yyyy-MM-dd HH:mm:ss"格式化字符串
   */
  public static String getTimeToSec() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToSec);
    return dateFormat.format(new Date());
  }

  /**
   * 该方法把传入的日期转化为"yyyy-MM-dd HH:mm:ss"格式的字符串
   * @param date Date 时间对象
   * @return String 传入时间的"yyyy-MM-dd HH:mm:ss"格式化字符串
   */
  public static String getTimeToSec(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToSec);
    return dateFormat.format(date);
  }

  /**
   * 该方法获取系统的当前时间并将其转换为"yyyy-MM-dd HH:mm:ss SSS"格式字符串
   * @return String 当前时间的"yyyy-MM-dd HH:mm:ss SSS"格式化字符串
   */
  public static String getTimeToMillisecond() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMillisecond);
    return dateFormat.format(new Date());
  }

  /**
   * 该方法把传入的日期转化为"yyyy-MM-dd HH:mm:ss SSS"格式的字符串
   * @param date Date 时间对象
   * @return String 传入时间的"yyyy-MM-dd HH:mm:ss SSS"格式化字符串
   */
  public static String getTimeToMillisecond(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatToMillisecond);
    return dateFormat.format(date);
  }

  /**
   * 该方法获的某月的天数
   * @param year 年
   * @param month 月
   * @return int 某月的天数
   */
  public static int getMonthDayNumber(int year, int month) {
    int result;
    //如果月为2月时，判断是28天还是29天
    if (month == 2) {
      result = 28;
      if (year % 100 == 0) {
        if (year % 400 == 0) {
          result = 29;
        }
      }
      else if (year % 4 == 0) {
        result = 29;
      }
    }
    else {
      result = 31;
      for (int i = 0; i < monthEnd30.length; i++) {
        if (month == monthEnd30[i]) {
          result = 30;
          break;
        }
      }
    }
    return result;
  }

  /**
   * 此方法将将日期转为标准格式"yyyy-MM-dd"
   * @param dt String 时间对象
   * @return String 传入时间的"yyyy-MM-dd"格式化字符串
   */
  public static String formatDate(String dt) {
    String retDt = "";
    try {
      if (null == dt || dt.length() == 0) {
        return "";
      }
      else {
        String year = "";
        String month = "";
        String date = "";
        int idx = dt.indexOf("-", 5);
        if (idx == -1) {
          return "";
        }
        year = dt.substring(0, 4);
        month = dt.substring(5, idx);
        if (month.length() == 1) {
          month = "0" + month;
        }
        date = dt.substring(idx + 1);
        if (date.length() == 1) {
          date = "0" + date;
        }
        retDt = year + "-" + month + "-" + date;
      }
      return retDt;
    }
    catch (Exception e) {
      return "";
    }
  }

  /**
   * 此方法得到给定日期，N天、月、年前或后的日期
   * @param startDate String 开始日期
   * @param longNumber int 数值（输入正数，得到N天、月、年后的日期.输入负数，得到N天、月、年前的日期）
   * @param unitDate String  数值单位（0代表年，1代表月，2代表日）
   * @return String 返回得到日期
   */

  public static String getDate(String startDate, int longNumber,
                               String unitDate) {
    Calendar beginDate = Calendar.getInstance();
    String sStartDate = formatDate(startDate);
    //在字符串中取得年
    int year = Integer.parseInt(sStartDate.substring(0, 4));
    //在字符串中取得月
    int month = Integer.parseInt(sStartDate.substring(5, 7));
    //在字符串中取得日
    int day = Integer.parseInt(sStartDate.substring(8, 10));
    int end;

    month -= 1;
    //如果数值单位为0，年加传入数值
    if (unitDate.equals(UNIT_YEAR)) {
      year += longNumber;
    }
    //如果数值单位为1，月加传入数值
    if (unitDate.equals(UNIT_DAY)) {
      day += longNumber;
    }
    //如果数值单位为2，日加传入数值
    if (unitDate.equals(UNIT_MONTH)) {
      month += longNumber;

      beginDate.set(year, month, 1);

      year = beginDate.get(Calendar.YEAR);
      month = beginDate.get(Calendar.MONTH);

      end = getMonthDayNumber(year, month + 1);
      day = day > end ? end : day;
    }
    else {

      beginDate.set(year, month, day);

      year = beginDate.get(Calendar.YEAR);
      month = beginDate.get(Calendar.MONTH);
      day = beginDate.get(Calendar.DATE);
    }
    month++;
    sStartDate =
        String.valueOf(year) + "-" + String.valueOf(month) + "-"
        + String.valueOf(day);
    sStartDate = formatDate(sStartDate);
    return sStartDate;
  }

  /**
   * 此方法得到给定日期，N天后的日期或N天前的日期
   * @param startDay String 开始日期
   * @param longNumber int 天数（输入正数，得到N天后的日期.输入负数，得到N天前的日期）
   * @return String 返回得到日期
   */
  public static String getNDaysChange(String startDay, int longNumber) {
    return DateBuilder.getDate(startDay, longNumber, UNIT_DAY);
  }

  /**
   * 此方法得到给定日期，N月后的日期或N月前的日期
   * @param startDay String 开始日期
   * @param longNumber int 月数（输入正数，得到N月后的日期.输入负数，得到N月前的日期）
   * @return String 返回得到日期
   */
  public static String getNMonthChange(String startDay, int longNumber) {
    return DateBuilder.getDate(startDay, longNumber, UNIT_MONTH);
  }

  /**
   * 此方法得到给定日期，N年后的日期或N年前的日期
   * @param startDay String 开始日期
   * @param longNumber int 年数（输入正数，得到N年后的日期.输入负数，得到N年前的日期）
   * @return String 返回得到日期
   */
  public static String getNYearChange(String startDay, int longNumber) {
    return DateBuilder.getDate(startDay, longNumber, UNIT_YEAR);
  }

  /**
   * 此方法将yyyy-MM-dd类型的字符串转换为Date类型
   * 如果字符串日期不合法，缺省为"1900-01-01"
   * @param parStringDate String 需要转换的日期字符串
   * @return Date 转换后的日期类型
   */
  public static Date strToDate(String parStringDate) {
    java.text.SimpleDateFormat dateFormat =
        new java.text.SimpleDateFormat(dateFormatToDay);
    if (!isVerifyDate(parStringDate)) {
      parStringDate = new String("1900-01-01");
    }
    try {
      return dateFormat.parse(parStringDate);
    }
    catch (java.text.ParseException ex) {
      java.util.GregorianCalendar calendar =
          new java.util.GregorianCalendar();
      calendar.set(1900, 1, 1);
      return calendar.getTime();
    }
  }

  /**
   * 此方法检验输入字符串日期的合法性
   * @param parDate String 字符串日期，格式为yyyy-MM-dd
   * @return boolean 如果输入合法返回true，不合法返回false
   */
  public static boolean isVerifyDate(String parDate) {

    //确保传入的日期字符串为10为yyyy-mm-dd格式
    parDate = formatDate(parDate);
    //确保日期支持yyyy-m-dd yyyy-mm-d yyyy-m-d
    if (parDate.trim().length() != 10) {
      return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormatToDay);
    boolean valid = false;
    try {
      if (sdf.format(sdf.parse(parDate)).equalsIgnoreCase(parDate)) {
        valid = true;
      }
    }
    catch (Exception ex) {
    }
    return valid;
  }

  /**
   * 此方法根据输入日期对象获得一周的开始日期（星期一）
   * @param parDate Date 日期对象
   * @return String 开始日期
   */
  public static String getStartDayOfWeek(Date parDate) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(parDate);
    int i = calendar.get(Calendar.DAY_OF_WEEK);
    String day = getTimeToDay(parDate);
    day = getNDaysChange(day, - (i - 2));
    return day;
  }

  /**
   * 此方法根据输入日期对象获得一周的结束日期(星期天)
   * @param parDate Date 日期对象
   * @return String 开始日期
   */
  public static String getEndDayOfWeek(Date parDate) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(parDate);
    int i = calendar.get(Calendar.DAY_OF_WEEK);
    String day = getTimeToDay(parDate);
    day = getNDaysChange(day, ( - (i - 2)) + 6);
    return day;
  }

  /**
   * 获得一个月的开始时间
   * @param parDate Date
   * @return String
   */
  public static String getStartDayOfMonth(Date parDate) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(parDate);
    int i = calendar.get(Calendar.DAY_OF_MONTH);
    String day = getTimeToDay(parDate);
    day = getNMonthChange(day, -1);
    day = getNDaysChange(day, - (i - 1));
    return day;
  }

  /**
   * 获得一个月的开始时间
   * @param parDate Date
   * @return String
   */
  public static String getEndDayOfMonth(Date parDate) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(parDate);
    int i = calendar.get(Calendar.DAY_OF_MONTH);
    String day = getTimeToDay(parDate);
    day = getNMonthChange(day, -1);
    int n = getMonthDayNumber(Integer.parseInt(day.substring(0, 4)),
                              Integer.parseInt(day.substring(5, 7)));
    day = getNDaysChange(day, ( - (i - 1)) + n-1);
    return day;
  }
  
  /**
  * 字符型日期转化成sql.Date型日期
  * @param p_strDate    字符型日期
  * @return java.sql.Date sql.Date型日期
  * @throws ParseException 
  */
  public static java.sql.Date toSqlDateFromStrDate( String p_strDate ) throws ParseException {
     java.sql.Date returnDate = null;
     DateFormat sdf = new SimpleDateFormat();
     if ( p_strDate != null && ( !"".equals( p_strDate ) ) ) {
      returnDate = new java.sql.Date( sdf.parse( p_strDate ).getTime() );
     }
     return returnDate;
  }

  /**
  * util.Date型日期转化sql.Date(年月日)型日期
  * @param p_utilDate util.Date型日期
  * @return java.sql.Date sql.Date型日期
  */
  public static java.sql.Date toSqlDateFromUtilDate( java.util.Date p_utilDate ) {
     java.sql.Date returnDate = null;
     if ( p_utilDate != null ) {
      returnDate = new java.sql.Date( p_utilDate.getTime() );
     }
     return returnDate;
  }

  /**
  * util.Date型日期转化sql.Time(时分秒)型日期
  * @param p_utilDate util.Date型日期
  * @return java.sql.Time sql.Time型日期
  */
  public static java.sql.Time toSqlTimeFromUtilDate( java.util.Date p_utilDate ) {
     java.sql.Time returnDate = null;
     if ( p_utilDate != null ) {
      returnDate = new java.sql.Time( p_utilDate.getTime() );
     }
     return returnDate;
  }

  /**
  * util.Date型日期转化sql.Date(时分秒)型日期
  * @param p_utilDate util.Date型日期
  * @return java.sql.Timestamp sql.Timestamp型日期
  */
  public static java.sql.Timestamp toSqlTimestampFromUtilDate( java.util.Date p_utilDate ) {
     java.sql.Timestamp returnDate = null;
     if ( p_utilDate != null ) {
      returnDate = new java.sql.Timestamp( p_utilDate.getTime() );
     }
     return returnDate;
  }

  /**
  * sql.Date型日期转化util.Date型日期
  * @param p_sqlDate sql.Date型日期
  * @return java.util.Date util.Date型日期
  */
  public static Date toUtilDateFromSqlDate( java.sql.Date p_sqlDate ) {
     java.util.Date returnDate = null;
     if ( p_sqlDate != null ) {
      returnDate = new java.util.Date( p_sqlDate.getTime() );
     }
     return returnDate;
  }
  
	/**
	* 字符型日期转化util.Date型日期
	* @param p_strDate 字符型日期 
	* @param p_format 格式:"yyyy-MM-dd" / "yyyy-MM-dd hh:mm:ss"
	* @return java.util.Date util.Date型日期
	* @throws ParseException
	*/
	public static java.util.Date toUtilDateFromStrDateByFormat( String p_strDate, String p_format )
	    throws ParseException {
	   java.util.Date l_date = null;
	   java.text.DateFormat df = new java.text.SimpleDateFormat( p_format );
	   if ( p_strDate != null && ( !"".equals( p_strDate ) ) && p_format != null && ( !"".equals( p_format ) ) ) {
	    l_date = df.parse( p_strDate );
	   }
	   return l_date;
	}
	
	/** 
	* 获取指定日期的毫秒   
	* @param p_date util.Date日期 
	* @return long   毫秒   
	*/
	public static long getMillisOfDate( java.util.Date p_date ) {
	   java.util.Calendar c = java.util.Calendar.getInstance();
	   c.setTime( p_date );
	   return c.getTimeInMillis();
	}

//----------------------日期计算---------------------------------------------------------------------------------

  /**
  * 是否开始日期在结束日期之前(不包括相等)
  * @param p_startDate
  * @param p_endDate
  * @return boolean 在结束日期前:ture;否则：false
  */
  public static boolean isStartDateBeforeEndDate( Date p_startDate, Date p_endDate ) throws ParseException {
     long l_startTime = getMillisOfDate( p_startDate );
     long l_endTime = getMillisOfDate( p_endDate );
     return ( l_startTime - l_endTime > (long) 0 ) ? true : false;
  }

  /**
  * 获取2个字符日期的天数差
  * @param p_startDate
  * @param p_endDate
  * @return 天数差
  */
  public static long getDaysOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {
    
     Date l_startDate = toUtilDateFromStrDateByFormat( p_startDate,"yyyy-MM-dd");
     Date l_endDate = toUtilDateFromStrDateByFormat( p_endDate, "yyyy-MM-dd");
     long l_startTime = getMillisOfDate( l_startDate );
     long l_endTime = getMillisOfDate( l_endDate );
     long betweenDays = (long) ( ( l_endTime - l_startTime ) / ( 1000 * 60 * 60 * 24 ) );
     return betweenDays;
  }

  /**
  * 获取2个字符日期的周数差
  * @param p_startDate
  * @param p_endDate
  * @return 周数差
  */
  public static long getWeeksOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {
     return getDaysOfTowDiffDate(p_startDate,p_endDate)/7;
  }

  /**
  * 获取2个字符日期的月数差
  * @param p_startDate
  * @param p_endDate
  * @return 月数差
  */
  public static long getMonthsOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {
     return getDaysOfTowDiffDate(p_startDate,p_endDate)/30;
  }
  /**
  * 获取2个字符日期的年数差
  * @param p_startDate
  * @param p_endDate
  * @return 年数差
  */
  public static long getYearsOfTowDiffDate( String p_startDate, String p_endDate ) throws ParseException {
     return getDaysOfTowDiffDate(p_startDate,p_endDate)/365;
  }


  
  public static void main(String args[]) {
	  
	  
//	  System.out.println(DateBuilder.getNDaysChange(DateBuilder.getTimeToDay(), 1));
/*  
 * 新增方法测试
 * 
 * */
//    System.out.println(DateBuilder.getStartDayOfWeek(DateBuilder.strToDate(
//        "2006-2-25")));
//    try {
//		System.out.println(getYearsOfTowDiffDate("2001-5-1", "2009-4-1")+" years");
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//    try {
//		System.out.println(getMonthsOfTowDiffDate("2001-5-1", "2009-4-1")+" months");
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//	
//    try {
//		System.out.println(getWeeksOfTowDiffDate("2001-5-1", "2009-4-1")+" weeks");
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//	
//    try {
//		System.out.println(getDaysOfTowDiffDate("2001-5-1", "2009-4-1")+" days");
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//	boolean test1;
//	try {
//		test1 = isStartDateBeforeEndDate(toUtilDateFromStrDateByFormat("2001-5-1",dateFormatToDay), toUtilDateFromStrDateByFormat("2009-4-1", dateFormatToDay));
//		if(test1){
//			System.out.println("yes");
//		}else{
//			System.out.println("no");
//		}
//	
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
	  
//	  try {
//		System.out.println(getStartDayOfWeek(toUtilDateFromStrDateByFormat("2001-5-1",dateFormatToDay)));
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}

	
//    System.out.println(DateBuilder.getTimeToSec());
//    System.out.println(DateBuilder.getTimeToMillisecond());
//    Date d = new Date();
//    System.out.println(DateBuilder.getTimeToDay(d));
//    System.out.println(DateBuilder.getTimeToSec(d));
//    System.out.println(DateBuilder.getTimeToMillisecond(d));
//    System.out.println(DateBuilder.getMonthDayNumber(2006, 2));
//
//    System.out.println(DateBuilder.getDate("2006-3-2", 1, Constants.UNIT_DAY));
//    System.out.println(DateBuilder.getDate("2006-3-2", -1, Constants.UNIT_DAY));
//    System.out.println(DateBuilder.getNDaysChange("2006-3-2", 1));
//    System.out.println(DateBuilder.getNDaysChange("2006-3-2", -1));
//    System.out.println(DateBuilder.getNMonthChange("2006-3-2", 1));
//    System.out.println(DateBuilder.getNMonthChange("2006-3-2", -1));
//    System.out.println(DateBuilder.getNYearChange("2006-3-2", 1));
//    System.out.println(DateBuilder.getNYearChange("2006-3-2", -1));
  }

}
