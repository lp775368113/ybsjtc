package com.wondersgroup.materiel.bomsys.product.dao;

import com.wondersgroup.materiel.bomsys.product.vo.MaterielProduct;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielProductMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielProduct record);

    int insertSelective(MaterielProduct record);

    MaterielProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielProduct record);

    int updateByPrimaryKey(MaterielProduct record);

	List<MaterielProduct> getPage(Map<String, Object> params);

	Integer getCount(Map<String, Object> params);
}