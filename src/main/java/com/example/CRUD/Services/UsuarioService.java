package com.example.CRUD.Services;

import com.example.CRUD.Model.Usuario;
import com.example.CRUD.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Repositório para interagir com o banco de dados

    public boolean autenticar(String cpf, String senha) {
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));;
        return usuario != null; //&& usuario.getSenha().equals(senha);
    }
}
