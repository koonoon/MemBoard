package com.icia.memboard.dto;

import org.springframework.web.multipart.MultipartFile;

public class MDTO {

	private String fId;		
	private String fPw;		
	private String fName;	
	private String fBirth;	
	private String fGender;	
	private String fPhone;
	private String fAddr;
	private String fEmail;
	
	private MultipartFile fProfile;
	private String fProfileName;
	
	
	public MultipartFile getfProfile() {
		return fProfile;
	}
	public void setfProfile(MultipartFile fProfile) {
		this.fProfile = fProfile;
	}
	public String getfProfileName() {
		return fProfileName;
	}
	public void setfProfileName(String fProfileName) {
		this.fProfileName = fProfileName;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfPw() {
		return fPw;
	}
	public void setfPw(String fPw) {
		this.fPw = fPw;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfBirth() {
		return fBirth;
	}
	public void setfBirth(String fBirth) {
		this.fBirth = fBirth;
	}
	public String getfGender() {
		return fGender;
	}
	public void setfGender(String fGender) {
		this.fGender = fGender;
	}
	public String getfPhone() {
		return fPhone;
	}
	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	public String getfAddr() {
		return fAddr;
	}
	public void setfAddr(String fAddr) {
		this.fAddr = fAddr;
	}
	public String getfEmail() {
		return fEmail;
	}
	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}
	
	@Override
	public String toString() {
		return "MDTO [fId=" + fId + ", fPw=" + fPw + ", fName=" + fName + ", fBirth=" + fBirth + ", fGender=" + fGender
				+ ", fPhone=" + fPhone + ", fAddr=" + fAddr + ", fEmail=" + fEmail + ", fProfile=" + fProfile
				+ ", fProfileName=" + fProfileName + "]";
	}
	
	
	
	
}
