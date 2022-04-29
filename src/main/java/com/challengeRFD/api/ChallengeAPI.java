package com.challengeRFD.api;

import com.challengeRFD.model.PackageData;
import com.challengeRFD.model.PackageAssignments;
import com.challengeRFD.utils.ErrorReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public interface ChallengeAPI {

    @ApiOperation(value = "Gets the package data", nickname = "getPackageData", tags = {
            "tracking" }, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource obtained successfully", response = PackageData.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error", response = ErrorReturn.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorReturn.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorReturn.class), })
    @RequestMapping(value = "/tracking", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> getPackageData(@ApiParam(value = "Package identification") @RequestParam("idPackage") int idPackage);


    @ApiOperation(value = "Updates a package data.", nickname = "postPackageData", tags = {
            "tracking" }, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource created successfully", response = PackageData.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error", response = ErrorReturn.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorReturn.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorReturn.class), })
    @RequestMapping(value = "/tracking", produces = {
            "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> postPackageData(@RequestBody PackageData packageData);

    @ApiOperation(value = "Assigns a package to a vehicle", nickname = "postPackage", tags = {
            "package" }, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource created successfully", response = PackageAssignments.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error", response = ErrorReturn.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorReturn.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorReturn.class)})
    @RequestMapping(value = "/package", produces = {
            "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> postPackage(@RequestBody PackageAssignments packageAssignments);


    @ApiOperation(value = "Deletes all data of a already delivered package.", nickname = "deletePackage", tags = {
            "package" }, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource deleted successfully", response = PackageAssignments.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error", response = ErrorReturn.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorReturn.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorReturn.class) })
    @RequestMapping(value = "/package", produces = {
            "application/json" }, method = RequestMethod.DELETE)
    ResponseEntity<?> deletePackage(@ApiParam(value = "Package id") @RequestParam("idPackage") int idPackage);

}
