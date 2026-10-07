package pe.edu.pucp.socialsoft.model.solicitudes;

import pe.edu.pucp.socialsoft.model.planes.PlanSuscripcion;
import pe.edu.pucp.socialsoft.model.canales.Canal;
import pe.edu.pucp.socialsoft.model.usuarios.Usuario;

import java.time.LocalDateTime;

public class UsuarioCanalSuscripcion {

    private int id;
    private Usuario usuario;
    private Canal canal;
    private PlanSuscripcion planSuscripcion;

    //@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss") -> solo en caso la base de datos no lo calculara automáticamente
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    private LocalDateTime fechaRegistro;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public PlanSuscripcion getPlanSuscripcion() {
        return planSuscripcion;
    }

    public void setPlanSuscripcion(PlanSuscripcion planSuscripcion) {
        this.planSuscripcion = planSuscripcion;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}