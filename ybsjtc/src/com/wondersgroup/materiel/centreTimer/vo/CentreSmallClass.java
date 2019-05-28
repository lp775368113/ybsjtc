package com.wondersgroup.materiel.centreTimer.vo;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.materiel.centreTimer.vo]
 * @ClassName:    [CentreSmallClass]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年5月23日 下午3:26:59]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年5月23日 下午3:26:59]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class CentreSmallClass {
	private int rkey;
	private String prod_code;
	private String prod_name;
	private int group_ptr;
	private String type_ptr;
	private String status;
	private String index_id;
	public int getRkey() {
		return rkey;
	}
	public void setRkey(int rkey) {
		this.rkey = rkey;
	}
	public String getProd_code() {
		return prod_code;
	}
	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	public int getGroup_ptr() {
		return group_ptr;
	}
	public void setGroup_ptr(int group_ptr) {
		this.group_ptr = group_ptr;
	}
	public String getType_ptr() {
		return type_ptr;
	}
	public void setType_ptr(String type_ptr) {
		this.type_ptr = type_ptr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIndex_id() {
		return index_id;
	}
	public void setIndex_id(String index_id) {
		this.index_id = index_id;
	}
}
