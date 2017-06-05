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
import javax.persistence.Temporal;

/*
 * @author Abhishek
 * @since 07-05-2017
 * @version
 */

@Entity
@Table(name = "RENTAL_INCOME")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RentalIncome {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "RENTALINCOMEID")
	private long rentalIncomeId;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "BANKNAME")
	private String bankName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_property")
	private Property property;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PAYMENT_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name = "PAYMENTSTATUS")
	private String paymentStatus;

	public long getRentalIncomeId() {
		return rentalIncomeId;
	}

	public void setRentalIncomeId(long rentalIncomeId) {
		this.rentalIncomeId = rentalIncomeId;
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
		
}
