package com.role.app.domain;

import java.util.List;

public class RoleResponseListDto {

	private List<RoleResponseDto> roleResponseDtos;
	private Notification notification;

	public List<RoleResponseDto> getRoleResponseDtos() {
		return roleResponseDtos;
	}

	public void setRoleResponseDtos(List<RoleResponseDto> roleResponseDtos) {
		this.roleResponseDtos = roleResponseDtos;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
