package org.smart.earn.model;

import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * @author Abhishek
 * @since 07-05-2017
 * @version
 */

@Entity
@Table(name = "USERIMAGES")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserImages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USERIMAGESID")
	private long userImagesId;
	
	@Column(name = "IMAGES_URL")
	private String imageURL;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_authuser")
	private AuthUser authUser;
	
	@Column(name = "CURRENCYSIMBOL")
	private String currencySymbol;
	
	@Column(name = "SAVE_DATE")
	private Date saveDate;
	
	public long getUserImagesId() {
		return userImagesId;
	}
	public void setUserImagesId(long userImagesId) {
		this.userImagesId = userImagesId;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public AuthUser getAuthUser() {
		return authUser;
	}
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

}
