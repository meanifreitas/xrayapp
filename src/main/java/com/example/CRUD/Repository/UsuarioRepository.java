package com.example.CRUD.Repository;

import com.example.CRUD.Model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, Integer> {

}