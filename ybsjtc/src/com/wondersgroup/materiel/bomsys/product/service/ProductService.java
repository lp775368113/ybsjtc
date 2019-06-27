package com.wondersgroup.materiel.bomsys.product.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.materiel.bomsys.product.dao.MaterielProductMapper;
import com.wondersgroup.materiel.bomsys.product.vo.MaterielProduct;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandMapper;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielBrandSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.dao.MaterielSupplierMapper;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrandSupplier;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
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
public class ProductService {
	public static Logger logger = Logger.getLogger(ProductService.class);

	@Autowired
	MaterielProductMapper materielProductMapper;


	public Map<String, Object> getPage(Map<String, Object> params) {
		List<MaterielProduct> list=materielProductMapper.getPage(params);
		Integer count=materielProductMapper.getCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}


	public void addProduct(MaterielProduct materielProduct) {
		materielProduct.setCreatetime(new Date());
		materielProduct.setRemoved("0");
		materielProductMapper.insertSelective(materielProduct);
	}


	public void updateProduct(MaterielProduct materielProduct) {
		materielProduct.setUpdatetime(new Date());
		materielProductMapper.updateByPrimaryKeySelective(materielProduct);
	}


}
