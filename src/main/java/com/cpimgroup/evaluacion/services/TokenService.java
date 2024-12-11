package com.cpimgroup.evaluacion.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

	public String generateToken() {
		return UUID.randomUUID().toString();
	}
	
}
