package com.sofka.app.models;

import javax.persistence.*;

@Entity // Se establece que es un modelo
@Table(name = "usuario") // Se establece que la tabla asociada al modelo tenga el nombre usuario
public class UsuarioModel {

    @Id // Le dice a la DB que este atributo es un identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Vuelve al identificador autoincrementable
    @Column(unique = true, nullable = false) // Establece que tiene que ser único y no puede ser nulo
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}