package com.challengeRFD.database;
import com.challengeRFD.model.PackageData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

/**
 * Implements SQL duties for the table packagedata.
 */
public interface PackageDataRepository extends CrudRepository<PackageData, Integer> {

   PackageData findFirstByIdPackageOrderByTimestampDesc(int idpackage);


}
