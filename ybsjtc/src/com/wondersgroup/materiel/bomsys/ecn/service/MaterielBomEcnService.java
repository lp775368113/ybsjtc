package com.wondersgroup.materiel.bomsys.ecn.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wondersgroup.materiel.bomsys.ecn.dao.MaterielBomEcnMapper;
import com.wondersgroup.materiel.bomsys.ecn.vo.MaterielBomEcn;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.sysSetup.paramManage.service]
 * @ClassName: [SysParameterService]
 * @Description: [一句话描述该类的功能]
 * @Author: [wumengfei]
 * @CreateDate: [2018-6-21 下午2:39:59]
 * @UpdateUser: [wumengfei]
 * @UpdateDate: [2018-6-21 下午2:39:59]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
@Service
public class MaterielBomEcnService {
	public static Logger logger = Logger.getLogger(MaterielBomEcnService.class);

	@Autowired
	private MaterielBomEcnMapper materielBomEcnMapper;

	public void agree(String id) {
		MaterielBomEcn up=new MaterielBomEcn();
		up.setId(Integer.parseInt(id));
		up.setCheckStatus("2");
		up.setCheckTime(new Date());
		materielBomEcnMapper.updateByPrimaryKeySelective(up);
	}

	public void refuse(String id) {
		MaterielBomEcn up=new MaterielBomEcn();
		up.setId(Integer.parseInt(id));
		up.setCheckStatus("3");
		up.setCheckTime(new Date());
		materielBomEcnMapper.updateByPrimaryKeySelective(up);
	}

	
}
