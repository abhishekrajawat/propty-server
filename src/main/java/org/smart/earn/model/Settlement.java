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
@Table(name = "SETTLEMENT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Settlement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SETTLEMENTID")
	private long settlementId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PAYMENTINFO")
	private PaymentInfo paymentInfo;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "NO_OF_UNITS")
	private int noOfUnits;
	
	@Column(name = "COMMISSION")
	private double commission;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PROPERTY")
	private Property property;
	
	@Column(name = "PAYMENT_DATE")
	private Date paymentdate;

	public long getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(long settlementId) {
		this.settlementId = settlementId;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
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

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

}
