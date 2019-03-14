package com.wondersgroup.framework.comwork.dao;
 
import java.util.List;
import java.util.Map;
import org.mybatis.spring.annotation.MapperScan;
 
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.dao]
 * @ClassName:    [BaseDAO]   
 * @Description:  [基础DAO类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午4:28:04]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午4:28:04]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@MapperScan
public interface BaseDAO<M>   {
	
	/**@Title: 		 getSequence   
	 * @Description: TODO[获取seq 接口]   
	 * @param map
	 * @return      
	 * @return_type: String      
	 */
	public String getSequence(Map<String, Object> map);
	
	/**@Title: 		 getPage   
	 * @Description: TODO[获取分页信息 接口]   
	 * @param map
	 * @return      
	 * @return_type: List<M>      
	 */
	public List<M> getPage(Map<String, Object>  map);
	
	/**@Title: 		 getPageCount   
	 * @Description: TODO[获取总页数接口]   
	 * @param map
	 * @return      
	 * @return_type: int      
	 */
	public int getPageCount(Map<String, Object>  map);
	
}