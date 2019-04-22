package com.wondersgroup.framework.jxls;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.web.servlet.view.AbstractView;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.jxls]
 * @ClassName:    [JxlsExcelView]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月18日 下午10:50:58]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月18日 下午10:50:58]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class JxlsExcelView  extends AbstractView{
	 private static final String CONTENT_TYPE = "application/vnd.ms-excel";

	    private String templatePath;
	    private String exportFileName;

	    /**
	     * @param templatePath   模版相对于当前classpath路径
	     * @param exportFileName 导出文件名
	     */
	    public JxlsExcelView(String templatePath, String exportFileName) {
	        this.templatePath = templatePath;
	        if (exportFileName != null) {
	            try {
	                exportFileName = URLEncoder.encode(exportFileName, "UTF-8");
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        this.exportFileName = exportFileName;
	        setContentType(CONTENT_TYPE);
	    }


		/**Title: renderMergedOutputModel
		 * Description:[用一句话描述这个方法的作用]
		 * @param model
		 * @param request
		 * @param response
		 * @throws Exception   
		 * @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)   
		 */
		@Override
		protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
	        Context context = new Context(model);
	        response.setContentType(getContentType());
	        response.setHeader("content-disposition",
	                "attachment;filename=" + exportFileName + ".xls");
	        ServletOutputStream os = response.getOutputStream();
	        /**
	         * javaweb中取xls文件
	         */
	        InputStream is = request.getServletContext().getResourceAsStream(templatePath);
	        /**
	         * java中取xls文件
	         * getClass().getClassLoader().getResourceAsStream(templatePath);
	         */
	        JxlsHelper.getInstance().processTemplate(is, os, context);
	        is.close();
			
		}
}
