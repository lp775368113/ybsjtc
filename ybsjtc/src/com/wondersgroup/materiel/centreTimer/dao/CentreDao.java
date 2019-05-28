package com.wondersgroup.materiel.centreTimer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wondersgroup.framework.dbutil.centre.centreJdbcUtil;
import com.wondersgroup.materiel.centreTimer.vo.CentreBigClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSmallClass;
import com.wondersgroup.materiel.centreTimer.vo.CentreSupplier;
import com.wondersgroup.materiel.encoding.vo.Data0017;
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
public class CentreDao{
	
	public List<Data0017> getMaterielInfo() throws SQLException {
		List<Data0017> result=new ArrayList<Data0017>();
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "select * from MATERIEL_INFO a where a.ERP_STATUS=0";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()) {
			Data0017 po=new Data0017();
			po.setId(rs.getInt("ID"));
			po.setErpid(rs.getInt("RKEY"));
			po.setInvPartNumber(rs.getString("INV_PART_NUMBER"));
			po.setExtraDesc(rs.getString("EXTRA_DESC"));
			result.add(po);
		}
		return result;
	}
	
	public void okData0017(int	id) throws SQLException {
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "update  MATERIEL_INFO set ERP_STATUS=4 where id="+id;
		PreparedStatement s = conn.prepareStatement(sql);
		s.executeUpdate();
	}

	public List<CentreBigClass> getBigClass() throws SQLException {
		List<CentreBigClass> result=new ArrayList<CentreBigClass>();
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "select * from MATERIEL_BIGCLASS a where a.ERP_STATUS=1";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()) {
			CentreBigClass po=new CentreBigClass();
			po.setRkey(rs.getInt("RKEY"));
			po.setGroup_name(rs.getString("GROUP_NAME"));
			result.add(po);
		}
		return result;
	}
	
	public void okBigClass(int rkey) throws SQLException {
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "update  MATERIEL_BIGCLASS set ERP_STATUS=0 where rkey="+rkey;
		PreparedStatement s = conn.prepareStatement(sql);
		s.executeUpdate();
	}

	public List<CentreSmallClass> getSmallClass() throws SQLException {
		List<CentreSmallClass> result=new ArrayList<CentreSmallClass>();
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "select * from MATERIEL_SMALLCLASS a where a.ERP_STATUS=1";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()) {
			CentreSmallClass po=new CentreSmallClass();
			po.setRkey(rs.getInt("RKEY"));
			po.setProd_name(rs.getString("PROD_NAME"));
			po.setGroup_ptr(rs.getInt("GROUP_PTR"));
			result.add(po);
		}
		return result;
	}
	
	public void okSmallClass(int rkey) throws SQLException {
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "update  MATERIEL_SMALLCLASS set ERP_STATUS=0 where rkey="+rkey;
		PreparedStatement s = conn.prepareStatement(sql);
		s.executeUpdate();
	}

	/**@Title: 		 getSupplier   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @throws SQLException 
	 * @return_type: List<CentreSupplier>      
	 */
	public List<CentreSupplier> getSupplier() throws SQLException {
		List<CentreSupplier> result=new ArrayList<CentreSupplier>();
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "select * from MATERIEL_SUPPLIER a where a.ERP_STATUS=1";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()) {
			CentreSupplier po=new CentreSupplier();
			po.setRkey(rs.getInt("RKEY"));
			po.setSupplier_name(rs.getString("SUPPLIER_NAME"));
			result.add(po);
		}
		return result;
	}

	/**@Title: 		 okSupplier   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param rkey      
	 * @throws SQLException 
	 * @return_type: void      
	 */
	public void okSupplier(int rkey) throws SQLException {
		Connection conn = centreJdbcUtil.getConnection();
		String sql =  "update  MATERIEL_SUPPLIER set ERP_STATUS=0 where rkey="+rkey;
		PreparedStatement s = conn.prepareStatement(sql);
		s.executeUpdate();
	}

	
	

}
