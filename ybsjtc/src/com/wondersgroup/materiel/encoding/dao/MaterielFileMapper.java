package com.wondersgroup.materiel.encoding.dao;
import com.wondersgroup.materiel.encoding.vo.MaterielFile;

import java.util.List;
import java.util.Map;
public interface MaterielFileMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaterielFile record);

    int insertSelective(MaterielFile record);

    MaterielFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielFile record);

    int updateByPrimaryKey(MaterielFile record);

	void updateByids(Map<String, Object> para);

	List<MaterielFile> getFilesPre(Map<String, Object> params);
}