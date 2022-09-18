package com.role.app.constants;

import org.springframework.http.HttpStatus;

public class RoleConstants {
	private RoleConstants() {}
	public static final String GET_ONE_ROLE_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer GET_ONE_ROLE_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String GET_ONE_ROLE_SUCCESS_MESSAGE = "Retrived role for ";	
	
	public static final String GET_ALL_ROLE_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer GET_ALL_ROLE_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String GET_ALL_ROLE_SUCCESS_MESSAGE = "Roles retirved successfully";
	
	public static final String NO_DATA_STATUS = HttpStatus.NO_CONTENT.getReasonPhrase();
	public static final Integer NO_DATA_STATUS_CODE =HttpStatus.NO_CONTENT.value();
	public static final String NO_DATA_MESSAGE = "No data found for the role ";
	public static final String GET_ALL_NO_DATA_MESSAGE = "No data found";
	
	
	public static final String DELETE_ROLE_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer DELETE_ROLE_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String DELETE_ROLE_SUCCESS_MESSAGE = "Role deleted successfully for the role ";
	
	public static final String UPDATE_ROLE_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer UPDATE_ROLE_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String UPDATE_ROLE_SUCCESS_MESSAGE = "Role update successfully for the role ";
	
	public static final String ADD_ROLE_SUCCESS_STATUS = HttpStatus.CREATED.getReasonPhrase();
	public static final Integer ADD_ROLE_SUCCESS_STATUS_CODE = HttpStatus.CREATED.value();
	public static final String ADD_ROLE_SUCCESS_MESSAGE = "Role add successfully";
	
	public static final String DATA_EXIST_STATUS = HttpStatus.FOUND.getReasonPhrase();
	public static final Integer DATA_EXIST_STATUS_CODE =HttpStatus.FOUND.value();
	public static final String DATA_EXIST_MESSAGE = "Role already existing with role ";
}
