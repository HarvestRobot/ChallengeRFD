package com.challengeRFD.bo;

import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.model.PackageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChallengeBOTest {

    @Autowired
    ChallengeBO bo;

    @org.junit.jupiter.api.Test
    void contextLoads(){
        assertNotNull(bo);
    }

    @org.junit.jupiter.api.Test
    void getPackageDataSuccess() {
        int idPackage = 1;
        PackageData packageDataReturn = bo.getPackageData(idPackage);
        assertEquals(packageDataReturn.getIdPackage(), idPackage);
        assertEquals(packageDataReturn.getIdVehicle(), "A1");
        assertEquals(packageDataReturn.getLocation(), "Madrid");
        assertEquals(packageDataReturn.getLatitude(), "6.5652445");
        assertEquals(packageDataReturn.getLongitude(), "35.65324565");
        assertEquals(packageDataReturn.getTimestamp(), Timestamp.valueOf("2022-04-29 00:24:02.000"));
    }

    @org.junit.jupiter.api.Test
    void getPackageDataIdNotFound() {
        int idPedido = -1;
        PackageData packageDataReturn = bo.getPackageData(idPedido);
        assertNull(packageDataReturn);
    }

    @org.junit.jupiter.api.Test
    void postPackageDataSuccess() {
        PackageData packageData = new PackageData(99,
                "TESTVEHICLE",
                "TESTLOCATION",
                "TESTLATITUDE",
                "TESTLONGITUDE"
        );
        PackageData packageDataReturn = bo.postPackageData(packageData);
        assertNotNull(packageDataReturn);
    }

    @org.junit.jupiter.api.Test
    void postPackageSuccess() {
        PackageAssignments packageAssignmentsReturn = new PackageAssignments(4, "CR2564");
        assertNotNull(packageAssignmentsReturn);
    }

    @org.junit.jupiter.api.Test
    void deletePackageSuccess() {
        int idPackage = 1;
        ArrayList<PackageAssignments> packageAssignmentsReturn = bo.deletePackage(idPackage);
        assertNotNull(packageAssignmentsReturn);
    }

    @org.junit.jupiter.api.Test
    void deletePackageNotFound() {
        int idPackage = -1;
        ArrayList<PackageAssignments> packageAssignmentsReturn = bo.deletePackage(idPackage);
        assertNull(packageAssignmentsReturn);
    }
}