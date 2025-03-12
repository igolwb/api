package com.usuarios.api.controller;

import com.usuarios.api.dto.UsuarioDto;
import com.usuarios.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioSalvo = usuarioService.createUsuario(usuarioDto);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") Long usuarioId){
        UsuarioDto usuarioDto = usuarioService.getUsuarioById(usuarioId);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios(){
        List<UsuarioDto> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable("id") Long usuarioId, @RequestBody UsuarioDto updatedUsuario){
        UsuarioDto usuarioDto = usuarioService.updateUsuario(usuarioId, updatedUsuario);
        return ResponseEntity.ok(usuarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long usuarioId){
        usuarioService.deleteUsuario(usuarioId);
        return ResponseEntity.ok("usuario deletado com sucesso");
    }

}
