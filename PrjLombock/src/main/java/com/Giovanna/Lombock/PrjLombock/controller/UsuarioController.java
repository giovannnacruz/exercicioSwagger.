package com.Giovanna.Lombock.PrjLombock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Giovanna.Lombock.PrjLombock.Services.UsuarioService;
import com.Giovanna.Lombock.PrjLombock.entities.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.TableGenerator;
import jakarta.validation.Valid;



@Tag(name="Usuarios",description= "API REST DE GERENCIAMENTO DE USUARIOS")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	

		private final UsuarioService usuarioService;

		@Autowired
		public UsuarioController(UsuarioService usuarioService) {
			this.usuarioService = usuarioService;
		}

		@GetMapping("/{id}")
		@Operation(summary="Localiza usuario por ID")
		public ResponseEntity<Usuario> findUsuariobyId(@PathVariable Long id) {
			Usuario usuario = usuarioService.findUsuarioById(id);
			if (usuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping ("/")
		@Operation(summary="Apresenta todos os usuarios")
		public ResponseEntity<List<Usuario>> findAllUsuarioscontrol() {
			List<Usuario> usuarios = usuarioService.findAllUsuario();
			return ResponseEntity.ok(usuarios);
		}

		@PostMapping("/")
		@Operation(summary="Cadastra um usuario")
		public ResponseEntity<Usuario> insertUsuariosControl(@RequestBody @Valid Usuario usuario) {
			Usuario novoUsuario = usuarioService.insertUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		}

		@PutMapping("/{id}")
		@Operation(summary="Altera um usuario")
		public ResponseEntity<Usuario> updateUsuarioControl(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
			Usuario mudausuario = usuarioService.updateUsuario(id, usuario);
			if (mudausuario != null) {
				return ResponseEntity.ok(usuario);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/id")
		@Operation(summary="Deleta um usuario")
		public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long id) {
			boolean remover = usuarioService.deleteUsuario(id);
			if (remover) {
				return ResponseEntity.ok().body("usuario Excluido com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	}
