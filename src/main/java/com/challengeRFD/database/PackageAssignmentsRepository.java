package com.challengeRFD.database;

import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;

public interface PackageAssignmentsRepository {

    PackageAssignments findPackageDataByIdPedidoOrderByTimestampDesc(int idpackage);
}
