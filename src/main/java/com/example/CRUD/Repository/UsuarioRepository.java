package com.example.CRUD.Repository;

import com.example.CRUD.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository <Usuario, Integer> {
    Optional<Usuario> findByCpf(String cpf);

}