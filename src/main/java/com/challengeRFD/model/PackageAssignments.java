package com.challengeRFD.model;

import javax.persistence.*;

@Entity
@Table(name = "packageassignments")
public class PackageAssignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long idPedido;
    private final String idCoche;

    public PackageAssignments(long idPedido, String idCoche) {

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
