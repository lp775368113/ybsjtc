package com.wondersgroup.framework.upms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import com.wondersgroup.permission.menu.vo.PerMenu;

public class MenuUtil {	
	public static HashMap<String, TreeMap<Integer,List<PerMenu>> >  CreateMenuTree(List<PerMenu> list ){
		//此注释很重要，切勿删除 ：权限树格式定义  <    leave    ,    <    pid    ,    TreeMap(UasMenuVO)    >      > 
		HashMap<String, TreeMap<Integer,List<PerMenu>> > tree1  = new HashMap<String, TreeMap<Integer,List<PerMenu>>>();
		for (PerMenu uasMenuVO : list) {
			int parentid  =  uasMenuVO.getParentid();
			String menuLevel = uasMenuVO.getType();
			TreeMap<Integer,List<PerMenu>> tree2 = tree1.containsKey(menuLevel)? tree1.get(menuLevel): new TreeMap<Integer,List<PerMenu>>();
			List<PerMenu> Ptree2 =  tree2.containsKey(parentid)? tree2.get(parentid):new ArrayList<PerMenu>();
			uasMenuVO.setName(uasMenuVO.getName().trim());
			Ptree2.add(uasMenuVO);
			tree2.put(parentid,Ptree2);
			tree1.put(menuLevel, tree2);
		}
		return tree1;
	}
}
