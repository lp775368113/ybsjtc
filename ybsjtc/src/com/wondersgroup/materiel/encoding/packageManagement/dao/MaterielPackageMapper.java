package com.wondersgroup.materiel.encoding.packageManagement.dao;

import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.packageManagement.vo.MaterielPackage;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielPackageMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielPackage record);

    int insertSelective(MaterielPackage record);

    MaterielPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielPackage record);

    int updateByPrimaryKey(MaterielPackage record);

	List<MaterielBigclass> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	List<MaterielPackage> getPackage(Map<String, Object> params);

	Integer countPackagename(MaterielPackage materielPackage);
}