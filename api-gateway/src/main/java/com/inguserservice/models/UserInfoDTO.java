package com.inguserservice.models;

public class UserInfoDTO {
	
	private Long userId;
	private String userRole;
	
	
	public UserInfoDTO(Long userId,String userRole) {
		this.userId = userId;
		this.userRole = userRole;
		
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserRole() {
		return userRole;
	}

	

	
	
}
