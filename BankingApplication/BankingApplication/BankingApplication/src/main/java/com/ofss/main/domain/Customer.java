package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="customer_id")
	private int id;
	@Column(name ="customer_email")
    private String email;
    @Column(name ="customer_name")
    private String name;
    @Column(name ="customer_phone")
    private String phone;
    @Column(name ="customer_address")
    private String address;
    @Column(name ="customer_login_id")
    private String login_id;
    @Column(name ="customer_password")
    private String password;
    @Column(name ="customer_country")
    private String country;
    @Column(name ="customer_state")
    private String state;
    
    public Customer() {
    	
    }
    

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", login_id=" + login_id + ", password=" + password + ", country=" + country + ", state="
				+ state + "]";
	}


	public Customer(int id, String email, String name, String phone, String address, String login_id, String password,
			int login_attempts, String country, String state) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.login_id = login_id;
		this.password = password;
		this.country = country;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


    
	    
}
