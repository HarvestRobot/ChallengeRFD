package com.challengeRFD.controller;

import java.sql.*;
import java.util.ArrayList;

import com.challengeRFD.api.ChallengeAPI;
import com.challengeRFD.bo.ChallengeBO;
import com.challengeRFD.model.PackageData;
import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.utils.ErrorReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the API.
 * This layer is between the BO and the API and takes care of handling exceptions and errors.
 */
@RestController
public class ChallengeController implements ChallengeAPI {

    @Autowired
    ChallengeBO bo;

    /**
     * Controller for the method getPackageData of the BO
     * @param idPackage -> the package to handle
     * @return the status of the petition
     */
    @Override
    public ResponseEntity<?> getPackageData(int idPackage) {
        PackageData packageData;
        try {
            packageData = bo.getPackageData(idPackage);
            if (packageData != null) {
                return ResponseEntity.status(HttpStatus.OK).body(packageData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorReturn(
                        404, "Package not found","We didn't find your package." +
                        "Check the package id and try again."));
            }
        } catch (Exception genException) {
            genException.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorReturn(500, "Internal error", "Unhandled internal error." +
                    "Please, contact with a system administrator showing them the next message: " + genException.getMessage()));
        }
    }

    /**
     * Controller for the method postPackageData of the BO
     * @param packageData -> the data to handle
     * @return the status of the petition
     */
    @Override
    public ResponseEntity<?> postPackageData(PackageData packageData) {
        PackageData newPackageData = bo.postPackageData(packageData);
        if (newPackageData != null) {
            return ResponseEntity.status(HttpStatus.OK).body(newPackageData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorReturn(
                    400, "Bad request", "We couldn't register package data. Sorry about that."));
        }
    }

    /**
     * Controller for the method postPackage of the BO
     * @param packageAssignments -> the data to handle
     * @return the status of the petition
     */
    @Override
    public ResponseEntity<?> postPackage(PackageAssignments packageAssignments) {
        try {
            if (bo.postPackage(packageAssignments) != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(packageAssignments);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorReturn(
                        400, "Bad request", "We couldn't register package data. Sorry about that."));
            }
        } catch (RuntimeException e) {
            //Using guava Throwables because the postgres PSQLException exception cant be directly handled
            Throwable rootCause = com.google.common.base.Throwables.getRootCause(e);
            if (rootCause instanceof SQLException) {
                if ("23505".equals(((SQLException) rootCause).getSQLState())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorReturn(
                            400, "Bad request: duplicated package","Error: this package is already assigned to a vehicle. Please, check the package id."));
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SQL internal error (code " +((SQLException) rootCause).getSQLState()+"). "+
                            "Please, contact with a system administrator showing them the next message: " + rootCause.getMessage());
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unhandled internal error." +
                        "Please, contact with a system administrator showing them the next message: " + rootCause.getMessage());
            }
        }
    }

    /**
     * Controller for the method deletePackage of the BO
     * @param idPackage -> the package to handle
     * @return the status of the petition
     */
    @Override
    public ResponseEntity<?> deletePackage (int idPackage){
        ArrayList<PackageAssignments> packageData;
        try {
            packageData = bo.deletePackage(idPackage);
            if (packageData != null && packageData.size() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(packageData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorReturn(
                        404, "Package not found","We didn't find your package." +
                        "Check the package id and try again."));
            }
        } catch (Exception genException) {
            genException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unhandled internal error." +
                    "Please, contact with a system administrator showing them the next message: " + genException.getMessage());
        }
    }


    }
