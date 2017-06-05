package org.smart.earn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * @author Abhishek
 * @since 07-05-2017
 * @version
 */

@Entity
@Table(name = "ACCOUNTTYPE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AccountType implements Serializable{

	private static final long serialVersionUID = 1248810892178146079L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ACCOUNTTYPEID")
	private long accountTypeId;
	
	@Column(name = "ACCOUNTTYPE")
	private String accountType;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
