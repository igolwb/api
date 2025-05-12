package com.usuarios.api.service.impl;

import com.usuarios.api.dto.UsuarioDto;
import com.usuarios.api.entity.Usuario;
import com.usuarios.api.exception.ResuorceNotFoundException;
import com.usuarios.api.mapper.UsuarioMapper;
import com.usuarios.api.repository.UsuarioRepository;
import com.usuarios.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    @Override
    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = UsuarioMapper.maptoUsuario(usuarioDto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return UsuarioMapper.maptoUsuarioDto(usuarioSalvo);
    }

    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResuorceNotFoundException("este usuario não existe: " + usuarioId));
        return UsuarioMapper.maptoUsuarioDto(usuario);
    }

    @Override
    public List<UsuarioDto> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map((usuario) ->  UsuarioMapper.maptoUsuarioDto(usuario)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto updateUsuario(Long usuarioId, UsuarioDto updatedUsuario) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResuorceNotFoundException("usuario não encontrado:" + usuarioId)
        );

        usuario.setFirstName(updatedUsuario.getFirstName());
        usuario.setLastName(updatedUsuario.getLastName());
        usuario.setEmail(updatedUsuario.getEmail());

        Usuario updatedUsuarioObj = usuarioRepository.save(usuario);
        return UsuarioMapper.maptoUsuarioDto(updatedUsuarioObj);
    }

    @Override
    public void deleteUsuario(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResuorceNotFoundException("usuario não encontrado:" + usuarioId)
        );

        usuarioRepository.deleteById(usuarioId);
    }
}
