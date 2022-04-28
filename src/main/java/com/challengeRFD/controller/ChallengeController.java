package com.challengeRFD.controller;

import java.sql.*;
import java.util.ArrayList;

import com.challengeRFD.api.ChallengeAPI;
import com.challengeRFD.bo.ChallengeBO;
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
    public ResponseEntity<?> getUbicacion(int idPedido) {
        ArrayList<PackageData> packageData = new ArrayList<>();
        try {
               packageData = bo.getUbicacion(idPedido);
               if (packageData != null) {
                   return ResponseEntity.status(HttpStatus.OK).body(packageData);
               } else {
                   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("¡Ups! No hemos encontrado tu pedido.\n¿Puedes revisarlo e intentarlo de nuevo?");
               }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error interno al buscar en la base de datos.\n" +
                    "Por favor, contacte con un administrador mostrándole el siguiente mensaje: \n"+sqlException.getMessage());
        } catch (Exception genException){
            genException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error interno desconocido.\n" +
                    "Por favor, contacte con un administrador mostrándole el siguiente mensaje: \n"+genException.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> postUbicacion(PackageData packageData) {
        return null;
    }

    @Override
    public ResponseEntity<?> postPedido(PackageAssignments packageAssignments) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePedido(String locale) {
        return null;
    }


}
