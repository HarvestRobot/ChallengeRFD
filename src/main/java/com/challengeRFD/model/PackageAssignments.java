package com.challengeRFD.model;

import javax.persistence.*;

@Entity
@Table(name = "packageassignments")
public class PackageAssignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPackage;
    private String idVehicle;

    public PackageAssignments(){

    }

    public long getIdPackage() {
        return idPackage;
    }

    public String getIdVehicle() {
        return idVehicle;
    }
}
