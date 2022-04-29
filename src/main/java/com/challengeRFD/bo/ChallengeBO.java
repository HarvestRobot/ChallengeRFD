package com.challengeRFD.bo;

import com.challengeRFD.database.PackageAssignmentsRepository;
import com.challengeRFD.database.PackageDataRepository;
import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * BusinessObject class for the controller of the API
 * This layer communicates with the DB.
 */
@Service("ChallengeBO")
public class ChallengeBO {

    @Autowired
    private PackageDataRepository repositoryPackageData;

    @Autowired
    private PackageAssignmentsRepository repositoryPackageAssignments;

    public ChallengeBO(){

    }

    /**
     * Gets the tracking of a package
     * @param idPackage -> the id of the package to search
     * @return the data of the package, corresponding to a PackageData object
     */
    public PackageData getPackageData(int idPackage) {
        return repositoryPackageData.findFirstByIdPackageOrderByTimestampDesc(idPackage);
    }

    /**
     * Updates the tracking of a package with the new location of the vehicle
     * adding a timestamp of the moment of the petition
     * @param packageData -> the data of the tracking package
     * @return the updated package data
     */
    public PackageData postPackageData (PackageData packageData) {
        PackageData newPackageData = new PackageData(packageData.getIdPackage(),
                packageData.getIdVehicle(),
                packageData.getLocation(),
                packageData.getLatitude(),
                packageData.getLongitude()
        );

        newPackageData.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        repositoryPackageData.save(newPackageData);
        return newPackageData;
    }

    /**
     * Inserts a new relation package->vehicle
     * @param packageAssignments -> the package->vehicle relation
     * @return the same relation taken by param
     */
    public PackageAssignments postPackage (PackageAssignments packageAssignments) {
        repositoryPackageAssignments.save(packageAssignments);
        return packageAssignments;
    }

    /**
     * Deletes a relation package->vehicle ONLY from the table packageassignments
     * @param idPackage -> the id of the package to delete
     * @return the deleted package
     */
    public ArrayList<PackageAssignments> deletePackage (int idPackage) {
        ArrayList<PackageAssignments> result = repositoryPackageAssignments.deleteAllByIdPackage(idPackage);
        if (result == null || result.size() == 0){
            return null;
        }
        return result;
    }

}
