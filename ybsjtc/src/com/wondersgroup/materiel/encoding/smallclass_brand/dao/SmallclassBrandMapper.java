package com.wondersgroup.materiel.encoding.smallclass_brand.dao;

import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.smallclass_brand.vo.SmallclassBrand;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SmallclassBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmallclassBrand record);

    int insertSelective(SmallclassBrand record);

    SmallclassBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallclassBrand record);

    int updateByPrimaryKey(SmallclassBrand record);
    
    SmallclassBrand getSmallClassBrand(Map map);
    
    void saveSmallClassBrand(List<SmallclassBrand> list);

}