package com.wondersgroup.permission.button.dao;

import com.wondersgroup.permission.button.vo.Button;
import com.wondersgroup.permission.button.vo.UserButtonPermission;
import com.wondersgroup.permission.user.vo.User;
import com.wondersgroup.permission.userMenu.vo.UserMenu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Button record);

    int insertSelective(Button record);

    Button selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Button record);

    int updateByPrimaryKey(Button record);

	List<Button> buttonPer(User user);

	List<Button> getPage(Map<String, Object> params);

	Integer getPageCount(Map<String, Object> params);

	List<Button> getUserButtonPage(Map<String, Object> params);

	Integer getUserButtonPageCount(Map<String, Object> params);

	UserButtonPermission getUserButton(Map<String, Object> params);

	void updateUserButton(UserButtonPermission userButton);
	
	void insertUserButton(List<UserButtonPermission> permissionAddList);

}