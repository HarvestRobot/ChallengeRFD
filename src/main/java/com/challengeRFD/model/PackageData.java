package com.challengeRFD.model;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Table (name = "packagedata")
public class PackageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPackage;
    private String idVehicle;
    private String location;
    private String latitude;
    private String longitude;
    private String timestamp;

    public PackageData(){

    }
    public PackageData(int idPackage, String idVehicle, String location, String latitude, String longitude, String timestamp) {
        this.idPackage = idPackage;
        this.idVehicle = idVehicle;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setIdPackage(int idPackage){
        this.idPackage = idPackage;
    }

    public String toString(){
        return "Objeto: " +
                "idPackage = "+getIdPackage()+", " +
                "idVehicle = "+getIdVehicle()+", " +
                "location = "+getLocation()+", " +
                "latitude = "+getLatitude()+", "+
                "longitude = "+getLongitude()+", "+
                "timestamp = "+getTimestamp();
    }
}
