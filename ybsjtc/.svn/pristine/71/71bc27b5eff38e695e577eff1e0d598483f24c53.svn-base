package com.wondersgroup.framework.jasper;

import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.jasper]
 * @ClassName:    [CustomReportView]   
 * @Description:  [jasper视图扩展类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:28:38]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:28:38]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class CustomReportView extends JasperReportsMultiFormatView {
	/**@Fields report: TODO[用一句话描述这个变量表示什么]   */
	private JasperReport report;

	/**@Title:  	CustomReportView   
	 * @Description:TODO[CustomReportView 构造器]     
	 */
	public CustomReportView() {
		super();
	}

	/**Title: fillReport
	 * Description:[视图扩展业务实现]
	 * @param model
	 * @return
	 * @throws Exception   
	 * @see org.springframework.web.servlet.view.jasperreports.AbstractJasperReportsView#fillReport(java.util.Map)   
	 */
	protected JasperPrint fillReport(Map<String, Object> model) throws Exception {
		if (model.containsKey("url")) {
			setUrl(String.valueOf(model.get("url")));
			this.report = loadReport();
		}
		return super.fillReport(model);
	}

	/**Title: getReport
	 * Description:[用一句话描述这个方法的作用]
	 * @return   
	 * @see org.springframework.web.servlet.view.jasperreports.AbstractJasperReportsView#getReport()   
	 */
	protected JasperReport getReport() {
		return this.report;
	}
}
