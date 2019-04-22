package com.wondersgroup.materiel.encoding.dao;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;
import com.wondersgroup.materiel.encoding.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.vo.Units;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface MaterielDeviceMapper {

    int insert(MaterielDevice record);

    int insertSelective(MaterielDevice record);

	List<MaterielDevice> getMaxClass();

	List<MaterielDevice> getMinClass(Map<String, Object> params);

	List<Units> getUnit();

	List<MaterielSupplier> getSupplier();

	MaterielDevice getWLMS(Map<String, Object> params);

	String getExtraDesc(String extraDesc);
	
}