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
@Table(name = "PAYMENTINFO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PaymentInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PAYMENTINFOID")
	private long paymentInfoId;
	
	@Column(name = "USERID")
	private long userId;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "BANKNAME")
	private String bankName;
	
	@Column(name = "NO_OF_UNITS")
	private int noOfUnits;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PROPERTY")
	private Property property;
	
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	
	@Column(name = "PAYMENTSTATUS")
	private String paymentStatus;

	public long getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(long paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
