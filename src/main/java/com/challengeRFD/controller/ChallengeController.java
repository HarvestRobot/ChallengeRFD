package com.challengeRFD.controller;

import java.sql.*;
import java.util.ArrayList;

import com.challengeRFD.api.ChallengeAPI;
import com.challengeRFD.bo.ChallengeBO;
import com.challengeRFD.database.PackageDataRepository;
import com.challengeRFD.model.PackageData;
import com.challengeRFD.model.PackageAssignments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChallengeController implements ChallengeAPI {

    @Autowired
    ChallengeBO bo;

    @Override
    public ResponseEntity<?> getPackageData(int idPackage) {
        PackageData packageData;
        try {
               packageData = bo.getPackageData(idPackage);
               if (packageData != null) {
                   return ResponseEntity.status(HttpStatus.OK).body(packageData);
               } else {
                   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Whoops. We didn't find your package." +
                           "\nCould you check the package id and try again?");
               }
        } catch (Exception genException){
            genException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unhandled internal error.\n" +
                    "Please, contact with a system administrator showing them the next message: \n"+genException.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> postPackageData(PackageData packageData) {
        PackageData newPackageData = bo.postPackageData(packageData);
        if (newPackageData != null) {
            return ResponseEntity.status(HttpStatus.OK).body(newPackageData);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("We couldn't register package data.\nSorry about that.");
        }
    }

    @Override
    public ResponseEntity<?> postPackage(PackageAssignments packageAssignments) {
        if (bo.postPackage(packageAssignments) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(packageAssignments);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("We could not assign the package to a vehicle.\nSorry about that.");
        }
    }

    @Override
    public ResponseEntity<?> deletePackage(int idPackage) {
        ArrayList<PackageAssignments> packageData;
        try {
            packageData = bo.deletePackage(idPackage);
            if (packageData != null || packageData.size() > 0) {
                return ResponseEntity.status(HttpStatus.OK).body(packageData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Whoops. We didn't find your package." +
                        "\nCould you check the package id and try again?");
            }
        } catch (Exception genException){
            genException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unhandled internal error.\n" +
                    "Please, contact with a system administrator showing them the next message: \n"+genException.getMessage());
        }
    }


}
