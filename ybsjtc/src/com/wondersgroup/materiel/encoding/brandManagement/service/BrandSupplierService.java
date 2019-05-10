package com.wondersgroup.materiel.encoding.brandManagement.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
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
public class BrandSupplierService {
	public static Logger logger = Logger.getLogger(BrandSupplierService.class);

	@Autowired
	MaterielSupplierMapper materielSupplierMapper;

	@Autowired
	MaterielBrandMapper materielBrandMapper;
	
	@Autowired
	MaterielBrandSupplierMapper materielBrandSupplierMapper;

	public void addBrand(MaterielBrand brand) throws Exception {
		Integer count=materielBrandMapper.countBrandname(brand);
		if(count!=0) {
			throw new RuntimeException("品牌名称已存在");
		}
		materielBrandMapper.insertSelective(brand);
	}

	public Map<String, Object> getBrandPage(Map<String, Object> params) {
		List<MaterielBrand> list=materielBrandMapper.getPage(params);
		Integer count=materielBrandMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public Map<String, Object> getSupplierPage(Map<String, Object> params) {
		List<MaterielBrand> list=materielSupplierMapper.getPage(params);
		Integer count=materielSupplierMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public void addSupplier(MaterielSupplier supplier) throws Exception {
		Integer count=materielSupplierMapper.countSuppliername(supplier);
		if(count!=0) {
			throw new RuntimeException("代理商名称已存在");
		}
		materielSupplierMapper.insertSelective(supplier);
	}

	public boolean changeBrandSupplier(Map<String, Object> map) {
		String brandid = map.get("brandid") != null ? map.get("brandid").toString() : "";
		String supplierid = map.get("supplierid") != null ? map.get("supplierid").toString() : "";
		String json = map.get("data").toString();
		List<MaterielBrandSupplier> addList = new ArrayList<MaterielBrandSupplier>();
		List<MaterielBrandSupplier> updateList = new ArrayList<MaterielBrandSupplier>();
		if (StringUtils.isNotEmpty(supplierid)) {
			List<MaterielBrand> list = JSONArray.parseArray(json, MaterielBrand.class);
			for (MaterielBrand brand : list) {
				boolean flag = false;// 默认更新
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("supplierid", Integer.valueOf(supplierid));
				params.put("brandid", brand.getId());
				MaterielBrandSupplier materielBrandSupplier = materielBrandSupplierMapper.getBrandSupplier(params);
				if (materielBrandSupplier == null) {
					materielBrandSupplier = new MaterielBrandSupplier();
					flag = true;
				}
				materielBrandSupplier.setSupplierid(Integer.valueOf(supplierid));
				materielBrandSupplier.setBrandid(brand.getId());
				// 判断是删除还是增加
				if ("added".equals(brand.get_state())) {
					materielBrandSupplier.setRemoved("0");
				} else if ("removed".equals(brand.get_state())) {
					materielBrandSupplier.setRemoved("1");
				}
				// 判断是insert还是update
				if (flag) {
					addList.add(materielBrandSupplier);
				} else {
					updateList.add(materielBrandSupplier);
				}
			}
		} else if (StringUtils.isNotEmpty(brandid)) {
			List<MaterielSupplier> list = JSONArray.parseArray(json, MaterielSupplier.class);
			for (MaterielSupplier materielSupplier : list) {
				boolean flag = false;// 默认更新
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("supplierid", materielSupplier.getId());
				params.put("brandid", Integer.valueOf(brandid));
				MaterielBrandSupplier materielBrandSupplier = materielBrandSupplierMapper.getBrandSupplier(params);
				if (materielBrandSupplier == null) {
					materielBrandSupplier = new MaterielBrandSupplier();
					flag = true;
				}

				materielBrandSupplier.setSupplierid(materielSupplier.getId());
				materielBrandSupplier.setBrandid(Integer.valueOf(brandid));
				// 判断是删除还是增加
				if ("added".equals(materielSupplier.get_state())) {
					materielBrandSupplier.setRemoved("0");
				} else if ("removed".equals(materielSupplier.get_state())) {
					materielBrandSupplier.setRemoved("1");
				}
				// 判断是insert还是update
				if (flag) {
					addList.add(materielBrandSupplier);
				} else {
					updateList.add(materielBrandSupplier);
				}
			}
		} else {
			return false;
		}
		if (addList.size() > 0) {
			materielBrandSupplierMapper.saveBrandSupplier(addList);
		}
		if (updateList.size() > 0) {
			for(MaterielBrandSupplier brandSupplier:updateList) {
				materielBrandSupplierMapper.updateBrandSupplier(brandSupplier);
			}
		}
		return true;
	}

	public MaterielBrand getProdSupperId(String brandname) {
		return materielBrandMapper.getProdSupperId(brandname);
	}

	public MaterielSupplier getProdSupperId(Integer id) {
		return materielSupplierMapper.getProdSupperId(id);
	}

}
