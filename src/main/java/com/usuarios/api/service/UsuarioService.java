package com.usuarios.api.service;

import com.usuarios.api.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto createUsuario(UsuarioDto usuarioDto);

    UsuarioDto getUsuarioById(Long usuarioId);

    List<UsuarioDto> getAllUsuarios();

    UsuarioDto updateUsuario(Long usuarioId, UsuarioDto updatedUsuario);

    void deleteUsuario(Long usuarioId);
}