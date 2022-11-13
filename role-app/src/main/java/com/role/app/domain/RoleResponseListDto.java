package com.role.app.domain;

import java.util.List;

public class RoleResponseListDto {

	private List<RoleResponseDto> roleResponseDtos;
	private Notification notification;
	private Integer totalPages;
	private Long totalElements;
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

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
