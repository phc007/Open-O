package org.oscarehr.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "provider")
public class ProviderData extends AbstractModel<String> implements Serializable {
/*
+------------------------+--------------+------+-----+------------+-------+
| Field                  | Type         | Null | Key | Default    | Extra |
+------------------------+--------------+------+-----+------------+-------+
| provider_no            | varchar(6)   | NO   | PRI |            |       |
| last_name              | varchar(30)  | NO   |     |            |       |
| first_name             | varchar(30)  | NO   |     |            |       |
| provider_type          | varchar(15)  | NO   |     |            |       |
| specialty              | varchar(40)  | NO   |     |            |       |
| team                   | varchar(20)  | YES  |     |            |       |
| sex                    | char(1)      | NO   |     |            |       |
| dob                    | date         | YES  |     | NULL       |       |
| address                | varchar(40)  | YES  |     | NULL       |       |
| phone                  | varchar(20)  | YES  |     | NULL       |       |
| work_phone             | varchar(50)  | YES  |     | NULL       |       |
| ohip_no                | varchar(20)  | YES  |     | NULL       |       |
| rma_no                 | varchar(20)  | YES  |     | NULL       |       |
| billing_no             | varchar(20)  | YES  |     | NULL       |       |
| hso_no                 | varchar(10)  | YES  |     | NULL       |       |
| status                 | char(1)      | YES  |     | NULL       |       |
| comments               | text         | YES  |     | NULL       |       |
| provider_activity      | char(3)      | YES  |     | NULL       |       |
| practitionerNo         | varchar(20)  | YES  |     | NULL       |       |
| init                   | varchar(10)  | YES  |     | NULL       |       |
| job_title              | varchar(100) | YES  |     | NULL       |       |
| email                  | varchar(60)  | YES  |     | NULL       |       |
| title                  | varchar(20)  | YES  |     | NULL       |       |
| lastUpdateUser         | varchar(6)   | YES  |     | NULL       |       |
| lastUpdateDate         | date         | YES  |     | NULL       |       |
| signed_confidentiality | date         | YES  |     | 0001-01-01 |       |
+------------------------+--------------+------+-----+------------+-------+ 	
 */

	@Id
	@Column(name = "provider_no")
	private String id = null;
	@Column(name = "last_name")
	private String lastName = null;
	@Column(name = "first_name")
	private String firstName = null;
	@Column(name = "provider_type")
	private String providerType = null;
	@Column(name = "specialty")
	private String specialty = null;
	@Column(name = "team")
	private String team = null;
	@Column(name = "sex")
	private String sex = null;
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dob = null;
	@Column(name = "address")
	private String address = null;
	@Column(name = "phone")
	private String phone = null;
	@Column(name = "work_phone")
	private String workPhone = null;
	@Column(name = "ohip_no")
	private String ohipNo = null;
	@Column(name = "rma_no")
	private String rmaNo = null;
	@Column(name = "billing_no")
	private String billingNo = null;
	@Column(name = "hso_no")
	private String hsoNo = null;
	@Column(name = "status")
	private String status = null;
	@Column(name = "comments")
	private String comments = null;
	@Column(name = "provider_activity")
	private String providerActivity = null;
	@Column(name = "practitionerNo")
	private String practitionerNo = null;
	@Column(name = "init")
	private String init = null;
	@Column(name = "job_title")
	private String jobTitle = null;
	@Column(name = "email")
	private String email = null;
	@Column(name = "title")
	private String title = null;
	@Column(name = "lastUpdateUser")
	private String lastUpdateUser = null;
	@Column(name = "lastUpdateDate")
	@Temporal(TemporalType.DATE)
	private Date lastUpdateDate = null;
	@Column(name = "signed_confidentiality")
	@Temporal(TemporalType.DATE)
	private Date signedConfidentiality = null;
	
	public ProviderData() {}
	
	public String getId() {
		return id;
	}
	public void set(String providerNo) {
		id = providerNo;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String s) {
		lastName = s;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String s) {
		firstName = s;
	}

	public String getProviderType() {
		return providerType;
	}
	public void setProviderType(String s) {
		providerType = s;
	}

	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String s) {
		specialty = s;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String s) {
		team = s;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String s) {
		sex = s;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date d) {
		dob = d;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String s) {
		address = s;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String s) {
		phone = s;
	}

	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String s) {
		workPhone = s;
	}

	public String setOhipNo() {
		return ohipNo;
	}
	public void setOhipNo(String s) {
		ohipNo = s;
	}

	public String getRmaNo() {
		return rmaNo;
	}
	public void setRmaNo(String s) {
		rmaNo = s;
	}

	public String getBillingNo() {
		return billingNo;
	}
	public void setBillingNo(String s) {
		billingNo = s;
	}

	public String getHsoNo() {
		return hsoNo;
	}
	public void setHsoNo(String s) {
		hsoNo = s;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String s) {
		status = s;
	}

	public String getComments() {
		return comments;
	}
	public void setComments(String s) {
		comments = s;
	}

	public String getProviderActivity() {
		return providerActivity;
	}
	public void setProviderActivity(String s) {
		providerActivity = s;
	}

	public String getPractitionerNo() {
		return practitionerNo;
	}
	public void setPractitionerNo(String s) {
		practitionerNo = s;
	}

	public String getInit() {
		return init;
	}
	public void setInit(String s) {
		init = s;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String s) {
		jobTitle = s;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String s) {
		email = s;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String s) {
		title = s;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String s) {
		lastUpdateUser = s;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date d) {
		lastUpdateDate = d;
	}

	public Date getSignedConfidentiality() {
		return signedConfidentiality;
	}
	public void setSignedConfidentiality(Date d) {
		signedConfidentiality = d;
	}
}