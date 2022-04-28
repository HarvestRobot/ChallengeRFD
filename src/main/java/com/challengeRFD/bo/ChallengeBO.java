package com.challengeRFD.bo;

import com.challengeRFD.database.DatosPedidoRepository;
import com.challengeRFD.model.DatosPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
@Service("ChallengeBO")
public class ChallengeBO {

    @Autowired
    private DatosPedidoRepository repository;

    public ChallengeBO(){

    }

    public ArrayList<DatosPedido> getUbicacion (int idPedido) throws SQLException {
        ArrayList<DatosPedido> result = repository.findByIdPedido(idPedido);

        //System.out.println(result);
        if(!result.isEmpty()){
            //System.out.println("result.get(0)"+result.get(0));
            return result;
        } else {
            return null;
        }


    }

    public ArrayList<DatosPedido> postUbicacion (DatosPedido datosPedido) throws SQLException {
        return null;
    }

    public ArrayList<DatosPedido> postPedido (DatosPedido datosPedido) throws SQLException {
        return null;
    }

    public ArrayList<DatosPedido> deletePedido (int idPedido) throws SQLException {
        return null;
    }

}
