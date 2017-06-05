package org.smart.earn.model;

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
@Table(name = "CURRENCY")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Currency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CURRENCYID")
	private long currencyId;
	
	@Column(name = "CURRENCYCODE")
	private String currencyCode;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_COUNTRYCODE")
	private Country fk_countryCode;
	
	@Column(name = "CURRENCYNAME")
	private String currencyName;
	
	@Column(name = "SAVE_DATE")
	private String save_date;

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Country getFk_countryCode() {
		return fk_countryCode;
	}

	public void setFk_countryCode(Country fk_countryCode) {
		this.fk_countryCode = fk_countryCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getSave_date() {
		return save_date;
	}

	public void setSave_date(String save_date) {
		this.save_date = save_date;
	}

}
