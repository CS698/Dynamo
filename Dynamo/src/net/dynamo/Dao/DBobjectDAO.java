
/**
* The DBobjectDAO program is a interface and defined its method. 
* @author  Maurani Saha
* @version 1.0
* @since   02-15-2016 
*/
package net.dynamo.Dao;

import java.text.ParseException;
import java.util.List;

public interface DBobjectDAO {

	public abstract List validate(String username,String password);
	public abstract List addMember();
	public abstract List ViewMember();
	public abstract List updateProfile();
	public abstract List viewProfile(int memberId);
	public abstract int modifyProfile(String name, String address, String phone, String zip, String email,
			String member_id);
	//public abstract int add(String name, String address, String phone, String zip, String email, String enrolled_date,
		//	String dOB, String role, String member_id, String member_id2) throws ParseException;
	public abstract List listMembers(String member_id);
	public abstract int deleteMember(String member_id);
	public abstract int add(String name, String address, String phone, String countryCode, String email, String DOB, String role,
			 String login_id, String password, String hint_question, String hint_answer,String member_id);
}
