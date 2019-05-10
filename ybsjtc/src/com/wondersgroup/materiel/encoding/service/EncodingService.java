package com.wondersgroup.materiel.encoding.service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.cxf.materialservice.MaterialService;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.framework.dingding.util.AccessTokenUtil;
import com.wondersgroup.framework.dingding.util.Check;
import com.wondersgroup.framework.util.Base64Util;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.dao.MaterielFileMapper;
import com.wondersgroup.materiel.encoding.packageManagement.dao.MaterielPackageMapper;
import com.wondersgroup.materiel.encoding.packageManagement.vo.MaterielPackage;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;
import com.wondersgroup.materiel.encoding.vo.MaterielFile;
import com.wondersgroup.materiel.encoding.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.vo.Units;
import com.wondersgroup.permission.user.dao.UserMapper;
import com.wondersgroup.permission.user.vo.Dd_User;
import com.wondersgroup.permission.user.vo.User;

import net.sf.json.JSONObject;
import sun.java2d.pipe.SpanShapeRenderer.Simple;
import sun.misc.BASE64Decoder;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.sysSetup.paramManage.service]
 * @ClassName: [SysParameterService]
 * @Description: [一句话描述该类的功能]
 * @Author: [wumengfei]
 * @CreateDate: [2018-6-21 下午2:39:59]
 * @UpdateUser: [wumengfei]
 * @UpdateDate: [2018-6-21 下午2:39:59]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
@Service
public class EncodingService {
	public static Logger logger = Logger.getLogger(EncodingService.class);

	@Autowired
	UserMapper userMapper;

	@Autowired
	Data0017Mapper data0017Mapper;
	
	@Autowired
	MaterielBrandMapper materielBrandMapper;
	
	@Autowired
	MaterielFileMapper materielFileMapper;
	
	@Autowired
	MaterielPackageMapper materielPackageMapper;
	
	@Autowired
	MaterielSmallclassMapper materielSmallclassMapper;

	public Map<String, Object> getPage(Map<String, Object> params) {
		String status=(String) params.get("status");
		if("9".equals(status)) {
			JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
			jwpfb.setServiceClass(MaterialService.class);
			InputStream is = EncodingService.class.getClassLoader().getResourceAsStream("SetSystem.properties");
			Properties pro = new Properties();
			try {
				pro.load(is);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
			String webServiceURL = pro.getProperty("webServiceURL");
			jwpfb.setAddress(webServiceURL);
			MaterialService ms = (MaterialService) jwpfb.create();
			JSONObject postPara = JSONObject.fromObject(params);
			String resultstr = ms.getWLInfo(postPara.toString());
			JSONObject jsonObject = JSONObject.fromObject(resultstr);
			Map<String, Object> classMap = new HashMap<String, Object>();
			classMap.put("data", Data0017.class);
			Map stu = (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
			return stu;
		}else {
			String ipdcSTR=(String) params.get("ipdcSTR");
			if(!"".equals(ipdcSTR)&&ipdcSTR!=null) {
				String [] list = ipdcSTR.split("\\s+");
				 List<String> stringB = Arrays.asList(list);
				 params.put("list", stringB);
			}
			List<Data0017> list=data0017Mapper.getPage(params);
			Integer count=data0017Mapper.getPageCount(params);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", count);
			result.put("data", list);
			return result;
		}
		
	}
	
	
	
	/**@Title: 		 checkValue   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: Map<String,Object>      
	 */
	public Map<String, Object> checkValue(Map<String, Object> params) {
		JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
		jwpfb.setServiceClass(MaterialService.class);
		InputStream is = EncodingService.class.getClassLoader().getResourceAsStream("SetSystem.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		String webServiceURL = pro.getProperty("webServiceURL");
		jwpfb.setAddress(webServiceURL);
		MaterialService ms = (MaterialService) jwpfb.create();
		JSONObject postPara = JSONObject.fromObject(params);
		String resultstr = ms.getDWInfo(postPara.toString());
		JSONObject jsonObject = JSONObject.fromObject(resultstr);
		Map stu = (Map) JSONObject.toBean(jsonObject, Map.class);
		return stu;
	}



	/**
	 * @Title: getUnit
	 * @Description: TODO[用一句话描述这个方法的作用]
	 * @param params
	 * @return
	 * @return_type: List<MaterielDevice>
	 */
	public List<Units> getUnit(Map<String, Object> params) {
		return data0017Mapper.getUnit();
	}
	
	public List<MaterielSupplier> getSupplier(Map<String, Object> params) {
		return data0017Mapper.getSupplier(params);
	}

	
	public List<MaterielSupplier> getAllSupplier(Map<String, Object> params) {
		return data0017Mapper.getAllSupplier(params);
	}

	/**
	 * @Title: saveData0017
	 * @Description: TODO[用一句话描述这个方法的作用]
	 * @param params
	 * @throws Exception
	 * @return_type: void
	 */
	public void saveData0017(Data0017 params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		String smallid=params.getProdCodeSellPtr();
		MaterielSmallclass msc=materielSmallclassMapper.getSmallclassById(Integer.parseInt(smallid));
		String extraDesc = msc.getBigcode() + "-" + msc.getCode() + "-";
		String daoed = data0017Mapper.getExtraDesc(extraDesc);
		//生成禾川编码
		if (daoed == null || "".equals(daoed)) {
			extraDesc = extraDesc + "0001";
			params.setExtraDesc(extraDesc);
		} else {
			String[] d = daoed.split("-");
			Integer i = Integer.parseInt(d[2]);
			i += 1;
			DecimalFormat df = new DecimalFormat("0000");
			String str2 = df.format(i);
			extraDesc = extraDesc + str2;
			params.setExtraDesc(extraDesc);
		}
		params.setUserid(user.getId());
		params.setCreatetime(new Date());
		params.setStatus("1");
		//获取工序
		String package_=params.getPackage_();
		MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
		params.setSmtFlag(materielPackage.getProcess()); 
		data0017Mapper.insertSelective(params);
		// 发起审批流程
		Check.startProcessInstance(params, dd_user, "新增物料");
		params.setStatus("2");
		data0017Mapper.updateStatus(params);
		String fileids=params.getFileidstr();
		//关联相关文件
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", params.getId());
			materielFileMapper.updateByids(para);
		}
	}
	
	
	public void editData0017(Data0017 params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		Integer materielId=null;
		Data0017 ThisData = data0017Mapper.getData0017ById(params);
		if (ThisData == null) {
			params.setUserid(user.getId());
			params.setCreatetime(new Date());
			params.setStatus("5");
			data0017Mapper.insertSelective(params);
			Check.startProcessInstance(params, dd_user, "修改物料");// 发起审批流程
			params.setStatus("6");
			data0017Mapper.updateStatus(params);
			materielId=params.getId();
		} else {
			params.setStatus("5");
			params.setId(ThisData.getId());
			data0017Mapper.updateThisData(params);
			Check.startProcessInstance(params, dd_user, "修改物料");// 发起审批流程
			params.setStatus("6");
			data0017Mapper.updateStatus(params);
			materielId=ThisData.getId();
		}
		String fileids=params.getFileidstr();
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", materielId);
			materielFileMapper.updateByids(para);
		}
	}
	
	
	public void saveReplaceData0017(Data0017 params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		params.setUserid(user.getId());
		params.setCreatetime(new Date());
		params.setStatus("1");
		data0017Mapper.insertSelective(params);
		Check.startProcessInstance(params, dd_user, "新增替换料");// 发起审批流程
		params.setStatus("2");
		data0017Mapper.updateStatus(params);
		String fileids=params.getFileidstr();
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", params.getId());
			materielFileMapper.updateByids(para);
		}
	}

	/**
	 * @Title: addUpdateData
	 * @Description: TODO[用一句话描述这个方法的作用]
	 * @param params
	 * @param message
	 * @throws Exception
	 * @return_type: void
	 */
	public void addUpdateData(Data0017 params, User user, String message) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		Data0017 ThisData = data0017Mapper.getData0017ById(params);
		if (ThisData == null) {
			params.setUserid(user.getId());
			params.setCreatetime(new Date());
			params.setStatus("5");
			data0017Mapper.insertSelective(params);
			Check.startProcessInstance(params, dd_user, message);// 发起审批流程
			params.setStatus("6");
			data0017Mapper.updateStatus(params);
		} else {
			ThisData.setStatus("5");
			ThisData.setExtraDesc(params.getExtraDesc());
			data0017Mapper.updateThisData(ThisData);
			Check.startProcessInstance(ThisData, dd_user, message);// 发起审批流程
			ThisData.setStatus("6");
			data0017Mapper.updateStatus(ThisData);
		}
	}
	/**
	 * @Title: getThisPage
	 * @Description: TODO[用一句话描述这个方法的作用]
	 * @param params
	 * @return
	 * @return_type: Map<String,Object>
	 */
	public Map<String, Object> getThisPage(Map<String, Object> params) {
		List<Data0017> list = data0017Mapper.getExportPage(params);
		Integer count = data0017Mapper.getPageExportCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public List<Data0017> getExportData(Map<String, Object> params) {
		return data0017Mapper.getExportData(params);
	}

	/**
	 * @Title: updateThisData
	 * @Description: TODO[用一句话描述这个方法的作用] 更新本地物料数据
	 * @param bean
	 * @return_type: void
	 */
	public void updateThisData(Data0017 bean) {
		data0017Mapper.updateThisData(bean);
	}

	public MaterielFile upload(MultipartFile[] myfile, HttpServletRequest request, Map<String, Object> map)
			throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MaterielFile sm=null;
		if (myfile[0] != null) {
			// 保存附件信息
			InputStream is = myfile[0].getInputStream();
			sm = new MaterielFile();
			sm.setFilesize((int) myfile[0].getSize());
			sm.setFile(Base64Util.fileToBase64(is));
			is.close();
			sm.setRemoved("0");
			String filename=myfile[0].getOriginalFilename();
			sm.setFilename(filename);
			sm.setCreatetime(new Date());
			sm.setFiletype(filename.substring(filename.lastIndexOf(".") + 1));
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			sm.setCreatename(user.getVsername());
			materielFileMapper.insertSelective(sm);
		}
		return sm;
	}

	/**@Title: 		 downloadFile   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param request
	 * @return      
	 * @throws IOException 
	 * @return_type: ResponseEntity<byte []>      
	 */
	public ResponseEntity<byte[]> downloadFile(HttpServletRequest request) throws IOException {
		String id =request.getParameter("id");
		MaterielFile sa=materielFileMapper.selectByPrimaryKey(Integer.parseInt(id));
		String base64Str=sa.getFile();
		String fileName=sa.getFilename();
		byte[] bytes = new BASE64Decoder().decodeBuffer(base64Str); // 将字符串转换为byte数组
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		byte[] buffer = new byte[1024];
		FileOutputStream out = new FileOutputStream(fileName);
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = in.read(buffer)) != -1) {
			bytesum += byteread;
			out.write(buffer, 0, byteread); // 文件写操作
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("utf-8"), "iso-8859-1"));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
	}



	/**@Title: 		 getProdSupper   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<MaterielDevice>      
	 */
	public List<MaterielDevice> getProdSupper(Map<String, Object> params) {
		return materielBrandMapper.getProdSupper(params);
	}



	/**@Title: 		 agree   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param id
	 * @return      
	 * @return_type: int      
	 */
	public int agree(String id) {
		return data0017Mapper.agree(Integer.valueOf(id));
	}



	/**@Title: 		 refuse   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param id
	 * @return      
	 * @return_type: int      
	 */
	public int refuse(String id) {
		return data0017Mapper.refus(Integer.valueOf(id));
	}



	/**@Title: 		 getFilesPre   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<MaterielFile>      
	 */
	public List<MaterielFile> getFilesPre(Map<String, Object> params) {
		return materielFileMapper.getFilesPre(params);
	}



	public Data0017 lodingremark(Integer params) {
		return data0017Mapper.lodingremark(params);
	}

	

}
