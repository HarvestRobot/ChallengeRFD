package com.challengeRFD.database;
import com.challengeRFD.model.PackageData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;


public interface PackageDataRepository extends CrudRepository<PackageData, Integer> {

    PackageData findPackageDataByIdPackageOrderByTimestampDesc(int idpackage);

}
