package com.role.app.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {

	private ObjectMapper mapper = new ObjectMapper();
	private String sourcePath = "./src/test/resources/";
	public <T>T readData(String path, Class<T> targetClass) throws IOException {
		Path filePath = Paths.get(sourcePath+path);
		List<String> readAllLines = Files.readAllLines(filePath);
		StringBuilder builder = new StringBuilder();
		for (String str : readAllLines) {
			str = str.trim();
			if(str!= null && !str.isEmpty()) {
				builder.append(str);
			}
		}
		T response = mapper.readValue(builder.toString(), targetClass);
		return response;
	}
	
}
