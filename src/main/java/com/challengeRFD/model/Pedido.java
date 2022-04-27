package com.challengeRFD.model;


public class Pedido {
    private final long idPedido;
    private final String idCoche;

    public Pedido(long idPedido, String idCoche) {
        this.idPedido = idPedido;
        this.idCoche = idCoche;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public String getIdCoche() {
        return idCoche;
    }
}
