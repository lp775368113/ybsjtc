package com.wondersgroup.materiel.encoding.classManagement.dao;

import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;

import java.util.List;
import java.util.Map;

public interface MaterielBigclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBigclass record);

    int insertSelective(MaterielBigclass record);

    MaterielBigclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBigclass record);

    int updateByPrimaryKey(MaterielBigclass record);

    List<MaterielBigclass> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	Integer canDddCode(MaterielBigclass params);

	Integer canClassName(MaterielBigclass params);

	List<MaterielBigclass> getAllbigclass();

	List<MaterielBigclass> getAllbigclassPre(Map<String, Object> params);

	List<MaterielSmallclass> getBigClassBySmallclassid(Map<String, Object> params);

	MaterielBigclass getbigClassByclassname(String group_name);

	void updateByclassname(MaterielBigclass mb);
}