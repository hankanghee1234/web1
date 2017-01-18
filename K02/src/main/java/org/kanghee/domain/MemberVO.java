package org.kanghee.domain;

import java.util.Arrays;
import java.util.Date;

public class MemberVO {

	private Integer uno;
	private String uid;
	private String upw;
	private String email;
	private String uname;
	private String uimg;
	private Date regdate;
	private Date updatedate;
	private int viewcnt;
	private int replycnt;
	
	private String[] files;

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "MemberVO [uno=" + uno + ", uid=" + uid + ", upw=" + upw + ", email=" + email + ", uname=" + uname
				+ ", uimg=" + uimg + ", regdate=" + regdate + ", updatedate=" + updatedate + ", viewcnt=" + viewcnt
				+ ", replycnt=" + replycnt + ", files=" + Arrays.toString(files) + ", getReplycnt()=" + getReplycnt()
				+ ", getViewcnt()=" + getViewcnt() + ", getUno()=" + getUno() + ", getUid()=" + getUid() + ", getUpw()="
				+ getUpw() + ", getEmail()=" + getEmail() + ", getUname()=" + getUname() + ", getUimg()=" + getUimg()
				+ ", getRegdate()=" + getRegdate() + ", getUpdatedate()=" + getUpdatedate() + ", getFiles()="
				+ Arrays.toString(getFiles()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
}
