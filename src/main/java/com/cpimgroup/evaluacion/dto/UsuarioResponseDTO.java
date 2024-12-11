package com.cpimgroup.evaluacion.dto;

import java.time.LocalDateTime;

public class UsuarioResponseDTO {

	private Long id;
	private String name;
	private String email;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime lastLogin;
	private String token;
	private boolean isActive;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public UsuarioResponseDTO(Long id, String name, String email, LocalDateTime created, LocalDateTime modified,
			LocalDateTime lastLogin, String token, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}
	
	
	
}
