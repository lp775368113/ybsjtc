package com.wondersgroup.application.basedao.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.application.basedao.bo.Ae02;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
@MapperScan
public interface Ae02Dao extends BaseDAO<BaseObject>{
	
	public void  save(Ae02 ae02);
	
	public void  update(Ae02 ae02);

}
