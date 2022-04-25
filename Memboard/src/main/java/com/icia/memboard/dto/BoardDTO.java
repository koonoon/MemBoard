package com.icia.memboard.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;


public class BoardDTO {
	private int bNum;  			// 게시글 번호
	private String bWriter;		// 작성자
	private int bPassword;		// 비밀번호
	private String bTitle;		// 제목
	private String bContents;	// 내용
	private Date bDate;			// 작성일
	private	int bHit;			// 조회수
	
	private MultipartFile bFile;	// 업로드 파일
	private String bFileName;		// 업르드 파일이름
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public int getbPassword() {
		return bPassword;
	}
	public void setbPassword(int bPassword) {
		this.bPassword = bPassword;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContents() {
		return bContents;
	}
	public void setbContents(String bContents) {
		this.bContents = bContents;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public MultipartFile getbFile() {
		return bFile;
	}
	public void setbFile(MultipartFile bFile) {
		this.bFile = bFile;
	}
	public String getbFileName() {
		return bFileName;
	}
	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bNum=" + bNum + ", bWriter=" + bWriter + ", bPassword=" + bPassword + ", bTitle=" + bTitle
				+ ", bContents=" + bContents + ", bDate=" + bDate + ", bHit=" + bHit + ", bFile=" + bFile
				+ ", bFileName=" + bFileName + "]";
	}
	
	
	
	
}
