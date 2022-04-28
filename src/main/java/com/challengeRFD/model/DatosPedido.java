package com.challengeRFD.model;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table (name = "localizaciones")
public class DatosPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private String idCoche;
    private String ubicacion;
    private String latitud;
    private String longitud;
    private String timestamp;

    protected DatosPedido(){

    }
    /*public DatosPedido(int idPedido, String idCoche, String ubicacion, String latitud, String longitud, String timestamp) {
        this.idPedido = idPedido;
        this.idCoche = idCoche;
        this.ubicacion = ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.timestamp = timestamp;
    }*/

    public int getIdPedido() {
        return idPedido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
