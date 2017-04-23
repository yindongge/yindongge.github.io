package com.kjj.commserver.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	public static final DateFormat formartDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final DateFormat formartDate = new SimpleDateFormat("yyyy-MM-dd");
	
	public static final DateFormat formartTime = new SimpleDateFormat("HH:mm:ss");
	
	public static final DateFormat formartWeek = new SimpleDateFormat("E",Locale.CHINA);
	

	/**
	 * 获取当天的时刻
	 * @param time 格式:HH:mm:ss
	 * @return
	 */
	public static Date getDateByTime(Date time){
		Calendar calTime = Calendar.getInstance();
		calTime.setTime(time);
		Calendar calNow = Calendar.getInstance();
		calNow.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY));
		calNow.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
		calNow.set(Calendar.SECOND, calTime.get(Calendar.SECOND));
		calNow.set(Calendar.MILLISECOND, 0);
        return calNow.getTime();
	}
	
	/**
	 * 获取两个时间的间隔 单位:毫秒
	 * @param time
	 * @return
	 */
	public static long getTimeInterval(Date time,Date time2){
		return time.getTime() - time2.getTime();
	}
	
	
	/**
	 * 时间比较，小于当前时间则返回true
	 * @param TargetTime  需要比较的时间
	 * @return
	 */
	public static Boolean isLessThanCurrentTime(Date targetTime){
		return  targetTime.before(new Date());
	}
	
	/**
	 * 
	 * @param dateTime 要修改的时间
	 * @param modifyType  要修改的类型（年，月，日）
	 * @param modifyCount 正数为加，负数为减
	 * @return Date
	 */
	public static Date modifyDate(Date dateTime,int modifyType,int modifyCount){
		Calendar ca=Calendar.getInstance();
		ca.setTime(dateTime);
		ca.add(modifyType, modifyCount);
		return ca.getTime();
	}
	
}
