package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos: lista de libros, lista de usuarios, lista de préstamos
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;
    private List<Prestamo> listaPrestamos;

    // Constructor: inicializa las listas vacías
    public Biblioteca(List<Libro> listaLibros, List<Usuario> listaUsuarios, List<Prestamo> listaPrestamos) {
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
    }

    // Método para agregar un libro al inventario (sobrecarga)
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void agregarLibro(String titulo, String autor, String ISBN, int anioPublicacion, boolean disponible) {
        listaLibros.add(new Libro(titulo, autor, ISBN, anioPublicacion, disponible));
        System.out.println("Libro agregado: " + titulo);
    }

    // Método para registrar un usuario (sobrecarga)
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public void registrarUsuario(int id, String nombre, String email) {
        listaUsuarios.add(new Usuario(id, nombre, email));
        System.out.println("Usuario registrado: " + nombre);
    }

    // Método para realizar un préstamo

    public void realizarPrestamo(Usuario usuario, Libro libro) {
        if (!libro.isDisponible()) {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible.");
            return;
        }

        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucionPrevista = fechaPrestamo.plusDays(14);

        // Usa los objetos Libro y Usuario directamente
        Prestamo prestamo = new Prestamo(libro, usuario, fechaPrestamo, fechaDevolucionPrevista);
        listaPrestamos.add(prestamo); // Aquí sí se agrega a la lista
        libro.setDisponible(false); // También hay que marcarlo como no disponible
        System.out.println("Préstamo registrado: " + libro.getTitulo() + " → " + usuario.getNombre());
    }

    // Método para registrar una devolución
    public void registrarDevolucion(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario) && prestamo.getLibro().equals(libro)) {
                libro.setDisponible(true);
                listaPrestamos.remove(prestamo);
                System.out.println("Devolución registrada: " + libro.getTitulo() + " por " + usuario.getNombre());
                return;
            }
        }
        System.out.println("No se encontró un préstamo activo de este libro para este usuario.");
    }

    // Método para buscar libros (sobrecarga para diferentes criterios)
    public List<Libro> buscarLibro(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    // Método para consultar préstamos de un usuario
    public List<Prestamo> consultarPrestamos(Usuario usuario) {
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario;
    }

    // Método para generar informes
    public void generarInforme() {
        System.out.println("------------------ INFORME DE LA BIBLIOTECA --------------------");
        System.out.println("Total de libros: " + listaLibros.size());
        System.out.println("Total de usuarios: " + listaUsuarios.size());
        System.out.println("Total de préstamos activos: " + listaPrestamos.size());
    }

}
