package com.challengeRFD.database;
import com.challengeRFD.model.DatosPedido;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface DatosPedidoRepository extends CrudRepository<DatosPedido, Integer> {
    ArrayList<DatosPedido> findByIdPedido(int idPedido);
}
