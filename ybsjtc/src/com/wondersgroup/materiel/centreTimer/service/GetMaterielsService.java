package com.wondersgroup.materiel.centreTimer.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.materiel.centreTimer.controller.GetMaterielsController;
import com.wondersgroup.materiel.centreTimer.dao.CentreDao;
import com.wondersgroup.materiel.centreTimer.vo.CentreBigClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSmallClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSupplier;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielBigclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.dao.MaterielCheckMapper;
import com.wondersgroup.materiel.encoding.dao.MaterielFileMapper;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;

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
		CentreDao dao=new CentreDao();
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_INFO表！********");
		List<Data0017> list=dao.getMaterielInfo();
		for (Data0017 cen:list) {
			MaterielCheck po=materielCheckMapper.selectByPrimaryKey(cen.getId());
			int id=cen.getId();
			cen.setCustPartCode(po.getCustPartCode());
			cen.setCustPartName(po.getCustPartName());
			cen.setExtraDesc(po.getExtraDesc());
			cen.setInvPartDescriptionC(po.getInvPartDescriptionC());
			cen.setPackage_(po.getPackage_());
			cen.setProdCodeSellPtr(po.getProdCodeSellPtr());
			cen.setProdSupper(po.getProdSupper());
			cen.setPurchUnitPtr(po.getPurchUnitPtr());
			cen.setSmtFlag(po.getSmtFlag());
			cen.setStdCost(po.getStdCost());
			cen.setStockPurch(po.getStockPurch());
			cen.setStockUnitPtr(po.getStockUnitPtr());
			cen.setSupplierPtr(po.getSupplierPtr());
			cen.setCreatetime(po.getStarttime());
			cen.setRemark(po.getRemark());
			cen.setUserid(po.getUserid());
			cen.setId(null);
			Data0017 bo=data0017Mapper.getMaterielInfoByErpid(cen.getErpid());
			if(bo==null) {
				data0017Mapper.insertSelective(cen);
				Map<String, Object> para=new HashMap<String,Object>();
				para.put("materielId", cen.getId());
				para.put("oldmaterielId", po.getId());
				materielFileMapper.updateFileinfoid(para);
			}else {
				data0017Mapper.updateMaterielInfo(cen);
			}
			dao.okData0017(id);
		}
		logger.info("********结束同步MATERIEL_INFO表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_BIGCLASS表！********");
		List<CentreBigClass> biglist=dao.getBigClass();
		for (CentreBigClass cbs : biglist) {
			MaterielBigclass mb= materielBigclassMapper.getbigClassByclassname(cbs.getGroup_name());
			if(mb!=null) {
				mb.setId(cbs.getRkey());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielBigclassMapper.updateByclassname(mb);
			}else {
				mb=new MaterielBigclass();
				mb.setId(cbs.getRkey());
				mb.setClassname(cbs.getGroup_name());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielBigclassMapper.insertSelective(mb);
			}
			dao.okBigClass(cbs.getRkey());
		}
		logger.info("********结束同步MATERIEL_BIGCLASS表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_SMALLCLASS表！********");
		List<CentreSmallClass> smalllist=dao.getSmallClass();
		for (CentreSmallClass cbc : smalllist) {
			MaterielSmallclass mb= materielSmallclassMapper.getSmallClassByclassname(cbc.getProd_name());
			if(mb!=null) {
				mb.setId(cbc.getRkey());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielSmallclassMapper.updateByclassname(mb);
			}else {
				mb=new MaterielSmallclass();
				mb.setId(cbc.getRkey());
				mb.setClassname(cbc.getProd_name());
				mb.setBigclassid(cbc.getGroup_ptr());
				mb.setRemoved("0");
				mb.setStatus("0");
				materielSmallclassMapper.insertSelective(mb);
			}
			dao.okSmallClass(cbc.getRkey());;
		}
		logger.info("********结束同步MATERIEL_SMALLCLASS表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
		logger.info("********开始同步MATERIEL_SUPPLIER表！********");
		List<CentreSupplier> supplierlist=dao.getSupplier();
		for (CentreSupplier cs : supplierlist) {
			MaterielSupplier mb= materielSupplierMapper.getsupplierByname(cs.getSupplier_name());
			if(mb!=null) {
				mb.setId(cs.getRkey());
				mb.setRemoved("0");
				materielSupplierMapper.updateByname(mb);
			}else {
				mb=new MaterielSupplier();
				mb.setId(cs.getRkey());
				mb.setSupplierName(cs.getSupplier_name());
				mb.setRemoved("0");
				materielSupplierMapper.insertSelective(mb);
			}
			dao.okSupplier(cs.getRkey());;
		}
		logger.info("********结束同步MATERIEL_SUPPLIER表！********");
		logger.info("-----------------------------------------------------------------------------------------------------------------	");
	}

}
