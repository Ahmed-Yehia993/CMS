/**
 * 
 */
package com.tie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ahmed El-Deeb
 *
 */
@Entity
@Table(name = "mag")
public class Mag {

	@Column(name = "mag_id")
	private int id;
	@Column(name = "amount")
	private long amount;
	@Column(name = "valid_from")
	private Date validFrom;
	@Column(name = "valid_to")
	private Date validTo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Override
	public String toString() {
		return "Mag [id=" + id + ", amount=" + amount + ", "
				+ (validFrom != null ? "validFrom=" + validFrom + ", " : "")
				+ (validTo != null ? "validTo=" + validTo : "") + "]";
	}

}
