package com.example.tarea4recyclerview.Modelos;

public class Restaurantes {
    private String id;
    private String nombre;
    private String horarios;
    private String telefono;
    private String direccion;
    private String categoria;
    private String foto;

    public Restaurantes(){

    }

    public Restaurantes(String id, String nombre, String horarios, String telefono, String direccion, String categoria, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.horarios = horarios;
        this.telefono = telefono;
        this.direccion = direccion;
        this.categoria = categoria;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
