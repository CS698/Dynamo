package net.dynamo.VO;

public class Responder {
private String resName;
private String resId;

private String organization;
private String lattitude;
private String longitude;
private String imageName;
private String phoneNumber;

private int counter;


public int getCounter() {
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}
public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getLattitude() {
	return lattitude;
}
public void setLattitude(String lattitude) {
	this.lattitude = lattitude;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public String getResId() {
	return resId;
}
public void setResId(String resId) {
	this.resId = resId;
}
public String getResName() {
	return resName;
}
public void setResName(String resName) {
	this.resName = resName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
}
