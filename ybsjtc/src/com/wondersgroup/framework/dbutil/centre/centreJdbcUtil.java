package com.wondersgroup.framework.dbutil.centre;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class centreJdbcUtil {
	private static DataSource dataSource;
	static{
	try {
	InputStream is = centreJdbcUtil.class.getClassLoader().getResourceAsStream("centre.properties");
	Properties pro = new Properties();
	pro.load(is);
	dataSource = BasicDataSourceFactory.createDataSource(pro);
	}  catch (Exception e) {
	e.printStackTrace();
	}
	}
	public static DataSource getDataSource() {
	return dataSource;
	}

	public static Connection getConnection() throws SQLException {
	return dataSource.getConnection();
	}

}
