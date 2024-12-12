package com.cpimgroup.evaluacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cpimgroup.evaluacion.dto.UsuarioResponseDTO;
import com.cpimgroup.evaluacion.models.UsuarioModel;
import com.cpimgroup.evaluacion.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/")
	public ResponseEntity<List<UsuarioModel>> getAll() {
		List<UsuarioModel> lista = service.getAllUsuario();
		if(lista == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UsuarioModel>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> obtenerPorId(@PathVariable Long id){
		try {
			UsuarioResponseDTO dto = service.getByIdUsuario(id);
			return ResponseEntity.ok(dto);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<UsuarioResponseDTO> save(@RequestBody UsuarioModel u) {
		UsuarioResponseDTO usu = service.saveUsuario(u);
		if(usu == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UsuarioResponseDTO>(usu, HttpStatus.CREATED);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleEmailExists(ResponseStatusException ex) {
		return ex.getReason();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> update(@RequestBody UsuarioModel u) {
		UsuarioModel usu = service.updateUsuario(u);
		if(usu == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UsuarioModel>(usu, HttpStatus.CREATED);
	}
	
}
