/**
 * 
 */
package com.tie.model;

import java.util.ArrayList;
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
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "duration")
	private int duration;
	@Column(name = "status")
	private String status;
	@Column(name = "type")
	private String type;
	@Column(name = "file_path")
	private String hardCopyPath;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Contact> contact;

	@Column(name = "shop_area")
	private float area;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_deals", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "deal_id"))
	private Set<Deal> deals;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_mags", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "mag_id"))
	private Set<Mag> mags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		type = type;
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

	public Set<Deal> getDeals() {
		return deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

	public Set<Mag> getMags() {
		return mags;
	}

	public void setMags(Set<Mag> mags) {
		this.mags = mags;
	}

	@Override
	public String toString() {
		return "Contract{" + "id=" + id + ", accountNo='" + accountNo + '\'' + ", startDate=" + startDate
				+ ", duration=" + duration + ", status='" + status + '\'' + ", type='" + type + '\''
				+ ", hardCopyPath='" + hardCopyPath + '\'' + ", contact=" + contact + ", area=" + area + ", deals="
				+ deals + ", mags=" + mags + '}';
	}
}
