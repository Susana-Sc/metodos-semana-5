package com.example;

public class Libro {
    // Atributos: título, autor, ISBN, año de publicación, disponible (boolean)
    private String titulo;
    private String autor;
    private String ISBN;
    private int anioPublicacion;
    private boolean disponible;

    // Constructor(es)
    public Libro(String titulo, String autor, String iSBN, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        ISBN = iSBN;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    // Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método para marcar como prestado
    public void marcarComoPrestado() {
        if (!disponible) {
            System.out.println("El libro no está disponible");
        } else {
            disponible = false;
            System.out.println("El libro ha sido prestado");
        }
    }

    // Método para marcar como disponible
    public void marcarComoDisponible() {
        if (disponible) {
            System.out.println("El libro ya está disponible");
        } else {
            disponible = true;
            System.out.println("El libro ahora está disponible");
        }
    }

    // Método toString() para mostrar información del libro
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +    
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", disponible=" + (disponible ? "Sí" : "No") +
                '}';
    }
}
