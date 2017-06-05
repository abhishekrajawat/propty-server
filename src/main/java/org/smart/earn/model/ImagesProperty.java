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
@Table(name = "IMAGES_PROPERTY")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ImagesProperty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROPERTYIMAGESID")
	private long propertyImagesId;
	
	@Column(name = "IMAGES_URL")
	private String imagesURL;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_property")
	private Property property;
	
	@Column(name = "CURRENCY_SIMBOL")
	private String currencySymbol;
	
	@Column(name = "SAVE_DATE")
	private Date saveDate;

	public long getPropertyImagesId() {
		return propertyImagesId;
	}

	public void setPropertyImagesId(long propertyImagesId) {
		this.propertyImagesId = propertyImagesId;
	}

	public String getImagesURL() {
		return imagesURL;
	}

	public void setImagesURL(String imagesURL) {
		this.imagesURL = imagesURL;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

}
