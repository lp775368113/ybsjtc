package com.wondersgroup.framework.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;

public class StringUtil {
	public static boolean isNullOrEmpty(Object obj) {	
		return obj == null || "".equals(obj.toString());
	}
	public static String toString(Object obj){
		if(obj == null) return "";
		return obj.toString();
	}
	public static String join(Collection s, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        Iterator iter = s.iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next());
            if (iter.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }
	
	  public static String nullToBlank(String src) {
	        if (src == null)
	            return "";
	        if (src.equalsIgnoreCase("null"))
	            src = "";
	        return src;
	    }

	
	  // 过滤空格、tab键、换行符、回车键
		public static String StringFilter(String str) throws PatternSyntaxException {
			 
			String regEx = "\\s{2,}|\t|\r|\n%";
			 
			return str.replaceAll(regEx, "").trim();
		}

		public static void main(String[] args) {
		 String str = " 浙江省苍南县	新安乡鉴桥村236	%";
			System.out.println(str);
			System.out.println(StringFilter(str));
		}
}
