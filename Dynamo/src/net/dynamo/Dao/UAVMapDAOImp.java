package net.dynamo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import net.dynamo.VO.Responder;
import net.dynamo.VO.UAVData;
import net.dynamo.VO.User;
import net.dynamo.jdbc.datasource.DBCPDataSourceFactory;

public class UAVMapDAOImp implements  UAVMapDAO {
	Connection con = null;
	CallableStatement cs = null;

	@Override
	public Map uavToMap(int counter) {
		Map uavDetailsMap = new HashMap();
		List uavDetailList = new ArrayList();
		List validationList = new ArrayList();

		try {
			System.out.println("mou");

			// int i_member_id = memberId;
			// System.out.println("i_member_id:" + i_member_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			con = ds.getConnection();
			cs = con.prepareCall("{call get_location_of_UAV_drone	(?)}");
			cs.setInt(1, counter);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				// for (int i = 0; i < 2; i++) {
				int i = 0;
				while (rs.next()) {
					UAVData uav = new UAVData();


					String lat = ((Double) rs.getDouble(2)) + "";
					System.out.println("lat:" + lat);
					uav.setLattitude(lat);

					String longitude = ((Double) rs.getDouble(3)) + "";
					System.out.println("longitude:" + longitude);
					uav.setLongitude(longitude);

					
					
					
					int counterInt = (Integer) rs.getInt(5);
					System.out.println("counterInt:" + counterInt);
					uav.setCounter(counterInt);

					

					int keyInt = rs.getInt(4);
					String key = keyInt+"" ;
					System.out.println("key is:" + key);

					uavDetailList.add(uav);
					uavDetailsMap.put(key, uavDetailList);
					System.out.println("uavDetailsMap:::" + uavDetailsMap);
					//i++;
					// }
					
					/*if(i==counter){
						uavDetailList = new ArrayList();
					i=0;
					}*/
					
					///Use this one..need to change
					
					/* Map map = new HashMap()
							 for( Row row : resultset ) {
							      if(!map.containsKey(row.category)){
							            map.put(row.category, new ArrayList());
							      }
							      map.get(row.category).add(row.name);
							      
							      http://stackoverflow.com/questions/12650122/how-to-add-objects-of-class-to-hashmap-based-on-their-values
							  }*/
					///
					
					
				}
			} else {
				System.out.println("Nothing returned");
				validationList.add("Invalid Credential");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (cs != null) {
				try {
					System.out.println("closing callablestate");
					cs.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
			if (con != null) {
				try {
					System.out.println("closing connection");
					con.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
		}

		System.out.println("resDetailsMap:" + uavDetailsMap.size());
		System.out.println("resDetailsMap:" + uavDetailsMap);
		return uavDetailsMap;
	}

	

}
