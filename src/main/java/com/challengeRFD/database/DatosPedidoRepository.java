package com.challengeRFD.database;
import com.challengeRFD.model.PackageData;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;


public interface DatosPedidoRepository extends Repository<PackageData, Integer> {

    PackageData findPackageDataByIdPedidoOrderByTimestampDesc(int idpedido);
}
