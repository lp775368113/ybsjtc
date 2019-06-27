package com.wondersgroup.materiel.encoding.brandManagement.dao;

import java.util.List;
import java.util.Map;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;

public interface MaterielBrandMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBrand record);

    int insertSelective(MaterielBrand record);

    MaterielBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBrand record);

    int updateByPrimaryKey(MaterielBrand record);

	List<MaterielBrand> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	MaterielBrand getProdSupperId(String brandname);

	Integer countBrandname(MaterielBrand brand);

	List<MaterielBrand> getProdSupper(Map<String, Object> params);

	List<MaterielBrand> queryClassBrandPage(Map<String, Object> params);

	Integer queryClassBrandCount(Map<String, Object> params);

	List<MaterielBrand> queryClassBrandPre(Map<String, Object> params);
}