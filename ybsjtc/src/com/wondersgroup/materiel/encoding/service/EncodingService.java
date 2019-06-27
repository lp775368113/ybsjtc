package com.wondersgroup.materiel.encoding.service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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
import com.wondersgroup.framework.cxf.centerservice.CommonService;
import com.wondersgroup.framework.cxf.materialservice.MaterialService;
import com.wondersgroup.framework.dbutil.centre.CentreDao;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.framework.dingding.util.AccessTokenUtil;
import com.wondersgroup.framework.dingding.util.CheckMateriel;
import com.wondersgroup.framework.util.Base64Util;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandMapper;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielBigclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.dao.MaterielCheckMapper;
import com.wondersgroup.materiel.encoding.dao.MaterielFileMapper;
import com.wondersgroup.materiel.encoding.packageManagement.dao.MaterielPackageMapper;
import com.wondersgroup.materiel.encoding.packageManagement.vo.MaterielPackage;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;
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
	MaterielCheckMapper materielCheckMapper;
	
	@Autowired
	MaterielPackageMapper materielPackageMapper;
	
	@Autowired
	MaterielSmallclassMapper materielSmallclassMapper;
	
	@Autowired
	MaterielBigclassMapper materielBigclassMapper;
	
	public List<Map<String, Object>> treeList(Map<String, Object> params) {
		List<MaterielBigclass> list = materielBigclassMapper.getAllbigclass();
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
		for (MaterielBigclass big : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", big.getId());
			map.put("text", big.getClassname());
			map.put("type","bigclass");
			map.put("isLeaf", false);
			map.put("expanded", false);
			treeList.add(map);
		}
		return treeList;
	}

	public Map<String, Object> getPage(Map<String, Object> params) {
		String status=(String) params.get("status");
		String productType=(String)params.get("productType");
		if(productType!=null&&productType!="") {
			params.put("prodCodeSellPtr", productType);
		}
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
			
			String ipdcSTR=(String) params.get("ipdcSTR");
			if(!"".equals(ipdcSTR)&&ipdcSTR!=null) {
				ipdcSTR=ipdcSTR.toUpperCase();
				String [] list = ipdcSTR.split("\\s+");
				 List<String> stringB = Arrays.asList(list);
				 params.put("list", stringB);
			}
			List<Data0017> list=data0017Mapper.getPage(params);
			if(list.size()>0) {
				String kerys="";
				for (int i = 0; i < list.size(); i++) {
					if(i==0) {
						kerys=String.valueOf(list.get(i).getErpid());
					}else {
						kerys=kerys+","+list.get(i).getErpid();
					}
				}
				Map<String,Object> reqpara=new HashMap<String,Object>();
				reqpara.put("rkeys", kerys);
				JSONObject postPara = JSONObject.fromObject(reqpara);
				String resultstr = ms.getWLInfo(postPara.toString());
				JSONObject jsonObject = JSONObject.fromObject(resultstr);
				Map stu = (Map) JSONObject.toBean(jsonObject, Map.class);
				for(int i = 0; i < list.size(); i++) {
					String kery=String.valueOf(list.get(i).getErpid());
					list.get(i).setWarehouse((String)stu.get(kery));
				}
			}
			Integer count=data0017Mapper.getPageCount(params);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", count);
			result.put("data", list);
			return result;
		}else {
			String ipdcSTR=(String) params.get("ipdcSTR");
			if(!"".equals(ipdcSTR)&&ipdcSTR!=null) {
				 String [] list = ipdcSTR.split("\\s+");
				 List<String> stringB = Arrays.asList(list);
				 params.put("list", stringB);
			}
			List<Data0017> list=materielCheckMapper.getPage(params);
			Integer count=materielCheckMapper.getPageCount(params);
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
//		JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
//		jwpfb.setServiceClass(MaterialService.class);
//		InputStream is = EncodingService.class.getClassLoader().getResourceAsStream("SetSystem.properties");
//		Properties pro = new Properties();
//		try {
//			pro.load(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//			logger.error(e.getMessage(), e);
//		}
//		String webServiceURL = pro.getProperty("webServiceURL");
//		jwpfb.setAddress(webServiceURL);
//		MaterialService ms = (MaterialService) jwpfb.create();
//		JSONObject postPara = JSONObject.fromObject(params);
//		String resultstr = ms.getDWInfo(postPara.toString());
//		JSONObject jsonObject = JSONObject.fromObject(resultstr);
//		Map stu = (Map) JSONObject.toBean(jsonObject, Map.class);
		Integer cpc=data0017Mapper.countCustPartCode(params);
		Integer ipdc=data0017Mapper.countInvPartDescriptionC(params);
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("countCustPartCode", (cpc==0)?true:false);
		result.put("conutInvPartDescriptionC", (ipdc==0)?true:false);
		return result;
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
	public void saveData0017(MaterielCheck params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new RuntimeException("您的账户和钉钉未绑定！请联系管理员！");
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
		params.setStarttime(new Date());
		params.setStatus("1");//审核中的数据
		//获取工序
		String package_=params.getPackage_();
		MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
		params.setSmtFlag(materielPackage.getProcess()); 
		params.setTtype("1");//物料
		materielCheckMapper.insertSelective(params);
		// 发起审批流程
		CheckMateriel.startProcessInstance(params, dd_user, "新增物料");
		String fileids=params.getFileidstr();
		//关联相关文件
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", params.getId());
			materielFileMapper.updateByids(para);
		}
	}
	
	public void saveProduct(MaterielCheck params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new RuntimeException("您的账户和钉钉未绑定！请联系管理员！");
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
		params.setStarttime(new Date());
		params.setStatus("1");//审核中的数据
		//获取工序
		String package_=params.getPackage_();
		MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
		params.setSmtFlag(materielPackage.getProcess()); 
		params.setProdCodeSellPtr(params.getProductType());
		materielCheckMapper.insertSelective(params);
		// 发起审批流程
		CheckMateriel.startProcessInstance(params, dd_user, "新增物料");
		String fileids=params.getFileidstr();
		//关联相关文件
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", params.getId());
			materielFileMapper.updateByids(para);
		}
	}
	
	public void editData0017(MaterielCheck params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		Integer materielId=null;
		params.setUserid(user.getId());
		params.setStarttime(new Date());
		params.setStatus("1");//审核中的数据
		//获取工序
				String package_=params.getPackage_();
				MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
				params.setSmtFlag(materielPackage.getProcess()); 
		params.setWlid(params.getId());
		materielCheckMapper.insertSelective(params);
		CheckMateriel.startProcessInstance(params, dd_user, "修改物料");// 发起审批流程
		String fileids=params.getFileidstr();
		materielId=params.getId();
		if(!"".equals(fileids)) {
			Map<String,Object> para=new HashMap<String,Object>();
			para.put("fileids", fileids);
			para.put("materielId", materielId);
			materielFileMapper.updateByids(para);
		}
	}
	
	
	public void saveReplaceData0017(MaterielCheck params, User user) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		params.setUserid(user.getId());
		params.setStarttime(new Date());
		params.setStatus("1");
		//获取工序
				String package_=params.getPackage_();
				MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
				params.setSmtFlag(materielPackage.getProcess()); 
		materielCheckMapper.insertSelective(params);
		CheckMateriel.startProcessInstance(params, dd_user, "新增替换料");// 发起审批流程
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
	public void addUpdateData(MaterielCheck params, User user, String message) throws Exception {
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new Exception("您的账户和钉钉未绑定！请联系管理员！");
		}
		params.setUserid(user.getId());
		params.setStarttime(new Date());
		params.setStatus("1");//审核中的数据
		//获取工序
				String package_=params.getPackage_();
				if(package_!=null&&"".equals(package_)) {
					MaterielPackage materielPackage=materielPackageMapper.selectByPrimaryKey(Integer.parseInt(package_)); 
					params.setSmtFlag(materielPackage.getProcess()); 
				}
		params.setWlid(params.getId());
		materielCheckMapper.insertSelective(params);
		CheckMateriel.startProcessInstance(params, dd_user, message);// 发起审批流程
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
	public List<MaterielBrand> getProdSupper(Map<String, Object> params) {
		return materielBrandMapper.getProdSupper(params);
	}



	/**@Title: 		 agree   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param id
	 * @return      
	 * @throws SQLException 
	 * @return_type: int      
	 */
	public void agree(String id) throws SQLException {
		  materielCheckMapper.agree(Integer.valueOf(id));//更新审核表状态
		  MaterielCheck agree=materielCheckMapper.selectByPrimaryKey(Integer.valueOf(id));//
		  if(agree.getPackage_()!=null) {
			  Integer packageid=Integer.parseInt(agree.getPackage_());
			  MaterielPackage pg= materielPackageMapper.selectByPrimaryKey(packageid);
			  agree.setPackage_(pg.getPackagename());
		  }
		  if(agree.getProdSupper()!=null) {
			  Integer prodSupperid=Integer.parseInt(agree.getProdSupper());
			  MaterielBrand bd=materielBrandMapper.selectByPrimaryKey(prodSupperid);
			  if(bd!=null&&bd.getBrandname()!=null) {
				  agree.setProdSupper(bd.getBrandname());
			  }
		  }
		  JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
			jwpfb.setServiceClass(CommonService.class);
			InputStream is = EncodingService.class.getClassLoader().getResourceAsStream("SetSystem.properties");
			Properties pro = new Properties();
			try {
				pro.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String URL = pro.getProperty("centerServiceURL");
			jwpfb.setAddress(URL);
			CommonService ms = (CommonService) jwpfb.create();
			JSONObject postPara = JSONObject.fromObject(agree);
			String resultstr = ms.insertMaterielInfo(postPara.toString());
			JSONObject jsonObject = JSONObject.fromObject(resultstr);
			Map stu = (Map) JSONObject.toBean(jsonObject, Map.class);
			if(!(boolean)stu.get("success")) {
				logger.error(stu.get("message"));
			}
	}



	/**@Title: 		 refuse   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param id
	 * @return      
	 * @return_type: int      
	 */
	public void refuse(String id) {
		 materielCheckMapper.refuse(Integer.valueOf(id));//更新审核表状态
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



	/**@throws UnsupportedEncodingException 
	 * @Title: 		 updatedata0017   
	 * @Description: TODO[用一句话描述这个方法的作用]         
	 * @return_type: void      
	 */
	public  void updatedata0017() throws UnsupportedEncodingException {
		List<Data0017> list=data0017Mapper.getAllData();
		for(Data0017 po:list) {
			if(po.getCustPartCode()!=""&&po.getCustPartCode()!=null) {
				po.setCustPartCode(getZW(po.getCustPartCode()));
			}
			if(po.getCustPartName()!=""&&po.getCustPartName()!=null) {
				po.setCustPartName(getZW(po.getCustPartName()));
			}
			if(po.getExtraDesc()!=""&&po.getExtraDesc()!=null) {
				po.setExtraDesc(getZW(po.getExtraDesc()));
			}
			if(po.getProdSupper()!=""&&po.getProdSupper()!=null) {
				po.setProdSupper(getZW(po.getProdSupper()));
			}
			if(po.getPackage_()!=""&&po.getPackage_()!=null){
				po.setPackage_(getZW(po.getPackage_()));
			}
			if(po.getInvPartDescriptionC()!=""&&po.getInvPartDescriptionC()!=null) {
				po.setInvPartDescriptionC(getZW(po.getInvPartDescriptionC()));
			}
			po.setCreatetime(new Date());
			po.setUserid(1);
			data0017Mapper.updateThisData(po);
			System.out.println("更新一条成功！"+po.toString());
		}
	}
	
	public  String getZW(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO8859-1"),"gbk");
	}

	/**@Title: 		 getOneMaterial   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: Data0017      
	 */
	public Data0017 getOneMaterial(Map<String, Object> params) {
		return data0017Mapper.getOneMaterial(params);
	}

}
