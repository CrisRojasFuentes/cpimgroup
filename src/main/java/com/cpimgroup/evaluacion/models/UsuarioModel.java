package com.cpimgroup.evaluacion.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class UsuarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String password;
	
	@Column(name = "created", updatable = false)
	private LocalDateTime created;
	
	@Column(name = "modified")
	private LocalDateTime modified;
	
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	
	private boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<TelefonoModel> phones = new ArrayList<>();
	
	public void addPhone(TelefonoModel t) {
		phones.add(t);
		t.setUsuario(this);
	}
	
	@PrePersist
	protected void onCreate() {
		if(created == null) {
			created = LocalDateTime.now();
		}
		if(lastLogin == null) {
			lastLogin = created;
		}
		modified = created;
	}
	
	@PreUpdate
	protected void onUpdate() {
		modified = LocalDateTime.now();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<TelefonoModel> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoModel> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", created=" + created + ", modified=" + modified + ", lastLogin=" + lastLogin + ", isActive="
				+ isActive + ", phones=" + phones + "]";
	}

	
	
	
	

	
}
