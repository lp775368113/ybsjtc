package test;

/**
 * ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [test]
 * @ClassName:    [Test]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月8日 下午10:46:17]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月8日 下午10:46:17]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** *
 */
public class Test {

	
	/**@Title:  	Test   
	 * @Description:TODO[Test 构造器]   
	 * @param:  	@param ssss  
	 */
	public Test(String ssss) {
		super();
		this.ssss = ssss;
	}

	
	/**@Title:  	Test   
	 * @Description:TODO[Test 构造器]   
	 * @param:  	  
	 */
	public Test() {
		super();
	}


	/**@Fields ssss: TODO[用一句话描述这个变量表示什么]   */
	private String ssss;

	/**@Title:  	getSsss
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getSsss() {
		return ssss;
	}

	/**@Title:  	setSsss
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setSsss(String ssss) {
		this.ssss = ssss;
	}
	

	/**@Title: 		 Testss   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param v1
	 * @param v2
	 * @return      
	 * @return_type: int      
	 */
	public int Testss(int v1,String v2) {
		int v3 = 0;
		v3 =  v1+Integer.valueOf(v2);
		return v3;
	}
}
