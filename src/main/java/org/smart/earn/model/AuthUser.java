package org.smart.earn.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
* @author Abhishek
* @since 07-05-2017
* @version
*/

@Entity
@Table(name = "AUTH_USER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AuthUser {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USERID")
    private long userId;
    
    @Column(name = "FIRSTNAME")
    private String firstName;
    
    @Column(name = "MIDDLENAME")
    private String middleName;
    
    @Column(name = "LASTNAME")
    private String lastName;
    
    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "IMAGE")
    private String userImage;
    
    @Column(name = "PHONENO")
    private String phoneNo;
    
    @Column(name = "MOBILENO")
    private String mobileNo;
    
    @Column(name = "ADDRESSLINE1")
    private String addressLine1;
    
    @Column(name = "ADDRESSLINE2")
    private String addressLine2;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "POSTCODE")
    private String postCode;
    
    @Column(name = "FAXNO")
    private String faxNo;
    
    @Column(name = "ALTERNATECONTACT")
    private String alternateContact;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ROLE")
    private AuthUserRole authUserRole;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "PASSWORD_CONFIRM")
    private String passwordConfirm;
    
	@Column(name = "ISACTIVE")
    private String isactive;
    
    @Column(name = "REG_DATE")
    private Date reg_date;
    
    public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    
    public String getAddressLine2() {
        return addressLine2;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String getFaxNo() {
        return faxNo;
    }
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    public String getAlternateContact() {
        return alternateContact;
    }
    public void setAlternateContact(String alternateContact) {
        this.alternateContact = alternateContact;
    }
    public AuthUserRole getAuthUserRole() {
        return authUserRole;
    }
    public void setAuthUserRole(AuthUserRole authUserRole) {
        this.authUserRole = authUserRole;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getIsactive() {
        return isactive;
    }
    
    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }
    
    public Date getReg_date() {
        return reg_date;
    }
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserImage() {
        return userImage;
    }
    
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
    
}
