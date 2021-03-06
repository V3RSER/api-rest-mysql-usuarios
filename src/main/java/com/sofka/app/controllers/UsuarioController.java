package com.sofka.app.controllers;

import com.sofka.app.models.UsuarioModel;
import com.sofka.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController // Se establece que es un controlador
@RequestMapping("/usuario") // Dirección del servidor donde se pueden usar los métodos de la clase
public class UsuarioController {
    @Autowired // Instancia automáticamente usuarioService
    UsuarioService usuarioService;

    @GetMapping("/listar/id") // Cuando llegue una petición GET
    public ArrayList<UsuarioModel> listarUsuariosPorID() {
        return usuarioService.listarUsuariosPorID();
    }

    @GetMapping("/listar/nombre")
    public ArrayList<UsuarioModel> listarUsuariosPorNombre() {
        return usuarioService.listarUsuariosPorNombre();
    }

    @GetMapping("/listar/prioridad")
    public ArrayList<UsuarioModel> listarUsuariosPorPrioridad() {
        return usuarioService.listarUsuariosPorPrioridad();
    }

    @PostMapping("/guardar") // Cuando llegue una petición POST
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/consulta")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping("/eliminar/{id}") // Cuando llegue una petición DELETE
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @PutMapping("actualizar/{id}") // Cuando llegue una petición PUT
    public UsuarioModel actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

}