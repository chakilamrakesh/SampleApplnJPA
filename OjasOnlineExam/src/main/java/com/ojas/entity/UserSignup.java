package com.ojas.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author kmahendra
 *
 */
public class UserSignup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int signupId;
	private int userid;
	private String password;
	private Date singupDate;
	private boolean status;
	private Date unlockDate;

	public int getSignupId() {
		return signupId;
	}

	public void setSignupId(int signupId) {
		this.signupId = signupId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getSingupDate() {
		return singupDate;
	}

	public void setSingupDate(Date singupDate) {
		this.singupDate = singupDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getUnlockDate() {
		return unlockDate;
	}

	public void setUnlockDate(Date unlockDate) {
		this.unlockDate = unlockDate;
	}

}
