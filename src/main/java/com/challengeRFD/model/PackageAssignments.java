package com.challengeRFD.model;

import javax.persistence.*;

@Entity
@Table(name = "packageassignments")
public class PackageAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRow;
    private int idPackage;
    private String idVehicle;

    public PackageAssignments(){

    }

    public PackageAssignments(int idPackage, String idVehicle){
        this.idPackage = idPackage;
        this.idVehicle = idVehicle;
    }

    public int getIdPackage() { return idPackage; }

    public String getIdVehicle() { return idVehicle;  }

    public int getIdRow() { return idRow; }

    public String toString(){
        return "idRow = "+getIdRow()+", "+
                "idPackage = "+getIdPackage()+", "+
                "idVehicle = "+getIdVehicle();
    }
}
