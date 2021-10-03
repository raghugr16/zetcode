package org.raghu.opensource.entity;

import org.springframework.web.multipart.MultipartFile;

public class Employee {
	
	private String name;
	private MultipartFile multipartFile;
	
	public Employee() {
	}

	public Employee(String name, MultipartFile multipartFile) {
		super();
		this.name = name;
		this.multipartFile = multipartFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
}
