package com.cabs.model;

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
@Table(name="request")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private Integer requestId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ModelEmp.class)
	@JoinColumn(name="id")
	private ModelEmp emp;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ModelBookingDetails.class)
	@JoinColumn(name="bookingId")
	private ModelBookingDetails bookingId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ModelBookingStatus.class)
	@JoinColumn(name="bId")
	private ModelBookingStatus bId;
	
	/**
	 * @param emp
	 * @param bId
	 */
	public Request() {
		
	}
	public Request( ModelEmp emp, ModelBookingStatus bId) {
		this.emp = emp;
		this.bId = bId;
		this.bookingId = null;
	}

	/**
	 * @param emp
	 * @param bookingId
	 * @param bId
	 */
	public Request( ModelEmp emp, ModelBookingDetails bookingId, ModelBookingStatus bId) {
		this.emp = emp;
		this.bookingId = bookingId;
		this.bId = bId;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public ModelEmp getEmp() {
		return emp;
	}

	public ModelBookingDetails getBookingId() {
		return bookingId;
	}

	public ModelBookingStatus getbId() {
		return bId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public void setEmp(ModelEmp emp) {
		this.emp = emp;
	}

	public void setBookingId(ModelBookingDetails bookingId) {
		this.bookingId = bookingId;
	}

	public void setbId(ModelBookingStatus bId) {
		this.bId = bId;
	}
	
	

}

