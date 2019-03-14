package com.wondersgroup.framework.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
 
import com.sun.jna.Library;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public class JNAUtil {
	
	
	 public static Logger logger = Logger.getLogger(JNAUtil.class);
	 
	 public static void test(HttpServletRequest request){
		 //System.out.println("---" + request.getSession().getServletContext().getRealPath("resource\\"));
		  System.out.println("---" + JNAUtil.class.getResource("/resource").getPath());
		 
	 
	 }
	
	

	 public interface CLibrary extends Library {
		 
		  CLibrary INSTANCE = (CLibrary) Native.loadLibrary( PropertiesFileUtil.getProperty("mac.filepath"), CLibrary.class); // 引入库文件

		 	
		  public int  crtmac(byte[] src, Pointer desc) ;
		  
	 }

	 
	 public static String GetMac(String src    ) throws Exception {
		 
		  System.setProperty("jna.encoding", "GBK");
		 
		  Pointer p = new Memory(40);
		  int ret = CLibrary.INSTANCE.crtmac(src.getBytes(),p);
		 if(ret != 1){
			 throw new Exception ("Mac值生成失败！");
		 }
		 logger.debug( "Mac 返回码:"+ret);
		 
		 return p.getString(0);
		 
	 }
	 
	 
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(JNAUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	    
		byte[] desc  = new byte[40] ;
		//String desc ="";
		Pointer p = new Memory(40);
	 
	 // int a=	 CLibrary.INSTANCE.crtmac("1234567890".getBytes(),p);
		  String ret = GetMac("1234567890");
	 
	  System.out.println(ret);
	//	JNAUtil.GetMac("3333");
 
		 
	}

}
