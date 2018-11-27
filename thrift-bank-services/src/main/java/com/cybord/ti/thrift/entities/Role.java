package com.cybord.ti.thrift.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eddyrs
 */
@Entity
@Table(name = "ui_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 9110154690984721182L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@Column(name = "created_at")
	private Date created_at;

	public Role() {
		super();
	}

	public Role(Integer id, String name, Date created_at) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", created_at=" + created_at + "]";
	}

}
