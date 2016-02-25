
/**
* The DBobjectDAOImp program is implements DBobjectDAO interface and its method. 
* @author  Maurani Saha
* @version 1.0
* @since   02-15-2016 
*/
package net.dynamo.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.dynamo.VO.User;
import net.dynamo.jdbc.datasource.DBCPDataSourceFactory;
import net.dynamo.jdbc.datasource.MyDataSourceFactory;

public class DBobjectDAOImp implements DBobjectDAO {
	Connection con = null;
	CallableStatement cs = null;

	@Override
	// ************This method Will call the stored procedure to validate user
	// and return client_id ,login_id,client_type
	// here client_id is user_id
	public List validate(String username, String password) {
		List validationList = new ArrayList();

		try {
			System.out.println("mou");

			String i_login_id = username;
			String i_password = password;
			System.out.println("username:" + i_login_id);
			System.out.println("password:" + i_password);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			// DataSource ds=MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			cs = con.prepareCall("{call validation(?,?)}");
			cs.setString(1, i_login_id);
			cs.setString(2, i_password);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					validationList.add(rs.getString(1));

					validationList.add(rs.getString(2));
					validationList.add(rs.getString(3));
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
					cs.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
		}

		return validationList;
	}

	@Override
	public List addMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List ViewMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List updateProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List viewProfile(int memberId) {
		System.out.println("dao impl ");
		List viewProfileList = new ArrayList();
		List validationList = new ArrayList();

		try {
			System.out.println("mou");

			int i_member_id = memberId;
			System.out.println("i_member_id:" + i_member_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			con = ds.getConnection();
			cs = con.prepareCall("{call profile_details_user(?)}");
			cs.setInt(1, i_member_id);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					User user = new User();
					user.setName((String) rs.getString(1));
					user.setAddress((String) rs.getString(2));
					user.setPhone((String) rs.getString(3));
					//user.setStatus((String) rs.getString(4));
					user.setCountryCode((String) rs.getString(4));
					user.setEmail((String) rs.getString(5));
					//user.setEnrolled_date((String) rs.getString(7));
					user.setDob((String) rs.getString(6));
					user.setMember_id((String) rs.getString(7));

					viewProfileList.add(user);

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

		System.out.println("viewProfileList:" + viewProfileList);
		return viewProfileList;
	}

	@Override
	public int modifyProfile(String name, String address, String phone, String countryCode, String email, String member_id) {
		System.out.println("dao");
		System.out.println("name:" + name);

		String result = null;
		int updatedrorCount = 0;
		int s_member_id = 0;
		s_member_id = Integer.parseInt(member_id);
		try {
			System.out.println("mou");

			System.out.println("i_member_id:" + s_member_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			// DataSource ds=MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			cs = con.prepareCall("{call update_user_profile(?,?,?,?,?,?)}");

			cs.setString(1, name);
			cs.setString(2, address);
			cs.setString(3, phone);
			cs.setString(4, countryCode);
			cs.setString(5, email);
			cs.setInt(6, s_member_id);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					User user = new User();
					updatedrorCount = rs.getInt(1);

				}
			} else {
				System.out.println("Nothing returned");

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

		System.out.println("updatedrorCount:" + updatedrorCount);

		if (updatedrorCount > 0) {
			return s_member_id;
		} else
			return 0;

	}

	@Override
	// Add a new user
	public int add(String name, String address, String phone, String countryCode, String email,
			 String DOB, String role, String login_id,String password,String hint_question,String hint_answer,String member_id) {
		System.out.println("dao");
		System.out.println("name:" + name);

		String result = null;
		int updatedrorCount = 0;
		int s_member_id = 0;
		
		//If user register him/her self directly in that case member_id will be " " 
		
		if(member_id.equals("")){
			member_id="0";
		}
		s_member_id = Integer.parseInt(member_id);
		try {
			System.out.println("ADDDDDDDDDDDDDDDDDDd");

			System.out.println("i_member_id:" + s_member_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			// DataSource ds=MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			cs = con.prepareCall("{call add_user(?,?,?,?,?,?,?,?,?,?,?)}");

			System.out.println("login_id::::::::"+login_id);
			System.out.println("password::::::::"+password);
			System.out.println("hint_question::::::::"+hint_question);
			System.out.println("hint_answer::::::::"+hint_answer);
			cs.setString(1, name);
			cs.setString(2, address);
			cs.setString(3, phone);
			cs.setString(4, countryCode);
			cs.setString(5, email);
			cs.setString(6, DOB);
			cs.setString(7, role);
			cs.setString(8, login_id);
			cs.setString(9, password);
			cs.setString(10, hint_question);
			cs.setString(11, hint_answer);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					// User user = new User();
					updatedrorCount = rs.getInt(1);

				}
			} else {
				System.out.println("Nothing returned");

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

		System.out.println("updatedrorCount:" + updatedrorCount);

		if (updatedrorCount > 0) {
			return s_member_id;
		} else
			return 0;
	}

	@Override
	public List listMembers(String member_id) {
		System.out.println("List Dao method");
		String admin_id = member_id;

		List viewListmembersLst = new ArrayList();

		try {
			System.out.println("List Dao method");

			// int i_member_id = memberId;
			System.out.println("admin_id:" + admin_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			// DataSource ds=MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			cs = con.prepareCall("{call list_user()}");
			// cs.setInt(1, i_member_id);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					User user = new User();
					user.setMember_id((String) rs.getString(1));
					user.setName((String) rs.getString(2));
					user.setAdmin_id(admin_id);

					viewListmembersLst.add(user);

				}
			} else {
				System.out.println("Nothing returned");
				viewListmembersLst.add("Invalid Credential");
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

		System.out.println("viewListmembersLst:" + viewListmembersLst);
		return viewListmembersLst;

	}

	@Override
	public int deleteMember(String member_id) {
		System.out.println("dao");

		String result = null;
		int updatedrorCount = 0;
		int s_member_id = 0;
		s_member_id = Integer.parseInt(member_id);
		try {
			System.out.println("mou");

			System.out.println("i_member_id:" + s_member_id);
			DataSource ds = DBCPDataSourceFactory.getDataSource("mysql");

			// DataSource ds=MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			cs = con.prepareCall("{call delete_user(?)}");

			cs.setInt(1, s_member_id);

			boolean haveResult = cs.execute();
			if (haveResult) {
				ResultSet rs = cs.getResultSet();
				while (rs.next()) {
					User user = new User();
					updatedrorCount = rs.getInt(1);

				}
			} else {
				System.out.println("Nothing returned");

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

		System.out.println("updatedrorCount:" + updatedrorCount);

		if (updatedrorCount > 0) {
			return s_member_id;
		} else
			return s_member_id;

	}

}
