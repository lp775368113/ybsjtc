package com.wondersgroup.application.basedic.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wondersgroup.application.basedic.dao.ComDAO;

import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.framework.comwork.service.BaseService;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.basedic.service]
 * @ClassName:    [ComServoce]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月3日 下午8:18:27]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月3日 下午8:18:27]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class ComService extends BaseService<BaseObject>{
    @Resource(name = "comDAO")
    private ComDAO comDAO;
    
	public List<Object> getDic(Map<String, Object> map){
		return comDAO.getDic(map);
	}
	
	public List<Object> getAAA027(Map<String, Object> map){
		return comDAO.getAAA027(map);
	}

}
