package com.wondersgroup.materiel.encoding.classManagement.dao;

import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielSmallclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterielSmallclass record);

    int insertSelective(MaterielSmallclass record);

    MaterielSmallclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielSmallclass record);

    int updateByPrimaryKey(MaterielSmallclass record);

	List<MaterielSmallclass> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	Integer canDddCode(MaterielSmallclass params);

	Integer canClassName(MaterielSmallclass params);

	List<MaterielSmallclass> getSmallClassPre(Map<String, Object> params);

	MaterielSmallclass getSmallclassById(int parseInt);

	List<MaterielSmallclass> getAllSmallClass(Map<String, Object> params);

}