package com.cabs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class ModelEmp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private Integer id;
	
	@Column(nullable= false)
	private String name;
	
	@Column(nullable= false)
	private String email;
	
	@Column(nullable= false)
	private Integer manager;
	
	@Column(nullable= false)
	private String password;
	
	@Column(nullable= false)
	private String dept;
	
	public ModelEmp() {}
	

	
	public ModelEmp( String name, String email, Integer manager, String password, String dept) {
		this.name = name;
		this.email = email;
		this.manager = manager;
		this.password = password;
		this.dept = dept;
	}
	
	public ModelEmp(String name, String email, String password, String dept) {
		this.name = name;
		this.email = email;
		this.manager = 0;
		this.password = password;
		this.dept = dept;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getActive() {
		return password;
	}



	public void setActive(String active) {
		this.password = active;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public Integer getManager() {
		return manager;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelEmp other = (ModelEmp) obj;
		return Objects.equals(id, other.id);
	}
	
	public void setManager(Integer manager) {
		this.manager = manager;
	}
		
	

}

