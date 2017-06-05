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
@Table(name = "STATUS_REASON")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StatusReason {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "REASONID")
	private long reasonId;
	
	@Column(name = "REASONNAME")
	private String reasonName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	public long getreasonId() {
		return reasonId;
	}

	public void setreasonId(long reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
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
