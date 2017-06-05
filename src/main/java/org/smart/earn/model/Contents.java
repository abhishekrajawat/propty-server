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
@Table(name = "CONTENTS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Contents {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CONTENTID")
	private long contentId;
	
	@Column(name = "PAGETITLE")
	private String pageTitle;
	
	@Column(name = "PAGESUBTITLE")
	private String pageSubTitle;
	
	@Column(name = "PAGESUBSUBTITLE")
	private String pageSubSubTitle;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "REMARKS")
	private String remarks;

	public long getContentId() {
		return contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageSubTitle() {
		return pageSubTitle;
	}

	public void setPageSubTitle(String pageSubTitle) {
		this.pageSubTitle = pageSubTitle;
	}

	public String getPageSubSubTitle() {
		return pageSubSubTitle;
	}

	public void setPageSubSubTitle(String pageSubSubTitle) {
		this.pageSubSubTitle = pageSubSubTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
