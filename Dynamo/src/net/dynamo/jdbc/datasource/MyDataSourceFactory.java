/**
* The MyDataSourceFactory program is used to testing the DBCPDataSourceFactory
*
* @author  Maurani Saha
* @version 1.0
* @since   02-15-2016 
*/
package net.dynamo.jdbc.datasource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;
 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
 
public class MyDataSourceFactory {
 
    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("DataSource.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("jdbc.url"));
            mysqlDS.setUser(props.getProperty("jdbc.username"));
            mysqlDS.setPassword(props.getProperty("jdbc.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }
    }
