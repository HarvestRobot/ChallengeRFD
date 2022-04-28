package com.challengeRFD.bo;

import com.challengeRFD.database.DatosPedidoRepository;
import com.challengeRFD.model.PackageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service("ChallengeBO")
public class ChallengeBO {

    @Autowired
    private DatosPedidoRepository repository;

    public ChallengeBO(){

    }

    public ArrayList<PackageData> getUbicacion (int idPedido) throws SQLException {
        ArrayList<PackageData> result = repository.findByIdPedido(idPedido);

        //System.out.println(result);
        if(!result.isEmpty()){
            //System.out.println("result.get(0)"+result.get(0));
            return result;
        } else {
            return null;
        }


    }

    public ArrayList<PackageData> postUbicacion (PackageData packageData) throws SQLException {
        return null;
    }

    public ArrayList<PackageData> postPedido (PackageData packageData) throws SQLException {
        return null;
    }

    public ArrayList<PackageData> deletePedido (int idPedido) throws SQLException {
        return null;
    }

}
