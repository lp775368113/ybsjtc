package com.wondersgroup.framework.jxls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.wondersgroup.framework.exception.BusinessException;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.jxls]
 * @ClassName:    [JxlsRead]   
 * @Description:  [jxls进行上送excel文件的处理]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年3月5日 下午4:39:19]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年3月5日 下午4:39:19]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class JxlsRead {
	/**@Title: 		 ExcelToBean   
	 * @Description: TODO[读取excel存入javaBean]   
	 * @param inputXML
	 * @param file
	 * @param beans
	 * @return      
	 * @return_type: Map<String,Object>      
	 */
	public static Map<String,Object> ExcelToBean(InputStream inputXML,MultipartFile file,Map<String,Object> beans){
    XLSReader mainReader = null;
    try {
        mainReader = ReaderBuilder.buildFromXML( inputXML );
    } catch (IOException e1) {
        throw new BusinessException(e1.getMessage());
    } catch (SAXException e1) {
    	throw new BusinessException(e1.getMessage());
	}
    InputStream inputXLS = null;
    try {
        inputXLS = file.getInputStream();
    } catch (IOException e1) {
    	throw new BusinessException(e1.getMessage());
    }
    try {
        XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
    } catch (InvalidFormatException e1) {
    	throw new BusinessException(e1.getMessage());
    } catch (IOException e1) {
    	throw new BusinessException(e1.getMessage());
	} 
    return beans;
	}
}
