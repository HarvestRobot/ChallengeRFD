package com.challengeRFD.model;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Represents a row of the table packagedata of the DB
 */
@Entity
@Table (name = "packagedata")
public class PackageData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRow;
    private int idPackage;
    private String idVehicle;
    private String location;
    private String latitude;
    private String longitude;
    private Timestamp timestamp;

    public PackageData(){

    }

    public PackageData(int idPackage, String idVehicle, String location, String latitude, String longitude){
        this.idPackage = idPackage;
        this.idVehicle = idVehicle;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdRow() {
        return idRow;
    }

    public int getIdPackage() {
        return idPackage;
    }

    public String getLocation() {
        return location;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp){
        this.timestamp = timestamp;
    }

    public String toString(){
        return "Objeto: " +
                "idRow = " +getIdRow()+", " +
                "idPackage = "+getIdPackage()+", " +
                "idVehicle = "+getIdVehicle()+", " +
                "location = "+getLocation()+", " +
                "latitude = "+getLatitude()+", "+
                "longitude = "+getLongitude()+", "+
                "timestamp = "+getTimestamp();
    }
}
