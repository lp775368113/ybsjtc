package com.wondersgroup.materiel.centreTimer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.materiel.centreTimer.service.GetMaterielsService;
import com.wondersgroup.materiel.encoding.brandManagement.controller.BrandSupplierController;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.zwfw.controller]
 * @ClassName:    [QltQlsxController]   
 * @Description:  [政务服务定时任务]  
 * @Author:       [huangyuanfeng]   	   
 * @CreateDate:   [2018-7-10 下午2:56:08]  
 * @UpdateUser:   [huangyuanfeng]   	   
 * @UpdateDate:   [2018-7-10 下午2:56:08]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Controller
@Lazy(false)
public class GetMaterielsController{
	
	public static Logger logger = Logger.getLogger(GetMaterielsController.class);
	
	@Autowired
	private GetMaterielsService getMaterielsService;
	
	/**
	 * @throws Exception 
	 * @Title: 		 quartzZwfw   
	 * @Description: 定时任务  
	 */
	@Scheduled(cron= "0 0/1 * * * ?")
    public void quartzZwfw() {
    	try {
    		logger.info("********物料系统定时接收任务开始！********");
    		getMaterielsService.getDate();
			logger.info("********物料系统定时接收任务结束！********");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
    }
    
}
