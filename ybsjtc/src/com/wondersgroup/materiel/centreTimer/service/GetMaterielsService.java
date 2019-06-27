package com.wondersgroup.materiel.centreTimer.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.framework.cxf.centerservice.CommonService;
import com.wondersgroup.materiel.centreTimer.controller.GetMaterielsController;
import com.wondersgroup.materiel.centreTimer.dao.CentreDao;
import com.wondersgroup.materiel.centreTimer.vo.CentreBigClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSmallClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSupplier;
import com.wondersgroup.materiel.centreTimer.vo.Data;
import com.wondersgroup.materiel.centreTimer.vo.MaterielBigclass_cen;
import com.wondersgroup.materiel.centreTimer.vo.MaterielSmallclass_cen;
import com.wondersgroup.materiel.centreTimer.vo.MaterielSupplier_cen;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielBigclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.dao.MaterielCheckMapper;
import com.wondersgroup.materiel.encoding.dao.MaterielFileMapper;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;

import net.sf.json.JSONObject;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.zwfw.service]
 * @ClassName:    [QltQlsxService]   
 * @Description:  [政务服务定时任务]  
 * @Author:       [huangyuanfeng]   	   
 * @CreateDate:   [2018-7-10 下午2:56:08]  
 * @UpdateUser:   [huangyuanfeng]   	   
 * @UpdateDate:   [2018-7-10 下午2:56:08]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class GetMaterielsService {
	
	public static Logger logger = Logger.getLogger(GetMaterielsService.class);
	
	@Autowired
	MaterielCheckMapper materielCheckMapper;
	
	@Autowired
	MaterielBigclassMapper materielBigclassMapper;
	
	@Autowired
	MaterielSmallclassMapper materielSmallclassMapper;
	
	@Autowired
	MaterielSupplierMapper materielSupplierMapper;
	
	@Autowired
	MaterielFileMapper materielFileMapper;
	
	@Autowired
	Data0017Mapper data0017Mapper;

	public  void getDate() throws SQLException {
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
		String resultstr = ms.getMaterielInfo("");
		List<Data> list = JSON.parseArray(resultstr, Data.class);
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_INFO表！********");
		for (Data cen:list) {
			MaterielCheck po=materielCheckMapper.selectByPrimaryKey(cen.getId());
			Data0017 info=new Data0017();
			int id=cen.getId();
			info.setErpid(cen.getRkey());
			info.setInvPartNumber(cen.getInvPartNumber());
			info.setCustPartCode(po.getCustPartCode());
			info.setCustPartName(po.getCustPartName());
			info.setTtype("1");
			info.setExtraDesc(po.getExtraDesc());
			info.setInvPartDescriptionC(po.getInvPartDescriptionC());
			info.setPackage_(po.getPackage_());
			info.setProdCodeSellPtr(po.getProdCodeSellPtr());
			info.setProdSupper(po.getProdSupper());
			info.setPurchUnitPtr(po.getPurchUnitPtr());
			info.setSmtFlag(po.getSmtFlag());
			info.setStdCost(po.getStdCost());
			info.setStockPurch(po.getStockPurch());
			info.setStockUnitPtr(po.getStockUnitPtr());
			info.setSupplierPtr(po.getSupplierPtr());
			info.setCreatetime(po.getStarttime());
			info.setRemark(po.getRemark());
			info.setUserid(po.getUserid());
			info.setFilename(po.getFilename());
			info.setSchematic(po.getSchematic());
			info.setPeVersion(po.getPeVersion());
			info.setPeVersionDate(po.getPeVersionDate());
			info.setId(null);
			Data0017 bo=data0017Mapper.getMaterielInfoByErpid(cen.getRkey());
			if(bo==null) {
				data0017Mapper.insertSelective(info);
				Map<String, Object> para=new HashMap<String,Object>();
				para.put("materielId", info.getId());
				para.put("oldmaterielId", po.getId());
				materielFileMapper.updateFileinfoid(para);
			}else {
				data0017Mapper.updateMaterielInfo(info);
			}
		}
		logger.info("********结束同步MATERIEL_INFO表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_BIGCLASS表！********");
		String resultstr1 = ms.getBigClasss("");
		List<MaterielBigclass_cen> list1 = JSON.parseArray(resultstr1, MaterielBigclass_cen.class);
		
		for (MaterielBigclass_cen cbs : list1) {
			MaterielBigclass mb= materielBigclassMapper.getbigClassByclassname(cbs.getGroupName());
			if(mb!=null) {
				mb.setId(cbs.getRkey());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielBigclassMapper.updateByclassname(mb);
			}else {
				mb=new MaterielBigclass();
				mb.setId(cbs.getRkey());
				mb.setClassname(cbs.getGroupName());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielBigclassMapper.insertSelective(mb);
			}
		}
		logger.info("********结束同步MATERIEL_BIGCLASS表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_SMALLCLASS表！********");
		String resultstr2 = ms.getSmallClasss("");
		List<MaterielSmallclass_cen> list2 = JSON.parseArray(resultstr2, MaterielSmallclass_cen.class);
		for (MaterielSmallclass_cen cbc : list2) {
			MaterielSmallclass mb= materielSmallclassMapper.getSmallClassByclassname(cbc.getProdName());
			if(mb!=null) {
				mb.setId(cbc.getRkey());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielSmallclassMapper.updateByclassname(mb);
			}else {
				mb=new MaterielSmallclass();
				mb.setId(cbc.getRkey());
				mb.setClassname(cbc.getProdName());
				mb.setBigclassid(cbc.getGroupPtr());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielSmallclassMapper.insertSelective(mb);
			}
		}
		logger.info("********结束同步MATERIEL_SMALLCLASS表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_SUPPLIER表！********");
		String resultstr3 = ms.getSupplier("");
		List<MaterielSupplier_cen> list3 = JSON.parseArray(resultstr3, MaterielSupplier_cen.class);
		for (MaterielSupplier_cen cs : list3) {
			MaterielSupplier mb= materielSupplierMapper.getsupplierByname(cs.getSupplierName());
			if(mb!=null) {
				mb.setId(cs.getRkey());
				mb.setRemoved("0");
				materielSupplierMapper.updateByname(mb);
			}else {
				mb=new MaterielSupplier();
				mb.setId(cs.getRkey());
				mb.setSupplierName(cs.getSupplierName());
				mb.setRemoved("0");
				materielSupplierMapper.insertSelective(mb);
			}
		}
		logger.info("********结束同步MATERIEL_SUPPLIER表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
 	}

}
