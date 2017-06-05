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
@Table(name = "INCOME_SHARE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IncomeShare {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "INCOMESHAREID")
	private long incomeShareId;
	
	@Column(name = "AMOUNT_PER_UNIT")
	private double amountPerUnit;
	
	@Column(name = "BUYER_UNITS")
	private int buyerUnits;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_property")
	private Property property;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	
	@Column(name = "PAYMENTSTATUS")
	private String paymentStaus;
	
	public long getIncomeShareId() {
		return incomeShareId;
	}

	public void setIncomeShareId(long incomeShareId) {
		this.incomeShareId = incomeShareId;
	}

	public double getAmountPerUnit() {
		return amountPerUnit;
	}

	public void setAmountPerUnit(double amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
	}

	public int getBuyerUnits() {
		return buyerUnits;
	}

	public void setBuyerUnits(int buyerUnits) {
		this.buyerUnits = buyerUnits;
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

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStaus() {
		return paymentStaus;
	}

	public void setPaymentStaus(String paymentStaus) {
		this.paymentStaus = paymentStaus;
	}

}
