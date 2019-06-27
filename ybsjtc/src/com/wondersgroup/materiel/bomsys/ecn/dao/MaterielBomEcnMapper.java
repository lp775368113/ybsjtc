package com.wondersgroup.materiel.bomsys.ecn.dao;

import com.wondersgroup.materiel.bomsys.ecn.vo.MaterielBomEcn;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterielBomEcnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterielBomEcn record);

    int insertSelective(MaterielBomEcn record);

    MaterielBomEcn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterielBomEcn record);

    int updateByPrimaryKey(MaterielBomEcn record);
}