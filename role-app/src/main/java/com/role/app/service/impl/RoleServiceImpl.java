package com.role.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.role.app.constants.RoleConstants;
import com.role.app.domain.RoleFinalResponseDto;
import com.role.app.domain.RoleRequestDto;
import com.role.app.domain.RoleResponseDto;
import com.role.app.domain.RoleResponseListDto;
import com.role.app.entity.RoleEntity;
import com.role.app.repo.RoleRepo;
import com.role.app.service.RoleService;
import com.role.app.util.RoleHelper;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private RoleHelper roleHelper;

	@Override
	public RoleResponseListDto addRole(RoleRequestDto roleRequestDto) {
		RoleEntity roleEntity = roleRepo.findByRoleCode(roleRequestDto.getRoleCode());
		RoleResponseListDto roleResponseListDto = null;
		if(roleEntity == null) {
			roleEntity = roleHelper.convertToTargetObject(RoleEntity.class, roleRequestDto);
			roleRepo.save(roleEntity);
			roleResponseListDto = getRoles(RoleConstants.ADD_ROLE_SUCCESS_STATUS, RoleConstants.ADD_ROLE_SUCCESS_STATUS_CODE, 
					RoleConstants.ADD_ROLE_SUCCESS_MESSAGE);			
		}else {
			roleResponseListDto = getRoles(RoleConstants.DATA_EXIST_STATUS, 
					RoleConstants.DATA_EXIST_STATUS_CODE, RoleConstants.DATA_EXIST_MESSAGE+roleRequestDto.getRoleCode());			
		}
		return roleResponseListDto;
	}

	@Override
	public RoleResponseListDto updateRole(RoleRequestDto roleRequestDto) {
		RoleEntity roleEntity = roleRepo.findByRoleCode(roleRequestDto.getRoleCode());
		RoleResponseListDto roleResponseListDto = null;
		if(roleEntity != null) {
			roleEntity.setRoleDesc(roleRequestDto.getRoleDesc());
			roleEntity.setRoleName(roleRequestDto.getRoleName());
			roleRepo.save(roleEntity);
			roleResponseListDto = getRoles(RoleConstants.UPDATE_ROLE_SUCCESS_STATUS, RoleConstants.UPDATE_ROLE_SUCCESS_STATUS_CODE, 
					RoleConstants.UPDATE_ROLE_SUCCESS_MESSAGE+roleRequestDto.getRoleCode());
		}else {
			roleResponseListDto = getRoles(RoleConstants.NO_DATA_STATUS, 
					RoleConstants.NO_DATA_STATUS_CODE, RoleConstants.NO_DATA_MESSAGE+roleRequestDto.getRoleCode());
		}
		return roleResponseListDto;
	}

	@Override
	public RoleResponseListDto deleteRole(String roleCode) {
		RoleEntity roleEntity = roleRepo.findByRoleCode(roleCode);
		RoleResponseListDto roleResponseListDto = null;
		if(roleEntity != null) {
			roleRepo.delete(roleEntity);
			roleResponseListDto = getRoles(RoleConstants.DELETE_ROLE_SUCCESS_STATUS, RoleConstants.DELETE_ROLE_SUCCESS_STATUS_CODE, 
					RoleConstants.DELETE_ROLE_SUCCESS_MESSAGE+roleCode);
		}else {
			roleResponseListDto = getRoles(RoleConstants.NO_DATA_STATUS, 
					RoleConstants.NO_DATA_STATUS_CODE, RoleConstants.NO_DATA_MESSAGE+roleCode);
		}
		return roleResponseListDto;
	}

	@Override
	public RoleFinalResponseDto getRole(String roleCode) {
		RoleEntity roleEntity = roleRepo.findByRoleCode(roleCode);
		RoleFinalResponseDto roleFinalResponseDto = new RoleFinalResponseDto();
		if(roleEntity != null) {			
			roleFinalResponseDto.setRoleResponseDto(roleHelper.convertToTargetObject(RoleResponseDto.class, roleEntity));
			roleFinalResponseDto
			.setNotification(roleHelper.buildNotification(RoleConstants.GET_ONE_ROLE_SUCCESS_STATUS, 
					RoleConstants.GET_ONE_ROLE_SUCCESS_STATUS_CODE, RoleConstants.GET_ONE_ROLE_SUCCESS_MESSAGE+roleCode, ""));
		}else {
			roleFinalResponseDto
			.setNotification(roleHelper.buildNotification(RoleConstants.NO_DATA_STATUS, 
					RoleConstants.NO_DATA_STATUS_CODE, RoleConstants.NO_DATA_MESSAGE+roleCode, ""));
		}
		return roleFinalResponseDto;
	}

	@Override
	public RoleResponseListDto getRoles(String status, Integer statusCode, String message) {
		List<RoleEntity> roleEntities = roleRepo.findAll();
		List<RoleResponseDto> roleResponseDtos = roleEntities.stream()
				.map(re -> roleHelper.convertToTargetObject(RoleResponseDto.class, re)).collect(Collectors.toList());
		RoleResponseListDto roleResponseListDto = new RoleResponseListDto();
		roleResponseListDto.setRoleResponseDtos(roleResponseDtos);
		if(roleResponseDtos.isEmpty() && status == null && statusCode == null && message == null) {
			status = RoleConstants.NO_DATA_STATUS;
			statusCode = RoleConstants.NO_DATA_STATUS_CODE;
			message = RoleConstants.GET_ALL_NO_DATA_MESSAGE;
		}			
		if(status == null) 
			status = RoleConstants.GET_ALL_ROLE_SUCCESS_STATUS;
		if(statusCode == null)
			statusCode = RoleConstants.GET_ALL_ROLE_SUCCESS_STATUS_CODE;
		if(message == null)
			message = RoleConstants.GET_ALL_ROLE_SUCCESS_MESSAGE;
		
		roleResponseListDto.setNotification(roleHelper.buildNotification(status, statusCode, message, ""));
		return roleResponseListDto;
	}

}
