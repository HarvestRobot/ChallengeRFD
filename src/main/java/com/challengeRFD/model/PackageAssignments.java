package com.challengeRFD.model;

import javax.persistence.*;

@Entity
@Table(name = "packageassignments")
public class PackageAssignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;
    private String idCoche;

    public PackageAssignments(){

    }

    public long getIdPedido() {
        return idPedido;
    }

    public String getIdCoche() {
        return idCoche;
    }
}
