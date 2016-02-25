package net.dynamo.jdbc.datasource;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;;

public class DBCPDataSourceFactory {

	public static DataSource getDataSource(String dbType) {
		// Properties props = new Properties();
		// FileInputStream fis = null;
		BasicDataSource ds = new BasicDataSource();
		Properties props = new Properties();

		try {

			System.out.println("dekho");

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

			props.load(classLoader.getResourceAsStream("/DataSource.properties"));
			if ("mysql".equals(dbType)) {
				System.out.println("making connection");
				ds.setDriverClassName(props.getProperty("jdbc.drivers"));
				ds.setUrl(props.getProperty("jdbc.url"));
				ds.setUsername(props.getProperty("jdbc.username"));
				ds.setPassword(props.getProperty("jdbc.password"));

			} else if ("oracle".equals(dbType)) {
				ds.setDriverClassName(props.getProperty("ORACLE_DB_DRIVER_CLASS"));
				ds.setUrl(props.getProperty("ORACLE_DB_URL"));
				ds.setUsername(props.getProperty("ORACLE_DB_USERNAME"));
				ds.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
			} else {
				return null;
			}

			return ds;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}