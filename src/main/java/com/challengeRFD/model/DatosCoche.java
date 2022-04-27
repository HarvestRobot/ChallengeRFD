package com.challengeRFD.model;

import java.util.Date;

public class DatosCoche {
    private final int idPedido;
    private final String idCoche;
    private final String ubicacion;
    private final String latitud;
    private final String longitud;
    private final String timestamp;

    public DatosCoche(int idPedido, String idCoche, String ubicacion, String latitud, String longitud, String timestamp) {
        this.idPedido = idPedido;
        this.idCoche = idCoche;
        this.ubicacion = ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.timestamp = timestamp;
    }

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
