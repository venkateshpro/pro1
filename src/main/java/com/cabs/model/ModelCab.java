package com.cabs.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cab")

public class ModelCab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private  Integer cabNo;
	
	@Column(nullable= false)
	private Integer status;
	@Column(nullable= false)
	private String driverName;
	@Column(nullable= false)
	private String driverMobile;
	
	public ModelCab(Integer cabNo, Integer status, String drivername, String drivermobile) {
		this.cabNo = cabNo;
		this.status = status;
		this.driverName = drivername;
		this.driverMobile = drivermobile;
	}
	public ModelCab() {}


	/**
	 * @return the cabNo
	 */
	public Integer getCabNo() {
		return cabNo;
	}
    	

	/**
	 * @return the status
	 */

	public Integer getStatus() {
		return status;
	}


	/**
	 * @return the getname
	 */
	public String getDname() {
		return driverName;
	}


	public String getDmobile() {
		return driverMobile;
	}



	/**
	 * @param cabNo the cabNo to set
	 */
	public void setCabNo(Integer cabNo) {
		this.cabNo = cabNo;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @param dName the dName to set
	 */
	public void setdName(String dName) {
		this.driverName = dName;
	}

	/**
	 * @param dMobile the dMobile to set
	 */
	public void setdMobile(String dMobile) {
		this.driverMobile = dMobile;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cabNo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelCab other = (ModelCab) obj;
		return Objects.equals(cabNo, other.cabNo);
	}


	@Override
	public String toString() {
		return "Cab [Cab No=" + cabNo + ", Status=" + status
				+ ", Driver Name=" + driverName + ", Driver Mobile no=" + driverMobile + "]";
	}


	public void setStatus(int i) {
		// TODO Auto-generated method stub
		
	}


	
	

}
	
	
	
