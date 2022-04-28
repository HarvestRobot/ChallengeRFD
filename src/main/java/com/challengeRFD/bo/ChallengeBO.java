package com.challengeRFD.bo;

import com.challengeRFD.database.PackageDataRepository;
import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service("ChallengeBO")
public class ChallengeBO {

    @Autowired
    private PackageDataRepository repository;

    public ChallengeBO(){

    }

    public PackageData getPackageData(int idPackage) {
        PackageData result = repository.findPackageDataByIdPackageOrderByTimestampDesc(idPackage);
        if(result == null){
            return null;
        } else {
            return result;
        }
    }

    public PackageData postPackageData (PackageData packageData) {
        PackageData newPackageData = new PackageData(packageData.getIdPackage(),
                packageData.getIdVehicle(),
                packageData.getLocation(),
                packageData.getLatitude(),
                packageData.getLongitude(),
                packageData.getTimestamp()
        );
        System.out.println(newPackageData.toString());
        System.out.println("hola1");
        repository.save(newPackageData);
        System.out.println("hola2");
        return newPackageData;
    }

    public ArrayList<PackageAssignments> postPackage (PackageData packageData) throws SQLException {
        return null;
    }

    public ArrayList<PackageAssignments> deletePackage (int idPackage) throws SQLException {
        return null;
    }

}
