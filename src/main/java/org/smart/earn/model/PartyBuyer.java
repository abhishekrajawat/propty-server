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
@Table(name = "PARTY_BUYER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PartyBuyer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PARTYBUYERID")
	private long partyBuyerId;
	
	@Column(name = "USERID")
	private long userId;
	
	@Column(name = "NO_OF_UNITS")
	private int noOfUnits;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_property")
	private Property property;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "REG_DATE")
	private Date regDate;

	public long getPartyBuyerId() {
		return partyBuyerId;
	}

	public void setPartyBuyerId(long partyBuyerId) {
		this.partyBuyerId = partyBuyerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
