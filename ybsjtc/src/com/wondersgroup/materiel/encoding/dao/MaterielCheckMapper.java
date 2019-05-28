package com.wondersgroup.materiel.encoding.dao;

import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterielCheckMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielCheck record);

    int insertSelective(MaterielCheck record);

    MaterielCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielCheck record);

    int updateByPrimaryKey(MaterielCheck record);

	List<Data0017> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	void  agree(Integer valueOf);

	void refuse(Integer valueOf);
}