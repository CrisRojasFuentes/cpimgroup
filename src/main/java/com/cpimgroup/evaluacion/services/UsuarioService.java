package com.cpimgroup.evaluacion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cpimgroup.evaluacion.dto.UsuarioResponseDTO;
import com.cpimgroup.evaluacion.models.TelefonoModel;
import com.cpimgroup.evaluacion.models.UsuarioModel;
import com.cpimgroup.evaluacion.repositories.IUsuarioRepository;

@Service
public class UsuarioService {
	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.cl$";

	@Value("${password.regex}")
	private String passwordRegex;
	
	
	@Autowired
	private IUsuarioRepository repository;
	
	@Autowired
	private TokenService tokenService;
	
	public UsuarioResponseDTO saveUsuario(UsuarioModel usuario) {
		
		if(!validaEmail(usuario.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\":\" El formato del correo no es válido. Debe ser 'usuario@dominio.cl'\"}");
		}
		
		if(!isValidPassword(usuario.getPassword())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "{\"mensaje\":\" La contraseña no cumple con el formato requerido.}\"");
		}
		
		Optional<UsuarioModel> usuarioExistente = repository.findByEmail(usuario.getEmail());
		
		if(usuarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo ya registrado");
		}
		
		usuario.setActive(true);
		usuario = repository.save(usuario);
		
		String token = tokenService.generateToken();
		return new UsuarioResponseDTO(usuario.getId(),usuario.getName(), usuario.getEmail(), usuario.getCreated(), usuario.getModified(), usuario.getLastLogin(), token, usuario.isActive());
	}
	
	private boolean isValidPassword(String password) {
		return Pattern.matches(passwordRegex, password);
	}
	
	private boolean validaEmail(String email) {
		return Pattern.matches(EMAIL_REGEX, email);
	}
	
	public List<UsuarioModel> getAllUsuario(){
		
		return repository.findAll();
	}
	
	public UsuarioResponseDTO getByIdUsuario(Long id) {
		Optional<UsuarioModel> usuOpt = repository.findById(id);
		
		if(usuOpt.isPresent()) {
			UsuarioModel usuario = usuOpt.get();
			
			String token = tokenService.generateToken();
			
			return new UsuarioResponseDTO(usuario.getId(),usuario.getName(), usuario.getEmail(), usuario.getCreated(), usuario.getModified(), usuario.getLastLogin(), token, usuario.isActive());
		}else {
			throw new RuntimeException("Usuario no encontrado");
		}
		
		
	}
	
	public UsuarioModel updateUsuario(UsuarioModel u) {
		UsuarioModel usu = repository.findById(u.getId()).get();
		usu.setEmail(u.getEmail());
		usu.setName(u.getName());
		usu.setPassword(u.getPassword());
		
		List<TelefonoModel> listaTelefono = new ArrayList<>();
		
//		for(TelefonoModel fono : u.getPhones()) {
//			TelefonoModel t = new TelefonoModel();
//			t.setCitycode(fono.getCitycode());
//			t.setContrycode(fono.getContrycode());
//			t.setNumber(fono.getNumber());
//			listaTelefono.add(t);	
//		}
		
		//usu.setPhones(listaTelefono);
		return repository.save(usu);
	}
	
	private void deleteUsuario(UsuarioModel u) {
		repository.delete(u);
	}
	
}