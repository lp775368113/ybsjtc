package com.wondersgroup.framework.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class Tools 
{	
	public static void main(String[] args) {
		System.out.println(Tools.getUUID());
	}
	
	/**
	 * 将long型的时间转换为String型时间
	 * @param list
	 * @param fieldName
	 * @param dateformat
	 */
	public static long stringDateToLongDate(String stringDate,String dateformat)
	{
		return stringToDate(stringDate,dateformat).getTime();
	}
	
	public static String addOneDay(String date)
	{
		return date.substring(0,date.length() - 1) + 
			(Integer.valueOf(date.substring(date.length() - 1,date.length())) + 1);
	}
	
	/**
	 * 将long型的时间转换为String型时间
	 * @param list
	 * @param fieldName
	 * @param dateformat
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void longDateToString(List list,String fieldName,String dateformat) throws Exception
	{
		for(Iterator iterator = list.iterator();iterator.hasNext();)
		{
				Object object = iterator.next();
				SimpleDateFormat df = new SimpleDateFormat();
				String longDate = BeanUtils.getProperty(object, fieldName);
				
				if(longDate != null && !"".equals(longDate))
				{
					Date date = new Date(Long.valueOf(longDate));
					if(dateformat == null)
						dateformat = "yyyy-MM-dd HH:mm:ss";
					df.applyPattern(dateformat);
					BeanUtils.setProperty(object,fieldName,df.format(date));
				}
				else
				{
					BeanUtils.setProperty(object,fieldName,"");
				}
		}
	}
	
	/**
	 * 将String型转换成Date型
	 * @param datestr
	 * @param dateformat
	 * @return
	 * @throws Exception
	 */
	public static Date stringToDate(String datestr,String dateformat)
	{
		if(dateformat == null)
			dateformat = "yyyy-MM-dd HH:mm:ss";
		DateFormat format = new SimpleDateFormat(dateformat);  
		Date date = null;
		try 
		{
			date = format.parse(datestr);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 得到当前时间
	 * @param model
	 * @return
	 */
	public static String getNow(String model)
	{
		
		SimpleDateFormat df = new SimpleDateFormat();
		Date now = new Date();
		df.applyPattern(model);
		return df.format(now);
	}
	
	/**
	 * 将DATE转换为String
	 * @param model
	 * @return
	 */
	public static String dateToString(Date date,String model)
	{
		if(model == null)
			model = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern(model);
		return df.format(date);
	}
	
	/**
	 * 得到当前时间
	 * @param model
	 * @return
	 */
	public static String getNow()
	{
		SimpleDateFormat df = new SimpleDateFormat();
		Date now = new Date();
		df.applyPattern("yyyy-MM-dd HH:mm:ss");
		return df.format(now);
	}
	
	
	
	/**
	 * 得到当前时间
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	public static Date getNowWithDate()  throws Exception
	{
		SimpleDateFormat df = new SimpleDateFormat();
		try 
		{
			df.applyPattern("yyyy-MM-dd hh:mm:ss");
			return df.parse(getNow());
		} 
		catch (ParseException e) 
		{
			throw new Exception(e);
		}
	}
	
	/**
	 * 得到当前时间
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	public static Date getNowWithDate(String model) throws Exception
	{
		
		SimpleDateFormat df = new SimpleDateFormat();
		try 
		{
			df.applyPattern(model);
			return df.parse(getNow());
		} 
		catch (ParseException e) 
		{
			throw new Exception(e);
		}
	}
	
	public static List arrayToList(Object[] objects)
	{
		List list = new ArrayList();
		int objectsSize = objects.length;
		for(int i = 0;i<objectsSize;i++)
		{
			list.add(objects[i]);
		}
		return list;
	}
	
	public static void copyObject(Object tag,Object src) throws Exception
	{
		BeanUtils.copyProperties(tag, src);	
	}
	
	public static Collection copyList(Collection list,Class clazz) throws Exception
	{
		List resultlist = new ArrayList();
		for(Iterator iterator = list.iterator();iterator.hasNext();)
		{
				Object object = clazz.newInstance();
				BeanUtils.copyProperties(object, iterator.next());
				resultlist.add(object);
		}
		return resultlist;
	}

	/**
	 * 用数据字典替换Page中的数据
	 * @param datalist
	 * @param fieldName
	 * @param dicCode
	 */
//	public static void replaceByDic(Page page,String fieldName,String dicCode)
//	{
//		List list = page.getResult();
//		Tools.replaceByDic(list, fieldName, dicCode);
//		page.setResult(list);
//	}
	
	/**
	 * 用数据字典替换List中的数据
	 * @param datalist
	 * @param fieldName
	 * @param dicCode
	 */
//	public static void replaceByDic(List datalist,String fieldName,String dicCode)
//	{
//		List<Aa10> dicList = dictionaryService.listAa10s(dicCode);
//		if(datalist != null)
//		{
//			if (dicList != null && dicList.size() > 0) {
//			for(Iterator diciter = dicList.iterator();diciter.hasNext();)
//			{
//				Aa10 aa10 = (Aa10)diciter.next();
//				for(Iterator dataiter = datalist.iterator();dataiter.hasNext();)
//				{
//					try 
//					{
//						Object object = dataiter.next();
//						if(aa10.getCode().equals(BeanUtils.getProperty(object, fieldName)))
//							BeanUtils.setProperty(object, fieldName, aa10.getName());
//					} 
//					catch (Exception e) 
//					{
//						throw new BusinessException(e);
//					} 
//				}
//			}
//			}
//		}
//	}
	
	
	/**
	 * 用数据字典替换List中的数据
	 * @param datalist
	 * @param fieldName
	 * @param dicCode
	 */
//	public static void replaceByDicObject(Object object,String fieldName,String dicCode)
//	{
//		List<Aa10> dicList = dictionaryService.listAa10s(dicCode);
//		
//		if (dicList != null && dicList.size() > 0) {
//		
//			for(Iterator diciter = dicList.iterator();diciter.hasNext();)
//			{
//				Aa10 aa10 = (Aa10)diciter.next();
//					try 
//					{
//						if(aa10.getCode().equals(BeanUtils.getProperty(object, fieldName)))
//							BeanUtils.setProperty(object, fieldName, aa10.getName());
//					} 
//					catch (Exception e) 
//					{
//						throw new BusinessException(e);
//					} 
//			}
//		}
//	}
	
//	public static void replaceByDicUserStatus(List datalist)
//	{
//		for(Iterator dataiter = datalist.iterator();dataiter.hasNext();)
//		{
//			try 
//			{
//				Object object = dataiter.next();
//				String status = BeanUtils.getProperty(object, "status");
//				
//				if("1".equals(BeanUtils.getProperty(object, "removed") + ""))
//					BeanUtils.setProperty(object, "status","已注销");
//				else 
//				if("0".equals(status + ""))
//					BeanUtils.setProperty(object, "status","未激活");
//				else 
//				if("1".equals(status + ""))
//					BeanUtils.setProperty(object, "status","已激活");
//				else 
//				if("-1".equals(status + ""))
//					BeanUtils.setProperty(object, "status","被封锁");
//				else 
//				if("2".equals(status + ""))
//					BeanUtils.setProperty(object, "status","被封锁");
//			} 
//			catch (Exception e) 
//			{
//				throw new BusinessException(e);
//			} 
//		}
//	}
	
	
//	public static void replaceByDicUserRemoved(List datalist)
//	{
//		for(Iterator dataiter = datalist.iterator();dataiter.hasNext();)
//		{
//			try 
//			{
//				Object object = dataiter.next();
//				String status = BeanUtils.getProperty(object, "removed");
//				
//				if("1".equals(status))
//					BeanUtils.setProperty(object, "removed","无效");
//				else 
//				if("0".equals(status))
//					BeanUtils.setProperty(object, "removed","有效");
//			} 
//			catch (Exception e) 
//			{
//				throw new BusinessException(e);
//			} 
//		}
//	}
		
	/**
	 * 验证时间格式
	 * @param checkValue
	 * @param format
	 * @return
	 */
	public static boolean validateTimeFormat(String checkValue,String format)
	{
        DateFormat dateFormat = new SimpleDateFormat(format);      
        try  
        {
            dateFormat.parse(checkValue);
            return true;
        }   
        catch(Exception e)   
        {   
        	return false;
        }
	}
	
	public static String sqlIn(String param,List list)
	{
		if(list == null || list.size() == 0)
			return "";
		
		StringBuffer sb = new StringBuffer();
		int listsize = list.size();
		sb.append("(" + param + " in (");
		int pagenum = 1;
		for (int i = 0; i < listsize; i++) 
		{
			sb.append(list.get(i) + ",");
			if(i == pagenum * 900 - 1)
			{
				sb = new StringBuffer(sb.substring(0, sb.length() - 1));
				sb.append(") or " + param + " in (");
				pagenum++;
			}
		}

		return  sb.substring(0, sb.length() - 1) + "))";
	}
	
	public static String getMaxDateWithString()
	{
		return "2999-01-01 01:01:01";
	}
	
	/**
	 * <pre>
	 * 获得包括当前年的前yearNum年的年份
	 * @param yearNum 年数(int)
	 * @return 年数List集合
	 * @author 夏博斌 Apr 20, 2011
	 * </pre>
	 */
	public static List<String> getYearList(int yearNum){
		String strYear = Tools.getNow("yyyy");
		List<String> yearLst = new ArrayList<String>();
		int intYear = Integer.parseInt(strYear);
		for (int i = 0; i < 10; i++) {
			yearLst.add((intYear-i)+"");
		}
		return yearLst;
	}
	
	/**
	 * <pre>
	 * 获得1-12的月份
	 * @return 包含12个月份的月份
	 * @author 夏博斌 Apr 20, 2011
	 * </pre>
	 */
	public static List<String> getMonthList(){
		List<String> monthLst = new ArrayList<String>();
		for (int j = 1; j <= 12; j++) {
			if((j+"").length()==1){
				monthLst.add("0"+j);
			}else{
				monthLst.add(""+j);
			}
		}
		return monthLst;
	}
	/**
	 * <pre>
	 * 获得当前月份
	 * @return 当前月份的字符串 如04 代表四月份
	 * @author 夏博斌 Apr 25, 2011
	 * </pre>
	 */
	public static String getNowMonth(){
		return getNow("MM");
	}
	
	public static String getUUID()
	{
		UUID uuid = UUID.randomUUID();
		String[] uuidstrs = uuid.toString().split("-");
		StringBuffer sb = new StringBuffer();
		for(String uuidstr : uuidstrs)
		{
			sb.append(uuidstr);
		}
		return sb.substring(0, 18);
	}
	
	
	    
	  
	      /**
	       * 把输入的金额转换为汉语中人民币的大写
	       * 
	       * @param numberOfMoney
	       *            输入的金额
	       * @return 对应的汉语大写
	       */
	public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
		/**
		 * 汉语中数字大写
		 */
		String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		/**
		 * 汉语中货币单位大写，这样的设计类似于占位符
		 */
		String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆",
				"拾", "佰", "仟" };
		/**
		 * 特殊字符：整
		 */
		String CN_FULL = "整";
		/**
		 * 特殊字符：负
		 */
		String CN_NEGATIVE = "负";
		/**
		 * 金额的精度，默认值为2
		 */
		int MONEY_PRECISION = 2;
		/**
		 * 特殊字符：零元整
		 */
		String CN_ZEOR_FULL = "零元" + CN_FULL;
		StringBuffer sb = new StringBuffer();
		// -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
		// positive.
		int signum = numberOfMoney.signum();
		// 零元整的情况
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		// 这里会进行金额的四舍五入
		long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
		// 得到小数点后两位值
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// 每次获取到最后一个数
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// 让number每次都去掉最后一个数
			number = number / 10;
			++numIndex;
		}
		// 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

}
