package com.role.app.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.role.app.domain.Notification;

@ExtendWith(MockitoExtension.class)
class RoleHelperTest {
	@InjectMocks
	private RoleHelper roleHelper;
	@Mock
	private ModelMapper mapper;
	

	@Test
	void testBuildNotification() {
		Notification notification = roleHelper.buildNotification("SUCCESS", null, null, null);
		assertEquals("SUCCESS", notification.getStatus());
	}
	
	@Test
	void testConvertToTargetObject() throws JsonMappingException, JsonProcessingException {
		Notification notification = new Notification();
		notification.setMessage("Mock message");
		notification.setPath("/path");
		notification.setStatus("SUCCESS");
		notification.setStatusCode(200);
		LocalTime localTime = LocalTime.now();
		notification.setTime(localTime);
		when(mapper.map(notification, Notification.class)).thenReturn(notification);
		Notification targetObject = roleHelper.convertToTargetObject(Notification.class, notification);
		assertEquals("SUCCESS", targetObject.getStatus());
		assertEquals("Mock message", targetObject.getMessage());
		assertEquals("/path", targetObject.getPath());
		assertEquals(200, targetObject.getStatusCode());
		assertEquals(localTime, targetObject.getTime());
	}

}
