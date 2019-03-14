package com.wondersgroup.framework.comwork.vo;

import java.io.Serializable;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.vo]
 * @ClassName:    [BaseObject]   
 * @Description:  [公用基础实现类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午4:59:57]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午4:59:57]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class BaseObject implements Serializable  {
	 
	private static final long serialVersionUID = -3426298078982965245L;
	/**@Fields WRITE_LOG_YES: TODO[日志开关常量:开启]   */
	public static String WRITE_LOG_YES = "1" ;    
	
	/**@Fields WRITE_LOG_NO: TODO[日志开关常量:关闭]   */
	public static String WRITE_LOG_NO = "0";            
	
	/**@Fields pageIndex: TODO[当前页码数]   */
	private String pageIndex;
	
	/**@Fields pageSize: TODO[单页显示数]   */
	private String pageSize;
	
	/**@Fields sortField: TODO[属性排序]   */
	private String sortField;
	
	/**@Fields sortOrder: TODO[数据排序]   */
	private String sortOrder;
	
	/**@Fields login_userid: TODO[用户登录ID]   */
	private String login_userid;
	
	/**@Fields login_realname: TODO[用户姓名]   */
	private String login_realname;
	
	/**@Fields logywlsh: TODO[业务日志流水号]   */
	private String logywlsh;
	
	/**@Fields iswritelog: TODO[日志开关标志]   */
	private String iswritelog=WRITE_LOG_NO;
	
	/**@Fields busilog_id: TODO[业务日志ID]   */
	private String busilog_id;
	
	/**@Fields _id: TODO[用一句话描述这个变量表示什么]   */
	private int _id;
	
	/**@Fields memo: TODO[用一句话描述这个变量表示什么]   */
	private String memo;

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getLogin_userid() {
		return login_userid;
	}

	public void setLogin_userid(String login_userid) {
		this.login_userid = login_userid;
	}

	public String getLogin_realname() {
		return login_realname;
	}

	public void setLogin_realname(String login_realname) {
		this.login_realname = login_realname;
	}

	public String getLogywlsh() {
		return logywlsh;
	}

	public void setLogywlsh(String logywlsh) {
		this.logywlsh = logywlsh;
	}

	public String getIswritelog() {
		return iswritelog;
	}

	public void setIswritelog(String iswritelog) {
		this.iswritelog = iswritelog;
	}

	public String getBusilog_id() {
		return busilog_id;
	}

	public void setBusilog_id(String busilog_id) {
		this.busilog_id = busilog_id;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
