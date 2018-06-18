/**
 * 
 */
package com.nagham.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * @author Ahmed El-Deeb
 *
 */

@Entity
@Table(name = "contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_id")
	private int id;
	@Column(name = "account_no")
	private String accountNo;
	@Column(name = "account_poid")
	private String accountPoid;
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "duration")
	private int duration;
	@Column(name = "status")
	private String status;
	@Column(name = "type")
	private String type;
	@Column(name = "file_path")
	private String hardCopyPath;
	@Column(name = "company_name")
	private String companyName;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Contact> contact;

	@Column(name = "shop_area")
	private float area;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_packages", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "package_id"))
	private Set<Package> packages;

	@OrderBy("validFrom ASC")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_mags", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "mag_id"))
	private Set<Mag> mags;

	private Date created;
	private Date updated;

	@PrePersist
	private void onCreate() {
		this.created = new Date();
	}

	@PreUpdate
	private void onUpdate() {
		this.updated = new Date();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountPoid() {
		return accountPoid;
	}

	public void setAccountPoid(String accountPoid) {
		this.accountPoid = accountPoid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHardCopyPath() {
		return hardCopyPath;
	}

	public void setHardCopyPath(String hardCopyPath) {
		this.hardCopyPath = hardCopyPath;
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public Set<Package> getPackages() {
		return packages;
	}

	public void setPackages(Set<Package> packages) {
		this.packages = packages;
	}

	public Set<Mag> getMags() {
		return mags;
	}

	public void setMags(Set<Mag> mags) {
		this.mags = mags;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"id=" + id +
				", accountNo='" + accountNo + '\'' +
				", accountPoid='" + accountPoid + '\'' +
				", startDate=" + startDate +
				", duration=" + duration +
				", status='" + status + '\'' +
				", type='" + type + '\'' +
				", hardCopyPath='" + hardCopyPath + '\'' +
				", companyName='" + companyName + '\'' +
				", contact=" + contact +
				", area=" + area +
				", packages=" + packages +
				", mags=" + mags +
				", created=" + created +
				", updated=" + updated +
				'}';
	}
}
