/**
* The LoginAction program is implements to 
handle all the User action like
* Login,Modify,Add,delete
* @author  Maurani Saha
* @version 1.0
* @since   02-15-2016 
*/
package net.dynamo.action;

import java.util.ArrayList;
import java.util.List;

import net.dynamo.Dao.DBobjectDAO;
import net.dynamo.Dao.DBobjectDAOImp;
import net.dynamo.VO.User;

public class LoginAction {
	private String username;
	private String password;
	private DBobjectDAO DBobjectDAO;
	private String member_id;

	private String name;
	private String address;
	private String phone;
	private String zip;
	private String email;
	private String DOB;
	private String role;
	private String status;
	private String countryCode;
	private String hintQuestion;
	private String hintAnswer;
	private String lpassword;
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHintQuestion() {
		return hintQuestion;
	}

	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}

	public String getHintAnswer() {
		return hintAnswer;
	}

	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	List validationLst = new ArrayList();
	List profileViewLst = new ArrayList();
	List memberList = new ArrayList();

	List ViewprofileLst = new ArrayList();

	public List getViewprofileLst() {
		return ViewprofileLst;
	}

	public void setViewprofileLst(List viewprofileLst) {
		ViewprofileLst = viewprofileLst;
	}

	public List getMemberList() {
		return memberList;
	}

	public void setMemberList(List memberList) {
		this.memberList = memberList;
	}

	public List getProfileViewLst() {
		return profileViewLst;
	}

	public void setProfileViewLst(List profileViewLst) {
		this.profileViewLst = profileViewLst;
	}

	
	 /**
	   * This is the main method is Validating the user and 
	   * direct to welcome page
	   * @param args Unused.
	   * @author Maurani Saha
	   * @return Nothing.
	   * @exception Exception.
	   *
	   */
	
	public String execute() throws Exception {
		String password = this.password;
		String username = this.username;

		DBobjectDAO = new DBobjectDAOImp();

		validationLst = DBobjectDAO.validate(username, password);
		System.out.println("validationLst" + validationLst);
		if (validationLst.get(0).equals("Invalid Credential")) {
			validationLst.clear();
			return "input";

		}

		if (validationLst.get(2).equals("admin")) {
			System.out.println("I am admin");

			int memberId = Integer.parseInt((String) validationLst.get(0));

			profileViewLst = viewProfile(memberId);
			return "success";
		} else {
			System.out.println("I am normal user");

			int memberId = Integer.parseInt((String) validationLst.get(0));
			/*
			 * System.out.println("memberId:"+memberId);
			 * profileViewLst=DBobjectDAO.viewProfile(memberId);
			 * System.out.println("profileViewLst:"+profileViewLst);
			 */
			profileViewLst = viewProfile(memberId);

			return "view";

		}

	}

	public List viewProfile(int memberId) {
		List ViewprofileViewLst = new ArrayList();
		System.out.println("ViewprofileViewLst:--------------" + ViewprofileViewLst);
		ViewprofileViewLst = DBobjectDAO.viewProfile(memberId);

		System.out.println("ViewprofileViewLst:" + ViewprofileViewLst);
		return ViewprofileViewLst;
	}

	public String deleteMember() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		// int memberID=Integer.parseInt(member_id);

		int memberiD = DBobjectDAO.deleteMember(member_id);
		// for the time being showing admin page..need to do with session
		profileViewLst = viewProfile(1);
		System.out.println("profileViewLst---" + profileViewLst);
		listMembers();
		return "view";

	}

	public String viewBymemberId() {

		int memberId = Integer.parseInt(member_id);
		DBobjectDAO = new DBobjectDAOImp();

		System.out.println("Iview profile for member id:" + member_id);
		System.out.println("ViewprofileLst:" + ViewprofileLst);
		profileViewLst = DBobjectDAO.viewProfile(memberId);

		// DBobjectDAO.viewProfile(memberId);
		System.out.println("profileViewLst:" + profileViewLst);
		return "view";
	}

	public String viewBymemberIdAdmin() {

		int memberId = Integer.parseInt(member_id);
		DBobjectDAO = new DBobjectDAOImp();

		System.out.println("Iview profile for member id:" + member_id);
		System.out.println("ViewprofileLst:" + ViewprofileLst);
		profileViewLst = DBobjectDAO.viewProfile(memberId);

		// DBobjectDAO.viewProfile(memberId);
		System.out.println("profileViewLst:" + profileViewLst);
		return "view";
	}

	public String homeAdmin(String admin_id) {

		System.out.println("admin_id::::::::::::::::::::::::" + admin_id);
		int adminid = Integer.parseInt(admin_id);
		viewProfile(adminid);
		return "view";
	}

	public String modify() throws Exception {

		System.out.println("member_id::::::::::::::::::::::::" + member_id);

		return "modify";

	}

	public String modifyRecord() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		name = this.name;
		address = this.address;
		phone = this.phone;

		countryCode = this.countryCode;
		email = this.email;

		int memberID = DBobjectDAO.modifyProfile(name, address, phone, countryCode, email, member_id);
		profileViewLst = viewProfile(memberID);
		System.out.println("profileViewLst---" + profileViewLst);
		return "view";

	}

	public String addForm() throws Exception {

		System.out.println("ADDDDD::::::::::::::::::::::::" + member_id);

		return "add";

	}

	public String add() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		name = this.name;
		address = this.address;
		phone = this.phone;
		zip = this.zip;
		email = this.email;
		System.out.println("lpassword->>>>>>>>>>>>>" + lpassword);
		int memberID = DBobjectDAO.add(name, address, phone, countryCode, email, DOB, role, login, lpassword,
				hintQuestion, hintAnswer, member_id);
		profileViewLst = viewProfile(memberID);
		System.out.println("memberID::loginaction---" + memberID);
		if (memberID == 0) {
			return "registered";
		} else
			return "view";

	}

	public String listMembers() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		memberList = DBobjectDAO.listMembers(member_id);
		System.out.println("memberID::loginaction---" + memberList);
		return "list";

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String enrolled_date;

	public String getEnrolled_date() {
		return enrolled_date;
	}

	public void setEnrolled_date(String enrolled_date) {
		this.enrolled_date = enrolled_date;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}