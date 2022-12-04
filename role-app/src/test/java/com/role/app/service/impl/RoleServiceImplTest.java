package com.role.app.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.role.app.common.CommonUtil;
import com.role.app.domain.RoleRequestDto;
import com.role.app.entity.RoleEntity;
import com.role.app.repo.RoleRepo;
import com.role.app.util.RoleHelper;


@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {
	
	@InjectMocks
	RoleServiceImpl roleServiceImpl;
	@Mock
	private RoleRepo roleRepo; 
	@Mock
	private RoleHelper roleHelper;
	
	CommonUtil helper = new CommonUtil();
	
	
	@Test
	void testAddRole_RoleEntity_Null() throws IOException {		
		RoleRequestDto roleRequestDto = helper.readData("addRoleRequestDto.json", RoleRequestDto.class);
		RoleEntity roleEntity = getRoleEntity(roleRequestDto);
		when(roleRepo.findByRoleCode(roleRequestDto.getRoleCode())).thenReturn(null);
		when(roleHelper.convertToTargetObject(RoleEntity.class, roleRequestDto)).thenReturn(roleEntity);
		roleEntity.setRoleId(123);
		when(roleRepo.save(roleEntity)).thenReturn(roleEntity);
		//roleServiceImpl.addRole(roleRequestDto);
	}
	
	
	
	private RoleEntity getRoleEntity(RoleRequestDto roleRequestDto) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRoleCode(roleRequestDto.getRoleCode());
		roleEntity.setRoleDesc(roleRequestDto.getRoleDesc());
		roleEntity.setRoleName(roleRequestDto.getRoleName());
		return roleEntity;
	}

}
