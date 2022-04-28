package com.challengeRFD.database;
import com.challengeRFD.model.DatosPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface DatosPedidoRepository extends Repository<DatosPedido, Integer> {
    //@Query("SELECT idpedido FROM localizaciones where idpedido = :idpedido")
    ArrayList<DatosPedido> findByIdPedido(int idpedido);
}
