package com.obs.rmg.rmgmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="rmg_generic_resources_mapping")
public class RmgGenericResourceMap 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int resourcegenericId;
	
	@Column
	private String empId;
	
	@Column
	private String startDate;
	
	@Column
	private String endDate;
	
	@Column
	private String genericStatus;
	
	@Transient
	private String genericEmployeeStatus;
	
	@Column
	private Boolean flag;


	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","rmggenericresourcemap"})
	    @ManyToOne
	    @JoinColumn(name = "genericId")
	    private RmgGeneric rmggeneric;

	public int getResourcegenericId() {
		return resourcegenericId;
	}

	public void setResourcegenericId(int resourcegenericId) {
		this.resourcegenericId = resourcegenericId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	

	public RmgGeneric getRmggeneric() {
		return rmggeneric;
	}

	public void setRmggeneric(RmgGeneric rmggeneric) {
		this.rmggeneric = rmggeneric;
	}

	public String getGenericStatus() {
		return genericStatus;
	}

	public void setGenericStatus(String genericStatus) {
		this.genericStatus = genericStatus;
	}

	public String getGenericEmployeeStatus() {
		return genericEmployeeStatus;
	}

	public void setGenericEmployeeStatus(String genericEmployeeStatus) {
		this.genericEmployeeStatus = genericEmployeeStatus;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	
	

}
