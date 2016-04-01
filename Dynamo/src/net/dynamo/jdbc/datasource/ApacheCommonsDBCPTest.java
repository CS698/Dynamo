package net.dynamo.jdbc.datasource;
import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.sql.DataSource;
 
public class ApacheCommonsDBCPTest {
	final static Logger logger = Logger.getLogger(ApacheCommonsDBCPTest.class);
 
    public static void main(String[] args) {
        testDBCPDataSource("mysql");
        System.out.println("**********");
      //  testDBCPDataSource("oracle");
    }
 
    private static void testDBCPDataSource(String dbType) {
      //  DataSource ds = DBCPDataSourceFactory.getDataSource(dbType);
        DataSource ds = MyDataSourceFactory.getMySQLDataSource();
         
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select member_id, name from member");
            while(rs.next()){
                System.out.println("Employee ID="+rs.getInt("member_id")+", Name="+rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.debug("catch block of testDBCPDataSource method in ApacheCommonsDBCPTest : " + e.getMessage());
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    logger.debug("finally block of testDBCPDataSource method in ApacheCommonsDBCPTest : " + e.getMessage());
                }
        }
    }
 
}