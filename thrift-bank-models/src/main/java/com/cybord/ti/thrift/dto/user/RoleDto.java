package com.cybord.ti.thrift.dto.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author eddyrs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto implements Serializable {

	private static final long serialVersionUID = -7424841432484983374L;

	private Integer id;

	private String name;

	private Date created_at;

	public RoleDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", created_at=" + created_at + "]";
	}

}
