package com.challengeRFD.bo;

import com.challengeRFD.database.PackageAssignmentsRepository;
import com.challengeRFD.database.PackageDataRepository;
import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

@Service("ChallengeBO")
public class ChallengeBO {

    @Autowired
    private PackageDataRepository repositoryPackageData;

    @Autowired
    private PackageAssignmentsRepository repositoryPackageAssignments;

    public ChallengeBO(){

    }

    public PackageData getPackageData(int idPackage) {
        return repositoryPackageData.findFirstByIdPackageOrderByTimestampDesc(idPackage);
    }

    public PackageData postPackageData (PackageData packageData) {
        PackageData newPackageData = new PackageData(packageData.getIdPackage(),
                packageData.getIdVehicle(),
                packageData.getLocation(),
                packageData.getLatitude(),
                packageData.getLongitude()
        );

        newPackageData.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println("timestamp = "+newPackageData.getTimestamp());
        repositoryPackageData.save(newPackageData);
        return newPackageData;
    }

    public PackageAssignments postPackage (PackageAssignments packageAssignments)  {
        repositoryPackageAssignments.save(packageAssignments);
        return packageAssignments;
    }

    public ArrayList<PackageAssignments> deletePackage (int idPackage) {
        ArrayList<PackageAssignments> result = repositoryPackageAssignments.deleteAllByIdPackage(idPackage);
        if (result.size() == 0 || result == null){
            return null;
        }
        return result;
    }

}
