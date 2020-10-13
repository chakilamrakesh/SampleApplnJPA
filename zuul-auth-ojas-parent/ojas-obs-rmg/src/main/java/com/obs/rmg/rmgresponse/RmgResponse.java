package com.obs.rmg.rmgresponse;

import java.util.List;

import com.obs.rmg.rmgmodel.RMG;
import com.obs.rmg.rmgmodel.RmgEmployeeList;
import com.obs.rmg.rmgmodel.RmgGeneric;
import com.obs.rmg.rmgmodel.RmgGenericResourceMap;
import com.obs.rmg.rmgmodel.RmgSpecific;

public class RmgResponse {
	
	private String message;
	private String statusCode;
	private List<RMG> rmgInfo;
	private List<String> empIdList;
	private RmgSpecific rmgSpecificList;
	private RmgGenericResourceMap rmgGenericResourceList;
	private RMG rmg;
	private RmgGeneric rmgGenericList;
	private List<RmgEmployeeList> rmgemployeelist;
	
	
	
	public List<RmgEmployeeList> getRmgemployeelist() {
		return rmgemployeelist;
	}
	public void setRmgemployeelist(List<RmgEmployeeList> rmgemployeelist) {
		this.rmgemployeelist = rmgemployeelist;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<RMG> getRmgInfo() {
		return rmgInfo;
	}
	public void setRmgInfo(List<RMG> rmgInfo) {
		this.rmgInfo = rmgInfo;
	}
	public List<String> getEmpIdList() {
		return empIdList;
	}
	public void setEmpIdList(List<String> empIdList) {
		this.empIdList = empIdList;
	}
	public RMG getRmg() {
		return rmg;
	}
	public void setRmg(RMG rmg) {
		this.rmg = rmg;
	}
	public RmgSpecific getRmgSpecificList() {
		return rmgSpecificList;
	}
	public void setRmgSpecificList(RmgSpecific rmgSpecificList) {
		this.rmgSpecificList = rmgSpecificList;
	}
	public RmgGenericResourceMap getRmgGenericResourceList() {
		return rmgGenericResourceList;
	}
	public void setRmgGenericResourceList(RmgGenericResourceMap rmgGenericResourceList) {
		this.rmgGenericResourceList = rmgGenericResourceList;
	}
	
	
	public RmgGeneric getRmgGenericList() {
		return rmgGenericList;
	}
	public void setRmgGenericList(RmgGeneric rmgGenericList) {
		this.rmgGenericList = rmgGenericList;
	}
	
	@Override
	public String toString() {
		return "RmgResponse [message=" + message + ", statusCode=" + statusCode + ", rmgInfo=" + rmgInfo
				+ ", empIdList=" + empIdList + ", rmgSpecificList=" + rmgSpecificList + ", rmgGenericResourceList="
				+ rmgGenericResourceList + ", rmg=" + rmg + ", rmgGenericList=" + rmgGenericList + ", rmgemployeelist="
				+ rmgemployeelist + "]";
	}
	

	
}
