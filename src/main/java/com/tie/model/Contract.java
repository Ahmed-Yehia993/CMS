/**
 * 
 */
package com.tie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	private String Type;
	@Column(name = "file_path")
	private String hardCopyPath;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_users", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	// how to add extra column for the user_action (create, approve, modify, ...)
	private ArrayList<User> users;
	private Contact contact;
	@Column(name = "shop_area")
	private float area;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "contract_deals", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "deal_id"))
	private ArrayList<Deal> deals;
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
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getHardCopyPath() {
		return hardCopyPath;
	}

	public void setHardCopyPath(String hardCopyPath) {
		this.hardCopyPath = hardCopyPath;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public ArrayList<Deal> getDeals() {
		return deals;
	}

	public void setDeals(ArrayList<Deal> deals) {
		this.deals = deals;
	}

	public Set<Mag> getMags() {
		return mags;
	}

	public void setMags(Set<Mag> mags) {
		this.mags = mags;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", " + (accountNo != null ? "accountNo=" + accountNo + ", " : "")
				+ (startDate != null ? "startDate=" + startDate + ", " : "") + "duration=" + duration + ", "
				+ (status != null ? "status=" + status + ", " : "") + (Type != null ? "Type=" + Type + ", " : "")
				+ (hardCopyPath != null ? "hardCopyPath=" + hardCopyPath + ", " : "")
				+ (users != null ? "users=" + users + ", " : "") + (contact != null ? "contact=" + contact + ", " : "")
				+ "area=" + area + ", " + (deals != null ? "deals=" + deals + ", " : "")
				+ (mags != null ? "mags=" + mags : "") + "]";
	}

}
