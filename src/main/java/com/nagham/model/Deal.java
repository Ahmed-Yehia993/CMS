/**
 * 
 */
package com.nagham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ahmed El-Deeb
 *
 */
@Entity
@Table(name = "deal")
public class Deal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deal_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "poid")
	private String poid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (poid != null ? "poid=" + poid : "") + "]";
	}

}
