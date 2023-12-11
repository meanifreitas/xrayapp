package com.example.CRUD.Services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.CRUD.Repository.UsuarioRepository;
import com.example.CRUD.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String cpf, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isPresent()) {
            return usuario.get().getSenha().equals(senha);
        }
        return false;
    }
}
