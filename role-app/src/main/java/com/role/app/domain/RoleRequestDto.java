package com.role.app.domain;

import javax.validation.constraints.NotBlank;

public class RoleRequestDto {

	@NotBlank(message = "Role code must not empty or null")
	private String roleCode;
	@NotBlank(message = "Role name must not empty or null")
	private String roleName;
	@NotBlank(message = "Role description must not empty or null")
	private String roleDesc;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
