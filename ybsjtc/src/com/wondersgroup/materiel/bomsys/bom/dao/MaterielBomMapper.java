package com.wondersgroup.materiel.bomsys.bom.dao;

import com.wondersgroup.materiel.bomsys.bom.vo.MaterielBom;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielBomMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBom record);

    int insertSelective(MaterielBom record);
    
    int insertBomEdit(MaterielBom record);

    MaterielBom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBom record);

    int updateByPrimaryKey(MaterielBom record);

	List<MaterielBom> queryBom(Map<String, Object> params);
	
	Integer getMaxVersion(Integer productid);

	List<MaterielBom> queryBomEdit(Map<String, Object> params);

	List<Map> getAllVersion(Map<String, Object> param);

	Integer canImportBom(Map<String, Object> param);
}