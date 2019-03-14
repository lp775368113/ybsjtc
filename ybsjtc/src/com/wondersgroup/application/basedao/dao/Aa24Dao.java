package com.wondersgroup.application.basedao.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.application.basedao.bo.Aa24;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
@MapperScan
public interface Aa24Dao extends BaseDAO<BaseObject>{
	
	public void  save(Aa24 aa24);
	
	public void  update(Aa24 aa24);

}
