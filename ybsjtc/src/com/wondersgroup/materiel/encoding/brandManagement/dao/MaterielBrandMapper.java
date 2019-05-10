package com.wondersgroup.materiel.encoding.brandManagement.dao;

import java.util.List;
import java.util.Map;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;

public interface MaterielBrandMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBrand record);

    int insertSelective(MaterielBrand record);

    MaterielBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBrand record);

    int updateByPrimaryKey(MaterielBrand record);

	List<MaterielBrand> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	List<MaterielDevice> getProdSupper(Map<String, Object> params);

	MaterielBrand getProdSupperId(String brandname);

	Integer countBrandname(MaterielBrand brand);
}