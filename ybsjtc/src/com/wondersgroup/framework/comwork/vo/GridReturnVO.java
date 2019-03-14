package com.wondersgroup.framework.comwork.vo;

import java.util.List;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.vo]
 * @ClassName:    [GridReturn]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [wangr]   	   
 * @CreateDate:   [2018年2月6日 上午10:33:07]  
 * @UpdateUser:   [wangr]   	   
 * @UpdateDate:   [2018年2月6日 上午10:33:07]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class GridReturnVO {
	/**
	 * 总共条数
	 */
	private int total;
	/**
	 * 所有数据
	 */
	private List<?> data;
	
	
	/**@Title:  	GridReturn   
	 * @Description:TODO[GridReturn 构造器]     
	 */
	public GridReturnVO() {
		super();
	}
	/**@Title:  	GridReturn   
	 * @Description:TODO[GridReturn 构造器]   
	 * @param total
	 * @param data  
	 */
	public GridReturnVO(int total, List<?> data) {
		super();
		this.total = total;
		this.data = data;
	}
	/**@Title:  	getTotal
	 * @Description:[please write your description]
	 * @return: 	int
	 */
	public int getTotal() {
		return total;
	}
	/**@Title:  	setTotal
	 * @Description:[please write your description]
	 * @return: 	int
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**@Title:  	getData
	 * @Description:[please write your description]
	 * @return: 	List<?>
	 */
	public List<?> getData() {
		return data;
	}
	/**@Title:  	setData
	 * @Description:[please write your description]
	 * @return: 	List<?>
	 */
	public void setData(List<?> data) {
		this.data = data;
	}
	
}
