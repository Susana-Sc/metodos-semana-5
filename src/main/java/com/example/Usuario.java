package com.example;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos: id, nombre, email, lista de préstamos actuales
    private int id;
    private String nombre;
    private String email;
    private List<String> listaPrestamosActuales;

    // Constructor(es)
    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.listaPrestamosActuales = new ArrayList<>();
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<String> getListaPrestamosActuales() {
        return listaPrestamosActuales;
    }

    // Método para agregar un préstamo a la lista
    public void agregarPrestamo(String prestamo){
        listaPrestamosActuales.add(prestamo);
    }

    // Método para eliminar un préstamo de la lista
    public void eliminarPrestamo(String prestamo){
        listaPrestamosActuales.remove(prestamo);
    }

    // Método toString() para mostrar información del usuario
    @Override
    public String toString(){
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", listaPrestamosActuales=" + listaPrestamosActuales +
                '}';
    }
}