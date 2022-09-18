package com.role.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role.app.constants.PathConstants;
import com.role.app.domain.RoleFinalResponseDto;
import com.role.app.domain.RoleRequestDto;
import com.role.app.domain.RoleResponseListDto;
import com.role.app.service.RoleService;

@RestController
@RequestMapping(PathConstants.ROOT_LEVEL_PATH)
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public ResponseEntity<RoleResponseListDto> addRole(@Valid @RequestBody RoleRequestDto roleRequestDto) {
		return new ResponseEntity<>(roleService.addRole(roleRequestDto), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<RoleResponseListDto> updateRole(@Valid @RequestBody RoleRequestDto roleRequestDto) {
		return new ResponseEntity<>(roleService.updateRole(roleRequestDto), HttpStatus.OK);
	}

	@DeleteMapping(PathConstants.PATH_VARIABLE)
	public ResponseEntity<RoleResponseListDto> deleteRole(@PathVariable("role-code") String roleCode) {
		return new ResponseEntity<>(roleService.deleteRole(roleCode), HttpStatus.OK);
	}

	@GetMapping(PathConstants.PATH_VARIABLE)
	public ResponseEntity<RoleFinalResponseDto> getRole(@PathVariable("role-code") String roleCode) {
		return new ResponseEntity<>(roleService.getRole(roleCode), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<RoleResponseListDto> getRoles() {
		return new ResponseEntity<>(roleService.getRoles(null, null, null), HttpStatus.OK);
	}

}
