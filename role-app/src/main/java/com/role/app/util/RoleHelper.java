package com.role.app.util;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.role.app.domain.Notification;

@Service
public class RoleHelper {
	@Autowired
	private ModelMapper mapper;
	
	public <T> T convertToTargetObject(Class<T> targetClass, Object obj) {
		return mapper.map(obj, targetClass);
	}
	
	public Notification buildNotification(String status, Integer statusCode, String message, String path) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setPath(path);
		notification.setStatus(status);
		notification.setStatusCode(statusCode);
		notification.setTime(LocalTime.now());
		return notification;
	}
}
