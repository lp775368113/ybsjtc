/** 
 * @(#)SpChinese.java 2012-11-27
 * 
 * Copyright (c) 1995-2012 Wonders Information Co.,Ltd.
 * 1518 Lianhang Rd,Shanghai 201112.P.R.C.
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Wonders Group.
 * (Social Security Department). You shall not disclose such
 * Confidential Information and shall use it only in accordance with 
 * the terms of the license agreement you entered into with Wonders Group. 
 *
 * Distributable under GNU LGPL license by gnu.org
 */

package com.wondersgroup.framework.util;
/**
 * @author Administrator
 * @version $Revision$ 2012-11-27
 * @author ($Date$ modification by $Author$)
 * @since 1.0
 */
public class SpChinese 
{
	public final static String[] SP_CHINESE = new String[]{"薢"};
	
	/**
	 * //判断是否特殊中文字（比特值一个小于0，一个大于0的）
	 * @param str
	 * @return
	 */
	public static boolean isSpChinese(String str)
	{
		for(String i : SpChinese.SP_CHINESE)
		{
			if(str.indexOf(i) != -1)
				return true;
		}
		return true;
	}
}
