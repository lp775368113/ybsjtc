package com.wondersgroup.framework.dbutil.centre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.wondersgroup.materiel.encoding.vo.MaterielCheck;
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.dbutil.centre]
 * @ClassName:    [d]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年5月22日 下午2:44:15]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年5月22日 下午2:44:15]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class CentreDao{
	
	public void insertMateriel(MaterielCheck agree) throws SQLException {
		Connection conn = centreJdbcUtil.getConnection();
		String status=null;
		if(agree.getErpid()==null) {
			 status="1";//新增
		}else {
			 status="2";//修改
		}
		String sql =  " insert into materiel_info (id, rkey, ERP_STATUS, inv_part_number, "+
			      " extra_desc, prod_code_sell_ptr, prod_supper, "+
			      " package, smt_flag, inv_part_description_c, "+
			      " cust_part_name, cust_part_code, purch_unit_ptr, "+
			      " stock_unit_ptr, supplier_ptr, std_cost, "+
			      " stock_purch) "+
			    "values ("+agree.getId()+", "+agree.getErpid()+", "+status+",'"+agree.getInvPartNumber()+"', '"
			    		+agree.getExtraDesc()+"', "+agree.getProdCodeSellPtr()+", '"+agree.getProdSupper()+"', '"
			    		+agree.getPackage_()+"', "+agree.getSmtFlag()+", '"+agree.getInvPartDescriptionC()+"', '"
			    		+agree.getCustPartName()+"', '"+agree.getCustPartCode()+"', "+agree.getPurchUnitPtr()+", "
			    		+agree.getStockUnitPtr()+", "+agree.getSupplierPtr()+", "+agree.getStdCost()+", "
			    		+agree.getStockPurch()+")";
		System.out.println("-----------sql:"+sql);
		PreparedStatement s = conn.prepareStatement(sql);
		s.execute(sql);
	}
	

}
