package com.cybord.ti.thrift.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdAt;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", createdAt=" + createdAt + "]";
	}

}
