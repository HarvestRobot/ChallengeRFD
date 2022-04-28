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

    public PackageData getUbicacion (int idPedido) throws SQLException {
        PackageData result = repository.findPackageDataByIdPedidoOrderByTimestampDesc(idPedido);

        System.out.println(result);
        if(result == null){
            System.out.println("null");
            return null;
        } else {
            return result;
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
