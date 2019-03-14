package com.wondersgroup.application.basedao.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.application.basedao.bo.Aa03;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
@MapperScan
public interface Aa03Dao extends BaseDAO<BaseObject>{
	
	public void  save(Aa03 aa03);
	
	public void  update(Aa03 aa03);

}
