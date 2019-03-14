package com.wondersgroup.framework.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CoderUtil 
{	
	public static void main(String[] args) 
	{
		try {
			System.out.println(CoderUtil.fullSpace("100ml：长春西汀10mg", 20));
			
			BigDecimal jjzfze_total = new  BigDecimal("2");
			
			jjzfze_total=jjzfze_total.add(new BigDecimal("33"));
			
			System.out.println(jjzfze_total.intValue());
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String fullSpace(String str, int len) throws UnsupportedEncodingException
	{
		int step = len - CoderUtil.getByteSize(str);
		for(int i = 0;i < step;i++)
		{
			str += " ";
		}
		return str;
	}
	
	public static int getByteSize(String str) throws UnsupportedEncodingException
	{
		return str.getBytes("GBK").length;
	}
	
	public static int indexOf(String str, String postfix, int startIndex) 
	{ 
		KMPMatcher kmpMatcher = new KMPMatcher(); 

		kmpMatcher.computeFailure4Byte(postfix.getBytes()); 

		return kmpMatcher.indexOf(str.getBytes(), startIndex); 

		//return com.alibaba.common.lang.ArrayUtil.indexOf(org, search); 
	} 



	
    
    public static String splitString(String str,int len) 
    {
    	try {
			return CoderUtil.splitString(str,0,len);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
     
    public static String splitString(String str,int start,int len) throws UnsupportedEncodingException 
    {
    	if(len == 0)
    		return "";
    	
           if (str == null) {      
                  return "";      
            }      
           byte[] strByte = str.getBytes( "GBK");      
           int strLen = strByte.length;      
   
           if (len >= strLen || len < 1) {      
                  return str;      
            }  
           
           if (len < 1) {      
               return "";      
           }      

           
           int count = 0;      
           for (int i = start; i < len; i++) {      
                  int value = (int) strByte[i];      
                  if (value < 0) { 

                          count++;      
                   }      
           }      
           if (count % 2 != 0) 
           {  
        	   if(len == 1)
        		   len++;
        	   else
        	   {
        		   //如果不是特殊中文字（比特值一个小于0，一个大于0的）
        		   if(!SpChinese.isSpChinese(str))
        			   len--;
        	   }  
           }        
//           System.out.println(strByte.length);
//           System.out.println(start);
//           System.out.println(len);
//           System.out.println("-------------------");
//           
           return new String(strByte, start, len,"GBK");
     }  
    

	public static String converNumber(String value,int length,int scale)
	{
		Double db = new Double(value);
		
		int xsw = 0;
		String formatstr = "#";
		if(scale != 0)
			xsw = 1;
		
		for(int i = 0;i < length - scale - xsw;i++)
		{
			formatstr += "0";
		}
		
		if(scale != 0)
			formatstr += ".";
		
		for(int i = 0;i < scale;i++)
		{
			formatstr += "0";
		}
		
		DecimalFormat decimalFormat = new DecimalFormat(formatstr);
		return decimalFormat.format(db);
	}
	

	public static String converNumber(Double value,int length,int scale)
	{
		int xsw = 0;
		String formatstr = "#";
		if(scale != 0)
			xsw = 1;
		
		for(int i = 0;i < length - scale - xsw;i++)
		{
			formatstr += "0";
		}
		
		if(scale != 0)
			formatstr += ".";
		
		for(int i = 0;i < scale;i++)
		{
			formatstr += "0";
		}
		
		DecimalFormat decimalFormat = new DecimalFormat(formatstr);
		return decimalFormat.format(value);
	}
	

	public static String converNumber(long value,int length,int scale)
	{
		int xsw = 0;
		String formatstr = "#";
		if(scale != 0)
			xsw = 1;
		
		for(int i = 0;i < length - scale - xsw;i++)
		{
			formatstr += "0";
		}
		
		if(scale != 0)
			formatstr += ".";
		
		for(int i = 0;i < scale;i++)
		{
			formatstr += "0";
		}
		
		DecimalFormat decimalFormat = new DecimalFormat(formatstr);
		return decimalFormat.format(value);
	}
}
