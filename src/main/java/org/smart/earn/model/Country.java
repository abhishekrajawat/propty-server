package org.smart.earn.model;

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
@Table(name = "COUNTRY")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COUNTRYID")
	private long countryId;
	
	@Column(name = "COUNTRYNAME")
	private String countryName;
	
	@Column(name = "COUNTRYCODE")
	private String countryCode;
	
	@Column(name = "COUNTRYFLAG")
	private String countryFlag;
	
	@Column(name = "SAVE_DATE")
	private String 	save_date;

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}

	public String getSave_date() {
		return save_date;
	}

	public void setSave_date(String save_date) {
		this.save_date = save_date;
	}

}
