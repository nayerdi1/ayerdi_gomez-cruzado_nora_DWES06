package daw.dwes._6.exceptions;

import java.time.LocalDateTime;

public class ApiError {
    private LocalDateTime hora;
    private int status;
    private String mensaje;
    private String error;

    public ApiError(LocalDateTime hora, int status, String mensaje, String error) {
        this.hora = hora;
        this.status = status;
        this.mensaje = mensaje;
        this.error = error;
    }

    // Getters y setters
    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}