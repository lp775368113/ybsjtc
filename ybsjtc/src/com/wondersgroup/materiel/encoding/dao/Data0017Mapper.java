package com.wondersgroup.materiel.encoding.dao;

import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.vo.Units;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Data0017Mapper {


    int insertSelective(Data0017 record);
    
    List<Data0017> getExportPage(Map map);
    
    Integer getPageExportCount(Map map);

	String getExtraDesc(String extraDesc);

	List<Data0017> getExportData(Map<String, Object> params);

	void updateThisData(Data0017 bean);

	void updateStatus(Data0017 params);

	Data0017 getData0017ById(Data0017 params);

	int agree(Integer id);

	int refus(Integer id);

	List<Units> getUnit();

	List<MaterielSupplier> getSupplier(Map map);

	List<MaterielSupplier> getAllSupplier(Map<String, Object> params);

	Data0017 lodingremark(Integer params);

	List<Data0017> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);
}