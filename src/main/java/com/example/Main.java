package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ------------- Crear un libro
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "978-0618640157", 1954, true);
        Libro libro2 = new Libro("El principito", "Antoine de Saint-Exupéry", "654321", 1943, true);
        Libro libro3 = new Libro("1984", "George Orwell", "123456", 1949, true);

        // ------------- Crear un usuario
        Usuario usuario1 = new Usuario(1, "Juan Pérez", "juan@example.com");
        // ------------------------- Agregar un libro al usuario
        usuario1.agregarPrestamo("El Principito");
        usuario1.agregarPrestamo("1984");
        usuario1.agregarPrestamo("Cien años de soledad");

        // ------------- Crear un préstamo
        Usuario usuarioo = new Usuario(1, "Berlin", "berlin@example.com");
        Libro libross = new Libro("Harry Potter", "J.K", "978-0618640157", 1954, true);

        Prestamo prestamo1 = new Prestamo(libro1, usuario1, LocalDate.now(), LocalDate.now().plusDays(14));

        // ------------- Crear una biblioteca
        // Inicializar listas
        List<Libro> libros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Prestamo> prestamos = new ArrayList<>();
        // Crear instancia
        Biblioteca biblioteca = new Biblioteca(libros, usuarios, prestamos);
        // Agregar libro y usuario a la biblioteca
        // Usuarios
        Usuario usuario2 = new Usuario(2, "Ana Gómez", "ana@example.com");
        Usuario usuario3 = new Usuario(1, "Carlos Pérez", "carlos@example.com");

        // -------------------------- Crear una biblioteca
        System.out.println("----------------------- Información de la biblioteca: ----------------------------");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Registrar usuarios

        biblioteca.registrarUsuario(usuario2);
        biblioteca.registrarUsuario(usuario3);

        // Realiza el préstamo usando el método de la biblioteca
        biblioteca.realizarPrestamo(usuario1, libro1);
        biblioteca.realizarPrestamo(usuario2, libro2);
        biblioteca.realizarPrestamo(usuario3, libro3);
        biblioteca.realizarPrestamo(usuarioo, libross);

        // Simular una devolución con retraso
        LocalDate fechaDevolucionReal = LocalDate.now().plusDays(16); // Devuelto con 2 días de retraso
        List<Prestamo> prestamosUsuario = biblioteca.consultarPrestamos(usuario1);
        if (!prestamosUsuario.isEmpty()) {
            Prestamo prestamoUsuario = prestamosUsuario.get(0);
            int diasRet = prestamoUsuario.calcularDiasRetraso(fechaDevolucionReal);
            System.out.println("Días de retraso: " + diasRet);
        } else {
            System.out.println("El usuario no tiene préstamos registrados.");
        }

        // ----------------- Buscar libros en la biblioteca -----------------
        System.out.println("----------------------- Búsqueda de libros ----------------------------");

        // Buscar un libro por título
        String tituloBuscado = "1984";
        List<Libro> librosPorTitulo = biblioteca.buscarLibro(tituloBuscado);

        if (!librosPorTitulo.isEmpty()) {
            System.out.println("Libros encontrados con título '" + tituloBuscado + "':");
            for (Libro libro : librosPorTitulo) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No se encontraron libros con el título '" + tituloBuscado + "'.");
        }

        // Buscar libros por autor
        String autorBuscado = "George Orwell";
        List<Libro> librosPorAutor = biblioteca.buscarLibroPorAutor(autorBuscado);

        if (!librosPorAutor.isEmpty()) {
            System.out.println("Libros encontrados del autor '" + autorBuscado + "':");
            for (Libro libro : librosPorAutor) {
                System.out.println(libro);
            }
        } else {
            System.out.println("No se encontraron libros del autor '" + autorBuscado + "'.");
        }

        // ----------------- Consultar préstamos de un usuario -----------------
        System.out.println("----------------------- Préstamos de un usuario ----------------------------");

        // Consultar los préstamos de un usuario
        List<Prestamo> prestamosDeUsuario = biblioteca.consultarPrestamos(usuario1);

        if (!prestamosDeUsuario.isEmpty()) {
            System.out.println("Préstamos activos de " + usuario1.getNombre() + ":");
            for (Prestamo prestamo : prestamosDeUsuario) {
                System.out.println(prestamo);
            }
        } else {
            System.out.println("No hay préstamos activos para " + usuario1.getNombre() + ".");
        }

        System.out.println("----------------------- Devoluciones ----------------------------");
        // Registrar la devolución
        biblioteca.registrarDevolucion(usuario1, libro1);
        biblioteca.registrarDevolucion(usuario2, libro2);
        biblioteca.registrarDevolucion(usuario3, libro3);
        biblioteca.registrarDevolucion(usuarioo, libross);

        // Generar un informe de la biblioteca
        biblioteca.generarInforme();

        // ------------------------- Crear un libro
        System.out.println("----------------------- Información del libro: ----------------------------");

        // Mostrar información inicial
        System.out.println(libro1);

        // Intentar prestarlo
        libro1.marcarComoPrestado();
        System.out.println(libro1); // Debe mostrar disponible = No

        // Intentar prestarlo de nuevo (debe decir que no está disponible)
        libro1.marcarComoPrestado();

        // Devolver el libro
        libro1.marcarComoDisponible();
        System.out.println(libro1); // Debe mostrar disponible = Sí

        // ------------------------- Crear un usuario
        System.out.println("----------------- Información del usuario: -----------------------------");

        // Mostrar información del usuario
        System.out.println(usuario1);

        // Eliminar un préstamo
        usuario1.eliminarPrestamo("1984");

        // Mostrar información después de eliminar
        System.out.println("Estado después de eliminar un préstamo:");
        System.out.println(usuario1);

        // -------------------------- Crear un préstamo
        System.out.println("----------------------- Información del préstamo: ----------------------------");

        // Mostrar información del préstamo
        System.out.println(prestamo1);
        // Calcular días de retraso
        LocalDate fechaDevolucion = LocalDate.of(2025, 03, 10);
        int diasRetraso = prestamo1.calcularDiasRetraso(fechaDevolucion);
        System.out.println("Días de retraso: " + diasRetraso);
        // Mostrar información del préstamo después de la devolución
        System.out.println("Información del préstamo después de la devolución:");
        System.out.println(prestamo1);

    }
}
