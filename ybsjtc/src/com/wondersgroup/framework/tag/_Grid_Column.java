package com.wondersgroup.framework.tag;

import java.io.Serializable;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [_Grid_Column]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月7日 下午11:03:05]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月7日 下午11:03:05]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class _Grid_Column implements Serializable{

	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private String fmt;
	private String lock;
	public String getName() {
		return name;
	}
	public _Grid_Column setName(String name) {
		this.name = name;
		return this;
	}
	public String getValue() {
		return value;
	}
	public _Grid_Column setValue(String value) {
		this.value = value;
		return this;
	}
	public String getFmt() {
		return fmt;
	}
	public _Grid_Column setFmt(String fmt) {
		this.fmt = fmt;
		return this;
	}
	public String getLock() {
		return lock;
	}
	public _Grid_Column setLock(String lock) {
		this.lock = lock;
		return this;
	}
}
