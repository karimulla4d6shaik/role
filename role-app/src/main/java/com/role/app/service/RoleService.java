package com.role.app.service;

import com.role.app.domain.RoleFinalResponseDto;
import com.role.app.domain.RoleRequestDto;
import com.role.app.domain.RoleResponseListDto;

public interface RoleService {
	public RoleResponseListDto addRole(RoleRequestDto roleRequestDto);

	public RoleResponseListDto updateRole(RoleRequestDto roleRequestDto);

	public RoleResponseListDto deleteRole(String roleCode);

	public RoleFinalResponseDto getRole(String roleCode);

	public RoleResponseListDto getRoles(String status, Integer statusCode, String message);
}
