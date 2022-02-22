package com.cabs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "bstatus")
public class ModelBookingStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private Integer bId;
	@Column(nullable= false)
	private String status;
	
	/**
	 * @param bId
	 * @param status
	 */
	
	
	
	
	public ModelBookingStatus(Integer bId, String status) {
		this.bId = bId;
		this.status = status;
	}
	public ModelBookingStatus() {}

	@Override
	public int hashCode() {
		return Objects.hash(bId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelBookingStatus other = (ModelBookingStatus) obj;
		return Objects.equals(bId, other.bId);
	}

	@Override
	public String toString() {
		return "BookingStatus [Current Satus is = " + status + "]";
	}

	public Integer getbId() {
		return bId;
	}

	public String getStatus() {
		return status;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}