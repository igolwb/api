package com.usuarios.api.mapper;

import com.usuarios.api.dto.UsuarioDto;
import com.usuarios.api.entity.Usuario;

public class UsuarioMapper {
    public static UsuarioDto maptoUsuarioDto(Usuario usuario){
        return new UsuarioDto(
                usuario.getId(),
                usuario.getFirstName(),
                usuario.getLastName(),
                usuario.getEmail()
        );
    }

    public static Usuario maptoUsuario(UsuarioDto usuarioDto){
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getFirstName(),
                usuarioDto.getLastName(),
                usuarioDto.getEmail()
        );
    }
}
