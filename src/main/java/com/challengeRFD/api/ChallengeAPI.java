package com.challengeRFD.api;

import com.challengeRFD.model.DatosPedido;
import com.challengeRFD.model.Pedido;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ChallengeAPI {

    @ApiOperation(value = "Obtiene la localizacion de un pedido.", nickname = "getUbicacion", tags = {
            "ubicacion" }, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource obtained successfully", response = DatosPedido.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/ubicacion", produces = {
            "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> getUbicacion(@ApiParam(value = "Identificador del pedido.") @RequestParam("idPedido") int idPedido);


    @ApiOperation(value = "Actualiza la localizacion de un pedido.", nickname = "postUbicacion", tags = {
            "ubicacion" }, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource created successfully", response = DatosPedido.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/ubicacion", produces = {
            "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> postUbicacion(@RequestBody DatosPedido datosPedido);

    @ApiOperation(value = "Asigna un pedido a un vehiculo.", nickname = "postPedido", tags = {
            "pedido" }, produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource created successfully", response = Pedido.class),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/pedido", produces = {
            "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> postPedido(@RequestBody Pedido pedido);


    @ApiOperation(value = "Borra todos los datos de un pedido ya entregado.", nickname = "deletePedido", tags = {
            "pedido" }, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource deleted successfully"),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad request or functional error"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/pedido", produces = {
            "application/json" }, consumes = { "application/json" }, method = RequestMethod.DELETE)
    ResponseEntity<?> deletePedido(@ApiParam(value = "El identificador del pedido") @RequestParam("locale") String locale);

}
