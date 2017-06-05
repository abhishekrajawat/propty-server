package org.smart.earn.model;

import java.io.Serializable;
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
@Table(name = "APPROVER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Approver implements Serializable{

	private static final long serialVersionUID = 7754023388301867249L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APPROVERID")
	private long approverId;
	
	@Column(name = "APPROVERNAME")
	private String approverName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_authUser")
	private AuthUser authUser;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_authUserrole")
	private AuthUserRole authUserRole;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public long getApproverId() {
		return approverId;
	}
	public void setApproverId(long approverId) {
		this.approverId = approverId;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public AuthUser getAuthUser() {
		return authUser;
	}
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
	public AuthUserRole getAuthUserRole() {
		return authUserRole;
	}
	public void setAuthUserRole(AuthUserRole authUserRole) {
		this.authUserRole = authUserRole;
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
