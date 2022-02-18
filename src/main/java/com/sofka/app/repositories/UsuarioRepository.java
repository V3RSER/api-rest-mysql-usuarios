package com.sofka.app.repositories;

import com.sofka.app.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Se establece que es un repositorio
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}