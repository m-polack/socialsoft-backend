package pe.edu.pucp.socialsoft.model.planes;


import java.util.List;

public class PlanSuscripcion {
    private int id;
    private String nombre;
    private double costoMensual;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(double costoMensual) {
        this.costoMensual = costoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}