package com.wondersgroup.application.basedao.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.application.basedao.bo.Ke08;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
@MapperScan
public interface Ke08Dao extends BaseDAO<BaseObject>{
	
	public void  save(Ke08 ke08);
	
	public void  update(Ke08 ke08);

}
