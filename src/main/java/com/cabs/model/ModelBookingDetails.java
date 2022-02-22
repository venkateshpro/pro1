package com.cabs.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bDetails")
public class ModelBookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private Integer bookingId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ModelCab.class)
	@JoinColumn(name="cabNo")
	private ModelCab cabNo;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ModelEmp.class)
	@JoinColumn(name="id")
	private ModelEmp emp;
	
	/**
	 * @param bookingId
	 * @param cabNo
	 * @param emp
	 */
	public ModelBookingDetails(ModelCab cabNo, ModelEmp emp) {
		this.cabNo = cabNo;
		this.emp = emp;
	}
	
	public ModelBookingDetails() {}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelBookingDetails other = (ModelBookingDetails) obj;
		return Objects.equals(bookingId, other.bookingId);
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public ModelCab getCabNo() {
		return cabNo;
	}

	public ModelEmp getEmplpoyeeId() {
		return emp;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public void setCabNo(ModelCab cabNo) {
		this.cabNo = cabNo;
	}

	public void setEmplpoyeeId(ModelEmp emp) {
		this.emp = emp;
	}
	
	
}