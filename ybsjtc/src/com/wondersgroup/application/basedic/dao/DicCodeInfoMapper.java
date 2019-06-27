package com.wondersgroup.application.basedic.dao;

import com.wondersgroup.application.basedic.vo.DicCodeInfo;
import java.util.List;
import java.util.Map;
public interface DicCodeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DicCodeInfo record);

    int insertSelective(DicCodeInfo record);

    DicCodeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DicCodeInfo record);

    int updateByPrimaryKey(DicCodeInfo record);
    
    List<DicCodeInfo> getDic(Map map);

	List<DicCodeInfo> getProductType();
}