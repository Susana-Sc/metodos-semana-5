    package com.example;

    import java.time.LocalDate;

    import java.time.temporal.ChronoUnit;

    public class Prestamo {
        // Atributos: libro, usuario, fecha de préstamo, fecha de devolución prevista
        private Libro libro;
        private Usuario usuario;
        private int diasDevolución;
        private LocalDate fechaPrestamo;
        private LocalDate fechaDevolucionPrevista;
        private LocalDate fechaDevolucion;

        // Constructor(es)
        public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucionPrevista) {
            this.libro = libro;
            this.usuario = usuario;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucionPrevista = fechaDevolucionPrevista;
            this.fechaDevolucion = null;
            this.diasDevolución = 0;
        }
        

        // Métodos getter y setter
        public Libro getLibro() {
            return libro;
        }

        public void setLibro(Libro libro) {
            this.libro = libro;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public LocalDate getFechaPrestamo() {
            return fechaPrestamo;
        }

        public void setFechaPrestamo(LocalDate fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public LocalDate getFechaDevolucionPrevista() {
            return fechaDevolucionPrevista;
        }

        public void setFechaDevolucionPrevista(LocalDate fechaDevolucionPrevista) {
            this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        }

        // Método para calcular días de retraso

        public int calcularDiasRetraso(LocalDate fechaDevolucionReal) {
            // Lógica para calcular los días de retraso entre fechaDevolucionPrevista y
            // fechaDevolucionReal
            this.fechaDevolucion = fechaDevolucionReal;
            long dias = ChronoUnit.DAYS.between(fechaDevolucionPrevista, fechaDevolucion);
            this.diasDevolución = (int) Math.max(dias, 0); 
            return this.diasDevolución;
        }

        // Método toString() para mostrar información del préstamo
        @Override
        public String toString() {
            return "Prestamo{" +
                    "libro='" + libro + '\'' +
                    ", usuario='" + usuario + '\'' +
                    ", fechaPrestamo='" + fechaPrestamo + '\'' +
                    ", fechaDevolucionPrevista='" + fechaDevolucionPrevista + '\'' +
                    ", fechaDevolucionReal=" + (fechaDevolucion != null ? fechaDevolucion : "Aún no devuelto") + '\'' +
                    ", diasRetraso=" + diasDevolución +
                    '}';
        }
    }
