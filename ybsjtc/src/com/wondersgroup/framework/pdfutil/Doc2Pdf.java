package com.wondersgroup.framework.pdfutil;

import java.io.*;

import org.apache.log4j.Logger;

import com.aspose.words.*;

public class Doc2Pdf {
	public static Logger logger = Logger.getLogger(Doc2Pdf.class);
	
	public static boolean getLicense(){
		try {
        boolean result = false;
            InputStream is = Doc2Pdf.class.getClassLoader().getResourceAsStream("License.xml"); //  license.xml应放在..\WebRoot\WEB-INF\classes路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        return result;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException(e.getMessage());
		}
    }
    
    public static void doc2pdf(String Address) {
        try {
        if (!getLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
             long old = System.currentTimeMillis();
            File file = new File(Address+"/ecn.pdf");  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(Address+"/ecn.doc");                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
        	throw new RuntimeException("word文档转pdf文档失败！");
		}
    }
    
    public static void doc2png(String Address,String uuid) {
        try {
        if (!getLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
             long old = System.currentTimeMillis();
            File file = new File(Address+"/"+uuid+".png");  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(Address+"/ecn.doc");                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PNG);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
        	throw new RuntimeException("word文档转png失败！");
		}
    }
}