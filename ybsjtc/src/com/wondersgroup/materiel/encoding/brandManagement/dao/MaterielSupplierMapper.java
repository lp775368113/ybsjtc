package com.wondersgroup.materiel.encoding.brandManagement.dao;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielSupplierMapper {
    int insert(MaterielSupplier record);

    int insertSelective(MaterielSupplier record);

	List<MaterielBrand> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);
}