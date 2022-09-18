package com.role.app.domain;

public class RoleFinalResponseDto {

	private RoleResponseDto roleResponseDto;
	private Notification notification;

	public RoleResponseDto getRoleResponseDto() {
		return roleResponseDto;
	}

	public void setRoleResponseDto(RoleResponseDto roleResponseDto) {
		this.roleResponseDto = roleResponseDto;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
