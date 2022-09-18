package com.role.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.role.app.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer>{
	
	RoleEntity findByRoleCode(String roleCode);

}
