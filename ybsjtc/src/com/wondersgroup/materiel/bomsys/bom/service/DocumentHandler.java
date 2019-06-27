package com.wondersgroup.materiel.bomsys.bom.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import org.apache.log4j.Logger;

import com.wondersgroup.framework.pdfutil.Doc2Pdf;
import com.wondersgroup.materiel.bomsys.ecn.vo.MaterielBomEcn;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.speAffair.gsjd.service]
 * @ClassName:    [DocumentHandler]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018-8-24 上午9:06:15]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018-8-24 上午9:06:15]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class DocumentHandler {
	public static Logger logger = Logger.getLogger(DocumentHandler.class);

	private Configuration configuration = null;    
	public DocumentHandler() {   
		configuration = new Configuration();   
		configuration.setDefaultEncoding("utf-8");  
	}    
	public synchronized void createDoc(MaterielBomEcn ecn,String fileName,String basefile) {   
		//dataMap 要填入模本的数据文件   
		//设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，   
		//这里我们的模板是放在template包下面   
		try {
		configuration.setClassForTemplateLoading(this.getClass(), "/com/wondersgroup/materiel/bomsys/bom/service");   
		Template t=null;   
			//test.ftl为要装载的模板    
			t = configuration.getTemplate(basefile);//文件名   
		//输出文档路径及名称   
		File outFile = new File(fileName);   
		Writer out = null;   
		FileOutputStream fos=null;   
			fos = new FileOutputStream(outFile);   
			OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");    
			//这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。    
			//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));     
			out = new BufferedWriter(oWriter);   
			t.process(ecn, out);    
			out.close();    
			fos.close(); 
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException("生成Word文档时发生错误！");
		}
	}
}
