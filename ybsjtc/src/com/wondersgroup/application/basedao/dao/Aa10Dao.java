package com.wondersgroup.application.basedao.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.application.basedao.bo.Aa10;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
@MapperScan
public interface Aa10Dao extends BaseDAO<BaseObject>{
	
	public void  save(Aa10 aa10);
	
	public void  update(Aa10 aa10);

}
