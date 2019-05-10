package com.wondersgroup.materiel.encoding.brandManagement.dao;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrandSupplier;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielBrandSupplierMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBrandSupplier record);

    int insertSelective(MaterielBrandSupplier record);

    MaterielBrandSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBrandSupplier record);

    int updateByPrimaryKey(MaterielBrandSupplier record);

	MaterielBrandSupplier getBrandSupplier(Map<String, Object> params);

	void saveBrandSupplier(List<MaterielBrandSupplier> addList);

	void updateBrandSupplier(MaterielBrandSupplier brandSupplier);

}