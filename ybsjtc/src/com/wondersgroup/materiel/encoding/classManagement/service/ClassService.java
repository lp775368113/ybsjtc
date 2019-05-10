package com.wondersgroup.materiel.encoding.classManagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielBigclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
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
public class ClassService {
	public static Logger logger = Logger.getLogger(ClassService.class);

	@Autowired
	MaterielBigclassMapper materielBigclassMapper;
	
	@Autowired
	MaterielSmallclassMapper materielSmallclassMapper;


	public Map<String, Object> querybigclass(Map<String, Object> params) {
		List<MaterielBigclass> list=materielBigclassMapper.getPage(params);
		Integer count=materielBigclassMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}


	public void savebigclass(MaterielBigclass params) throws Exception{
		Integer countCode=materielBigclassMapper.canDddCode(params);
		Integer countClassName=materielBigclassMapper.canClassName(params);
		if(countCode!=0) {
			throw new Exception("系统编码已存在，请更换！");
		}else if(countClassName!=0) {
			throw new Exception("系统大类名称已存在，请更换！");
		}
		params.setRemoved("0");
		params.setStatus("1");
		materielBigclassMapper.insertSelective(params);
	}


	public void updatebigclass(MaterielBigclass params) throws Exception {
		Integer countCode=materielBigclassMapper.canDddCode(params);
		if(countCode!=0) {
			throw new Exception("系统编码已存在，请更换！");
		}
		materielBigclassMapper.updateByPrimaryKeySelective(params);
	}
	
	public List<MaterielBigclass> getAllbigclass() {
		return materielBigclassMapper.getAllbigclass();
	}


	public Map<String, Object> querysmallclass(Map<String, Object> params) {
		List<MaterielSmallclass> list=materielSmallclassMapper.getPage(params);
		Integer count=materielSmallclassMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}


	public void savesmallclass(MaterielSmallclass params) throws Exception {
		Integer countCode=materielSmallclassMapper.canDddCode(params);
		Integer countClassName=materielSmallclassMapper.canClassName(params);
		if(countCode!=0) {
			throw new Exception("系统编码已存在，请更换！");
		}else if(countClassName!=0) {
			throw new Exception("系统小类名称已存在，请更换！");
		}
		params.setRemoved("0");
		params.setStatus("1");
		materielSmallclassMapper.insertSelective(params);
		
	}

	public void updatesmallclass(MaterielSmallclass params) throws Exception {
		Integer countCode=materielSmallclassMapper.canDddCode(params);
		Integer countClassName=materielSmallclassMapper.canClassName(params);
		if(countCode!=0) {
			throw new Exception("系统编码已存在，请更换！");
		}
		materielSmallclassMapper.updateByPrimaryKeySelective(params);
	}


	public List<MaterielSmallclass> getSmallClassPre(Map<String, Object> params) {
		return materielSmallclassMapper.getSmallClassPre(params);
	}
	
	
	public List<MaterielSmallclass> getAllSmallClass(Map<String, Object> params) {
		return materielSmallclassMapper.getAllSmallClass(params);
	}


	public List<MaterielBigclass> getAllbigclassPre() {
		return materielBigclassMapper.getAllbigclassPre();
	}


	public MaterielSmallclass getSmallclassById(Map<String, Object> params) {
		Integer id=Integer.parseInt((String)params.get("id"));
		return materielSmallclassMapper.selectByPrimaryKey(id);
	}


	public List<MaterielSmallclass> getBigClassBySmallclassid(Map<String, Object> params) {
		return materielBigclassMapper.getBigClassBySmallclassid(params);
	}
}
