package com.wondersgroup.permission.menu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.menu.dao.PerMenuMapper;
import com.wondersgroup.permission.menu.vo.PerMenu;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.permission.menu.service]
 * @ClassName:    [UaasMenuService]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [chenyibing]   	   
 * @CreateDate:   [2018-5-7 下午5:30:57]  
 * @UpdateUser:   [chenyibing]   	   
 * @UpdateDate:   [2018-5-7 下午5:30:57]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class PerMenuService extends BaseService<BaseObject>{
	@Resource(name="perMenuMapper")
	private PerMenuMapper perMenuMapper;

	@Resource(name="perMenuMapper")
	public void setDao(BaseDAO<BaseObject> dao) {
		super.setDao(dao);
	}
	
	public List<PerMenu> listUserMenu(Map<String, Object> map){
		return perMenuMapper.listUserMenu(map);
	}

	
	public List<PerMenu> listMenu(){
		return perMenuMapper.listMenu();
	}
	
	public  PerMenu getMenu(int id){
		return perMenuMapper.getMenu(id);
	}
	
	public int updateUaasMenu(PerMenu record){
		return perMenuMapper.updateUaasMenu(record);
	}
	
	public int saveUaasMenu(PerMenu record){
		return perMenuMapper.saveUaasMenu(record);
	}

	public void removeUaasMenu(Map<String, Object> map){
		perMenuMapper.removeUaasMenu(map);
	}
	
	
	/*public List<PerMenu> listMenuPermission(Map<String, Object> map){
		return perMenuMapper.listMenuPermission(map);
	}
	
	public List<UaasMenu> listRoleMenu(Map<String, Object> map){
		return uaasMenuMapper.listRoleMenu(map);
	}
	
	
	public UaasMenu getMenu(int id){
		return uaasMenuMapper.getMenu(id);
	}
	
	
	
	*/
}
