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
@Table(name = "PROPERTY")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Property {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PROPERTYID")
    private long propertyId;
    
    @Column(name = "USERID")
    private String userId;
    
    @Column(name = "PROPERTYNAME")
    private String propertyName;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_propertytype")
    private PropertyType propertyType;
    
    @Column(name = "IMAGES")
    private String images;
    
    @Column(name = "CONSTRUCTION_AREA")
    private double constructionArea;
    
    @Column(name = "TOTAL_AREA")
    private double totalArea;
    
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    
    @Column(name = "UNIT_PRICE")
    private double unitPrice;
    
    @Column(name = "NO_OF_UNITS")
    private long noOfUnit;
    
    @Column(name = "AVAILABLE")
    private String available;
    
    @Column(name = "UNITS_SOLD")
    private long unitsSold;
    
    @Column(name = "ADDRESSLINE1")
    private String addressLine1;
    
    @Column(name = "ADDRESSLINE2")
    private String addressLine2;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "POSTCODE")
    private String postcode;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "REG_DATE")
    private Date regDate;
    
    public long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    public PropertyType getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public double getConstructionArea() {
        return constructionArea;
    }
    public void setConstructionArea(double constructionArea) {
        this.constructionArea = constructionArea;
    }
    public double getTotalArea() {
        return totalArea;
    }
    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public long getNoOfUnit() {
        return noOfUnit;
    }
    public void setNoOfUnit(long noOfUnit) {
        this.noOfUnit = noOfUnit;
    }
    public String getAvailable() {
        return available;
    }
    public void setAvailable(String available) {
        this.available = available;
    }
    public long getUnitsSold() {
        return unitsSold;
    }
    public void setUnitsSold(long unitsSold) {
        this.unitsSold = unitsSold;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
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
    
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
}
