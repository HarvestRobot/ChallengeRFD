package com.challengeRFD.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import com.challengeRFD.api.ChallengeAPI;
import com.challengeRFD.bo.ChallengeBO;
import com.challengeRFD.model.DatosPedido;
import com.challengeRFD.model.Pedido;
import io.swagger.models.Response;
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
        ArrayList<DatosPedido> datosPedido = new ArrayList<>();
        try {
               datosPedido = bo.getUbicacion(idPedido);
               if (datosPedido != null) {
                   return ResponseEntity.status(HttpStatus.OK).body(datosPedido);
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
    public ResponseEntity<?> postUbicacion(DatosPedido datosPedido) {
        return null;
    }

    @Override
    public ResponseEntity<?> postPedido(Pedido pedido) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePedido(String locale) {
        return null;
    }


}
