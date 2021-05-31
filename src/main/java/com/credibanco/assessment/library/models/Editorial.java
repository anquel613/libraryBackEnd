package com.credibanco.assessment.library.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

@Entity
public class Editorial implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private long telephone;
	private String mail;
	@Column(columnDefinition = "integer default -1")
	@NotNull
	private int booksLimit;

	public Editorial() {
		super();
	}
	
	
	public Editorial(String name, String address, long telephone, String mail, int booksLimit) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.booksLimit = booksLimit;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getBooksLimit() {
		return booksLimit;
	}
	public void setBooksLimit(int booksLimit) {
		this.booksLimit = booksLimit;
	}
	
	
}
