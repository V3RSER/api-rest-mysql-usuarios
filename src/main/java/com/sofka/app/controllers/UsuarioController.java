package com.sofka.app.controllers;

import com.sofka.app.models.UsuarioModel;
import com.sofka.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // Se establece que es un controlador
@RequestMapping("/usuario") // Dirección del servidor donde se pueden usar los métodos de la clase
public class UsuarioController {
    @Autowired // Instancia automáticamente usuarioService
    UsuarioService usuarioService;

    @GetMapping() // Cuando llegue una petición GET
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping() // Cuando llegue una petición POST
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }
}