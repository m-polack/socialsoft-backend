package pe.edu.pucp.socialsoft.model.canales;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDate;

public class Canal {
    private int id;
    private String nombre;
    private String descripcion;
    private int numero_seguidores;
    private String categoria;
    private LocalDate fecha_creacion;

    @JsonbDateFormat("yyyy-MM-dd")
    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero_seguidores() {
        return numero_seguidores;
    }

    public void setNumero_seguidores(int numero_seguidores) {
        this.numero_seguidores = numero_seguidores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
