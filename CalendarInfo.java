package com.example.yaoxuehua.tourismattractionsapp.entity;


import com.example.yaoxuehua.tourismattractionsapp.utils.DateUtils;

public class CalendarInfo {

	private long timestamp;//时间戳

	private int year;
	private int month;
	private int day; // 如果 day = -1 则为无效数据
	private String weedDay; //周几
	private String date;//拼接

	private double price;//当天价格
	private boolean isPast;//是否是过去的时期 ，如果是 则点击无效
	private boolean isSell = true;//是否出售、是否还可以预定
	private int bookCode;//0-未预定  1- 已预定  2 - 选中
	private int tempBookCode;//0-未预定  1- 已预定  2 - 选中

	private int count = 1;//库存
	private boolean isSpecialPrice;//是否是节日售卖
	private boolean isToday = false;

	//日历bean 为公共使用类 旅游模块使用 需要增加儿童价格
	private double childPrice;

	public double getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(double childPrice) {
		this.childPrice = childPrice;
	}

	public CalendarInfo(){

	}

	/**
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @param price
	 * @param isPast
	 */
	public CalendarInfo(int year, int month, int day, double price, boolean isPast) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.price = price;
		this.isPast = isPast;
		setDate(year, month, day);

	}

	public boolean isSpecialPrice() {
		return isSpecialPrice;
	}

	public void setIsSpecialPrice(boolean isSpecialPrice) {
		this.isSpecialPrice = isSpecialPrice;
	}

	public int getTempBookCode() {
		return tempBookCode;
	}

	public void setTempBookCode(int tempBookCode) {
		this.tempBookCode = tempBookCode;
	}
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String date) {
		this.timestamp = DateUtils.getTime(date);
	}

	public String getDate() {
		return date;
	}
	public void setDate(int year,int month,int day) {

		//格式 2016-12
		this.date = year+"-"+((month<10)?"0"+month:month);

		if (day != -1){
			//格式 2016-12-05
			setTimestamp(year+"-"+((month<10)?"0"+month:month)+"-"+((day<10)?"0"+day:day));
		}
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getWeedDay() {
		return weedDay;
	}

	public void setWeedDay(String weedDay) {
		this.weedDay = weedDay;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPast() {
		return isPast;
	}

	public void setIsPast(boolean isPast) {
		this.isPast = isPast;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setIsSell(boolean isSell) {
		this.isSell = isSell;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isToday() {
		return isToday;
	}

	public void setIsToday(boolean isToday) {
		this.isToday = isToday;
	}
	
}
