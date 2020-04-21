package com.antarctica.antarcticalab.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

public class RoleEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "AUTHORITY_")
	private String authority;

	public RoleEntity() {

	}

	public RoleEntity(String authority) {
		super();
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {

		return authority;
	}

}
