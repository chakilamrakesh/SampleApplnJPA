package com.obs.rmg.rmgrequest;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.obs.rmg.rmgmodel.ProjectList;
import com.obs.rmg.rmgmodel.RMG;
import com.obs.rmg.rmgmodel.RmgEmployeeList;
import com.obs.rmg.rmgmodel.RmgGeneric;
import com.obs.rmg.rmgmodel.RmgGenericResourceMap;
import com.obs.rmg.rmgmodel.RmgSpecific;
import com.obs.rmg.rmgmodel.SkillsList;


public class RmgRequest {
	
	private String transactiontype;
	
	private RMG rmgInfo;
	
	private Set<RmgSpecific> rmgSpecificList;
	
	private SkillsList skilllist;
	
	private Set<RmgGeneric> rmgGenericList;
	
	
	private Set<RmgGenericResourceMap> rmgGenericResourceList;
	
    private ProjectList projectlist;
   
   private RmgEmployeeList rmgemployeelist;

	public ProjectList getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(ProjectList projectlist) {
		this.projectlist = projectlist;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public RMG getRmgInfo() {
		return rmgInfo;
	}

	public void setRmgInfo(RMG rmgInfo) {
		this.rmgInfo = rmgInfo;
	}

	public Set<RmgSpecific> getRmgSpecificList() {
		return rmgSpecificList;
	}

	public void setRmgSpecificList(Set<RmgSpecific> rmgSpecificList) {
		this.rmgSpecificList = rmgSpecificList;
	}

	public SkillsList getSkilllist() {
		return skilllist;
	}

	public void setSkilllist(SkillsList skilllist) {
		this.skilllist = skilllist;
	}

	public Set<RmgGeneric> getRmgGenericList() {
		return rmgGenericList;
	}

	public void setRmgGenericList(Set<RmgGeneric> rmgGenericList) {
		this.rmgGenericList = rmgGenericList;
	}

	

	public Set<RmgGenericResourceMap> getRmgGenericResourceList() {
		return rmgGenericResourceList;
	}

	public void setRmgGenericResourceList(Set<RmgGenericResourceMap> rmgGenericResourceList) {
		this.rmgGenericResourceList = rmgGenericResourceList;
	}

	public RmgEmployeeList getRmgemployeelist() {
		return rmgemployeelist;
	}

	public void setRmgemployeelist(RmgEmployeeList rmgemployeelist) {
		this.rmgemployeelist = rmgemployeelist;
	}

	@Override
	public String toString() {
		return "RmgRequest [transactiontype=" + transactiontype + ", rmgInfo=" + rmgInfo + ", rmgSpecificList="
				+ rmgSpecificList + ", skilllist=" + skilllist + ", rmgGenericList=" + rmgGenericList
				+ ", rmgGenericResourceList=" + rmgGenericResourceList + ", projectlist=" + projectlist + "]";
	}

	

}
