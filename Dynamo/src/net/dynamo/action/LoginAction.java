/**
* The LoginAction program is implements to 
handle all the User action like
* Login,Modify,Add,delete
* @author  Maurani Saha
* @version 1.0
* @since   02-15-2016 
*/
package net.dynamo.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.dynamo.Dao.DBobjectDAO;
import net.dynamo.Dao.DBobjectDAOImp;
import net.dynamo.VO.Responder;
import net.dynamo.VO.User;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private String username;
	private String password;
	private DBobjectDAO DBobjectDAO;
	private String member_id;

	private String name;
	private String address;
	private int tagId;

	private String phone;
	private String zip;
	private String email;
	private String DOB;
	private String role;
	private String status;
	private String countryCode;
	private String zipcode;
	//private static final long serialVersionUID = -6765991741441442190L;
	public List responderDetailsList = new ArrayList();

	// private String hintQuestion;
	// private String hintAnswer;
	private String lpassword;
	private String login;

	//
	/* Dynamo Image upload */
	private File userImage;
	private String destPath;
	private String contextPath;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	private String skill;
	private String info;

	private String userImageContentType;
	private String userImageFileName;

	File fileUpload;

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	String fileUploadContentType;
	String fileUploadFileName;

	private HttpServletRequest servletRequest;
	//////////////////////////////////////
	HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
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
	 * This is the main method is Validating the user and direct to welcome page
	 * 
	 * @param args
	 *            Unused.
	 * @author Maurani Saha
	 * @return Nothing.
	 * @exception Exception.
	 *
	 */

	public String execute() throws Exception {
		System.out.println("this.username"+this.username);
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

		session = servletRequest.getSession();
		session.setAttribute("memberIdSession", memberId + "");
		String memberIdSession = (String) session.getAttribute("memberIdSession");
		System.out.println("memberIdSession:" + memberIdSession);
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

	/*
	 * ***To navigate to the form to Add Responder
	 ********************************************/
	public String addForm() throws Exception {

		System.out.println("ADDDDD:member_id:::::::::::::::::::::::" + member_id);

		return "add";

	}

	/*
	 * ***To navigate to the form to Add Responder
	 ********************************************/
	public String addFormUser() throws Exception {

		System.out.println("ADDDDD:member_id:::::::::::::::::::::::" + member_id);

		return "addUser";

	}

	public String add() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		name = this.name;
		address = this.address;
		destPath = this.destPath;
		phone = this.phone;
		zipcode = this.zipcode;
		email = this.email;
		skill = this.skill;
		info = this.info;
		System.out.println("lpassword->>>>>>>>>>>INSIDE ADD LOGIN ACTION>>");

		System.out.println("name::::::::" + name);
		System.out.println("address::::::::" + address);
		System.out.println("skill::::::::" + skill);
		System.out.println("info::::::::" + info);
		session = servletRequest.getSession();

		/*
		 * String contextPath = servletRequest.getContextPath();
		 * 
		 * System.out.println("path::"+contextPath); destPath =
		 * contextPath+"/images/"; System.out.println("Src File name: " +
		 * userImage); System.out.println("Dst File name: " +
		 * userImageFileName); System.out.println(" destPath: " + destPath);
		 * 
		 * File destFile = new File(destPath, userImageFileName);
		 * FileUtils.copyFile(userImage, destFile);
		 */

		contextPath = servletRequest.getContextPath() + "/images";
		System.out.println("contextPath::::::::" + contextPath);

		// destPath=contextPath+"/images/";
		// working
		destPath = servletRequest.getServletContext().getRealPath("/images");

		// working
		System.out.println("Server path:" + destPath);
		File fileToCreate = new File(destPath, this.userImageFileName);

		FileUtils.copyFile(this.userImage, fileToCreate);

		String imageName = this.userImageFileName;
		System.out.println("imageName:::::::::::" + imageName);

		System.out.println("member_id::" + member_id);
		int memberID = DBobjectDAO.add(name, address, imageName, skill, info, zipcode, phone, tagId, member_id);
		profileViewLst = viewProfile(memberID);
		System.out.println("memberID::loginaction---" + memberID);
		if (memberID == 0) {
			return "registered";
		} else
			return "view";

	}

	public String addUser() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		name = this.name;
		address = this.address;
		destPath = this.destPath;
		phone = this.phone;
		zipcode = this.zipcode;
		email = this.email;
		skill = this.skill;
		info = this.info;
		System.out.println("lpassword->>>>>>>>>>>INSIDE ADD LOGIN ACTION>>");

		System.out.println("name::::::::" + name);
		System.out.println("address::::::::" + address);
		System.out.println("destPath::::::::" + destPath);
		System.out.println("skill::::::::" + skill);
		System.out.println("info::::::::" + info);
		session = servletRequest.getSession();
		String a = (String) session.getAttribute("memberIdSession");
		System.out.println("aaaaaaaaaaaaaa:" + a);

		/*
		 * String contextPath = servletRequest.getContextPath();
		 * 
		 * System.out.println("path::"+contextPath); destPath =
		 * contextPath+"/images/"; System.out.println("Src File name: " +
		 * userImage); System.out.println("Dst File name: " +
		 * userImageFileName); System.out.println(" destPath: " + destPath);
		 * 
		 * File destFile = new File(destPath, userImageFileName);
		 * FileUtils.copyFile(userImage, destFile);
		 */

		contextPath = servletRequest.getContextPath() + "/images";
		System.out.println("contextPath::::::::" + contextPath);

		// destPath=contextPath+"/images/";
		// working
		destPath = servletRequest.getServletContext().getRealPath("/images");

		// working
		System.out.println("Server path:" + destPath);
		File fileToCreate = new File(destPath, this.userImageFileName);

		FileUtils.copyFile(this.userImage, fileToCreate);

		System.out.println("member_id::" + member_id);
		int memberID = DBobjectDAO.addUser(name, address, destPath, skill, info, zipcode, phone, member_id);
		profileViewLst = viewProfile(memberID);
		System.out.println("memberID::loginaction---" + memberID);
		if (memberID == 0) {
			return "registered";
		} else
			return "view";

	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String listMembers() throws Exception {

		System.out.println("member_id::::::::________>>>::" + member_id);
		List modifyList = new ArrayList();
		DBobjectDAO = new DBobjectDAOImp();

		memberList = DBobjectDAO.listMembers(member_id);
		System.out.println("memberID::loginaction---" + memberList);
		return "list";

	}

	/***************** To Fetch UAV VDO ************************/
	public String addUAV() throws Exception {
		return "addUAV";
	}

	/*****************
	 * To Fetch Location of First Responder to MAP
	 ************************/
	public String fetchToMap() throws Exception {
		Responder responder = new Responder();
		responder.setResName("maurani");
		responder.setImageName("icon.png");
		responder.setOrganization("Fire");
		responder.setLattitude("-33.923036");
		responder.setLongitude("151.259052");
		responderDetailsList.add(responder);
		// outerList.add(responderDetailsList);

		Responder responder1 = new Responder();
		responder1.setResName("Ramya");
		responder1.setImageName("icon.png");
		responder1.setOrganization("Police");
		responder1.setLattitude("-34.028249");
		responder1.setLongitude("151.157507");
		responderDetailsList.add(responder1);
		// outerList.add(responderDetailsList);
		System.out.println("responder::" + responderDetailsList);
		// Gson m = new Gson();
		// String jsonData = new Gson().toJson(responderDetailsList);
		// System.out.println("jsonData::"+jsonData);
		System.out.println("responder::" + responderDetailsList);

		return "fetchToMap";
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

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

}