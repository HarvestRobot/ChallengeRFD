package com.challengeRFD.database;

import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Transactional
public interface PackageAssignmentsRepository extends CrudRepository<PackageAssignments, Integer> {

    PackageAssignments findPackageAssignmentsByIdPackage(int idpackage);
    ArrayList<PackageAssignments> deleteAllByIdPackage(int idpackage);
}
