package com.wondersgroup.materiel.encoding.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.wondersgroup.framework.cxf.materialservice.MaterialService;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.framework.dingding.util.AccessTokenUtil;
import com.wondersgroup.framework.dingding.util.Check;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.dao.MaterielDeviceMapper;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;
import com.wondersgroup.materiel.encoding.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.vo.Units;
import com.wondersgroup.permission.user.dao.UserMapper;
import com.wondersgroup.permission.user.vo.Dd_User;
import com.wondersgroup.permission.user.vo.User;

import net.sf.json.JSONObject;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.sysSetup.paramManage.service]
 * @ClassName:    [SysParameterService]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [wumengfei]   	   
 * @CreateDate:   [2018-6-21 下午2:39:59]  
 * @UpdateUser:   [wumengfei]   	   
 * @UpdateDate:   [2018-6-21 下午2:39:59]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class EncodingService{
	public static Logger logger = Logger.getLogger(EncodingService.class);

	@Autowired
	MaterielDeviceMapper materielDeviceMapper;
	
	@Autowired
	UserMapper userMapper;
	
	
	@Autowired
	Data0017Mapper data0017Mapper;
	
	public Map<String, Object> getPage(Map<String, Object> params) {
		JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
		jwpfb.setServiceClass(MaterialService.class);
		InputStream is = EncodingService.class.getClassLoader().getResourceAsStream("SetSystem.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		String webServiceURL = pro.getProperty("webServiceURL");
		jwpfb.setAddress(webServiceURL);
		MaterialService ms = (MaterialService) jwpfb.create();
		JSONObject postPara = JSONObject.fromObject(params);
		String resultstr=ms.getWLInfo(postPara.toString());
		JSONObject jsonObject = JSONObject.fromObject(resultstr);
		Map<String,Object> classMap = new HashMap<String,Object>();
		classMap.put("data", Data0017.class);
		Map stu = (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
		return stu;
	}

	/**@Title: 		 getMaxClass   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: Map<String,Object>      
	 */
	public List<MaterielDevice> getMaxClass(Map<String, Object> params) {
		return materielDeviceMapper.getMaxClass();
	}

	/**@Title: 		 getMinClass   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<MaterielDevice>      
	 */
	public List<MaterielDevice> getMinClass(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return materielDeviceMapper.getMinClass(params);
	}

	/**@Title: 		 getUnit   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<MaterielDevice>      
	 */
	public List<Units> getUnit(Map<String, Object> params) {
		return materielDeviceMapper.getUnit();
	}

	/**@Title: 		 getSupplier   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<Units>      
	 */
	public List<MaterielSupplier> getSupplier(Map<String, Object> params) {
		return materielDeviceMapper.getSupplier();
	}

	/**@Title: 		 getWLMS 
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<MaterielDevice>      
	 */
	public MaterielDevice getWLMS(Map<String, Object> params) {
		return materielDeviceMapper.getWLMS(params);
	}

	/**@Title: 		 saveData0017   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params      
	 * @throws Exception 
	 * @return_type: void      
	 */
	public void saveData0017(Data0017 params,User user) throws Exception {
		Dd_User dd_user=userMapper.getDd_users(String.valueOf((int)user.getId()));
		if(dd_user==null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		String rkey=params.getProdCodeSellPtr();
		Map<String,Object> getmd=new HashMap<String,Object>();
		getmd.put("key", rkey);
		MaterielDevice md=materielDeviceMapper.getWLMS(getmd);
		String extraDesc=md.getLargeclass()+"-"+md.getSmallclass()+"-";
		String daoed=data0017Mapper.getExtraDesc(extraDesc);
		if(daoed==null||"".equals(daoed)) {
			extraDesc=extraDesc+"0001";
			params.setExtraDesc(extraDesc);
		}else {
			String[] d= daoed.split("-");
			Integer i=Integer.parseInt(d[2]);
			i+=1;
			DecimalFormat df=new DecimalFormat("0000");
			String str2=df.format(i);
			extraDesc=extraDesc+str2;
			params.setExtraDesc(extraDesc);
		}
		params.setStatus("1");
		data0017Mapper.insertSelective(params);
		Check.startProcessInstance(params, dd_user,"新增物料");//发起审批流程
		params.setStatus("2");
		data0017Mapper.updateStatus(params);
			
	}

	/**@Title: 		 addUpdateData   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params      
	 * @param message 
	 * @throws Exception 
	 * @return_type: void      
	 */
	public void addUpdateData(Data0017 params,User user, String message) throws Exception {
		Dd_User dd_user=userMapper.getDd_users(String.valueOf((int)user.getId()));
		if(dd_user==null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		Data0017 ThisData=data0017Mapper.getData0017ById(params);
		if(ThisData==null) {
			params.setStatus("5");
			data0017Mapper.insertSelective(params);
			Check.startProcessInstance(params, dd_user,message);//发起审批流程
			params.setStatus("6");
			data0017Mapper.updateStatus(params);
		}else {
			params.setStatus("5");
			ThisData.setExtraDesc(params.getExtraDesc());
			data0017Mapper.updateThisData(ThisData);
			Check.startProcessInstance(ThisData, dd_user,message);//发起审批流程
			params.setStatus("6");
			data0017Mapper.updateStatus(ThisData);
		}
		
		
	}

	/**@Title: 		 getThisPage   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: Map<String,Object>      
	 */
	public Map<String, Object> getThisPage(Map<String, Object> params) {
		List<Data0017> list=data0017Mapper.getPage(params);
		Integer count=data0017Mapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public List<Data0017> getExportData(Map<String, Object> params) {
		return data0017Mapper.getExportData(params);
	}

	/**@Title: 		 updateThisData   
	 * @Description: TODO[用一句话描述这个方法的作用]   更新本地物料数据
	 * @param bean      
	 * @return_type: void      
	 */
	public void updateThisData(Data0017 bean) {
		data0017Mapper.updateThisData(bean);
	}
	


}
