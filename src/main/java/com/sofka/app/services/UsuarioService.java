package com.sofka.app.services;

import com.sofka.app.models.UsuarioModel;
import com.sofka.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

@Service // Se establece que es un sevicio
public class UsuarioService {
    @Autowired // Instancia automáticamente usuarioService
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> listarUsuariosPorID() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public ArrayList<UsuarioModel> listarUsuariosPorNombre() {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        Collections.sort(usuarios, new Comparator<UsuarioModel>() {
            public int compare(UsuarioModel usuario1, UsuarioModel usuario2) {
                return usuario1.getNombre().toLowerCase().compareTo(usuario2.getNombre().toLowerCase());
            }
        });
        return usuarios;
    }

    public ArrayList<UsuarioModel> listarUsuariosPorPrioridad() {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        Collections.sort(usuarios, new Comparator<UsuarioModel>() {
            public int compare(UsuarioModel usuario1, UsuarioModel usuario2) {
                return usuario1.getPrioridad().compareTo(usuario2.getPrioridad());
            }
        });
        return usuarios;
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }


    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuario) {
        Optional<UsuarioModel> oldUsuario = usuarioRepository.findById(id);

        if (oldUsuario.isPresent()) {
            usuario.setId(id);
            usuario.setNombre(usuario.getNombre() == null ? oldUsuario.get().getNombre() : usuario.getNombre());
            usuario.setEmail(usuario.getEmail() == null ? oldUsuario.get().getEmail() : usuario.getEmail());
            usuario.setPrioridad(usuario.getPrioridad() == null ? oldUsuario.get().getPrioridad() : usuario.getPrioridad());
            return usuarioRepository.save(usuario);
        } else return usuario;
    }
}