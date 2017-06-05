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
@Table(name = "PARTY_SELLER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PartySeller {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PARTYSELLERID")
	private long partySellerId;
	
	@Column(name = "USERID")
	private long userId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_property")
	private Property property;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "REG_DATE")
	private Date regDate;
	
	public long getPartySellerId() {
		return partySellerId;
	}
	public void setPartySellerId(long partySellerId) {
		this.partySellerId = partySellerId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
