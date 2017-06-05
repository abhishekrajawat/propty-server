package org.smart.earn.model;

import java.io.Serializable;
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
@Table(name = "ACCOUNT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account implements Serializable{ 

	private static final long serialVersionUID = 5636565617074452151L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ACCOUNTID")
	private long accountId;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_accounttype")
	private AccountType accountType;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_authuser")
	private AuthUser authUser;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public AuthUser getAuthUser() {
		return authUser;
	}
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
