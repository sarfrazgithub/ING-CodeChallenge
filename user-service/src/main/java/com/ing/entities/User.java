package com.ing.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="user")
public class User  {

    /**
	 * 
	 */
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    
    @JsonIgnore
    @Digits(integer = 5, fraction = 0, message = "UserID cannot be more than 5digits")
    private int userid;
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    @JsonIgnore
    private Address address;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userId) {
		this.userid = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 @JsonIgnore
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "{\r\n" + 
				"               \"title\": \""+this.title+"\",\r\n" + 
				"               \"firstname\": \""+this.firstname+"\",\r\n" + 
				"               \"lastname\": \""+this.lastname+"\",\r\n" + 
				"               \"gender\": \""+this.gender+"\",\r\n" + 
				"               \"address\": {\r\n" + 
				"                              \"street\": \""+this.address.getStreet()+"\",\r\n" + 
				"                              \"city\": \""+this.address.getCity()+"\",\r\n" + 
				"                              \"state\": \""+this.address.getState()+"\",\r\n" + 
				"                              \"postcode\": "+this.address.getPostcode()+"\r\n" + 
				"               }\r\n" + 
				"   }\r\n" + 
				"";
	                   
	}
   
}
