package org.smart.earn.model;

import java.util.Date;

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
@Table(name = "PROPERTY_TYPE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PropertyType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROPERTYTYPEID")
	private long propertyTypeId;
	
	@Column(name = "PROPERTYTYPE")
	private String propertyType;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public long getPropertyTypeId() {
		return propertyTypeId;
	}
	public void setPropertyTypeId(long propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
