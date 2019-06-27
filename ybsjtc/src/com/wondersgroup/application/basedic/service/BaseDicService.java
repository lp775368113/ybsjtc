package com.wondersgroup.application.basedic.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.application.basedic.dao.DicCodeInfoMapper;
import com.wondersgroup.application.basedic.vo.DicCodeInfo;
import com.wondersgroup.materiel.bomsys.product.dao.MaterielProductMapper;
import com.wondersgroup.materiel.bomsys.product.vo.MaterielProduct;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandMapper;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrandSupplier;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.permission.role.vo.Role;
import com.wondersgroup.permission.user.vo.User;
import com.wondersgroup.permission.userRole.vo.UserRole;
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
public class BaseDicService {
	public static Logger logger = Logger.getLogger(BaseDicService.class);

	@Autowired
	private DicCodeInfoMapper dicCodeInfoMapper;


	public  List<DicCodeInfo> getDic(Map<String, Object> params) {
		return dicCodeInfoMapper.getDic(params);
	}


	/**@Title: 		 getProductType   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: List<DicCodeInfo>      
	 */
	public List<Map<String,Object>> getProductType(Map<String, Object> params) {
		List<DicCodeInfo> list=dicCodeInfoMapper.getProductType();
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
		for (DicCodeInfo info : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", info.getCode());
			map.put("pid", info.getParentid());
			map.put("text", info.getName());
			map.put("isLeaf", true);
			map.put("expanded", false);
			treeList.add(map);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "82");
		map.put("pid", "-9");
		map.put("text", "半成品");
		map.put("isLeaf", false);
		map.put("expanded", false);
		treeList.add(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", "23");
		map1.put("pid", "-2");
		map1.put("text", "成品");
		map1.put("isLeaf", false);
		map1.put("expanded", false);
		treeList.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", "101");
		map2.put("pid", "-10");
		map2.put("text", "虚拟产品");
		map2.put("isLeaf", false);
		map2.put("expanded", false);
		treeList.add(map2);
		return treeList;
	}


}
