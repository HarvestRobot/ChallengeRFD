package com.challengeRFD.controller;

import java.sql.*;

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
    @Autowired
    private PackageDataRepository repository;

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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error interno desconocido.\n" +
                    "Por favor, contacte con un administrador mostrándole el siguiente mensaje: \n"+genException.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> postPackageData(PackageData packageData) {
        if (bo.postPackageData(packageData) != null) {
            System.out.println("return OK");
            return ResponseEntity.status(HttpStatus.OK).body(packageData);
        } else {
            System.out.println("return KO");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha podido registrar el paquete.\nDisculpe las molestias.");
        }
    }

    @Override
    public ResponseEntity<?> postPackage(PackageAssignments packageAssignments) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePackage(int idPackage) {
        return null;
    }


}
