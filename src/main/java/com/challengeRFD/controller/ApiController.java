package com.challengeRFD.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.challengeRFD.model.DatosCoche;
import com.challengeRFD.model.Pedido;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @GetMapping("/ubicacion")
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public DatosCoche getUbicacion(@RequestParam(value = "idPedido") int idPedido) {
        return new DatosCoche(1, "1", "1", "1", "1", new Date());
    }

    @GetMapping("/ubicacion")
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = { "application/json" })
    public DatosCoche postUbicacion(@RequestParam(value = "idPedido") int idPedido) {
        return new DatosCoche(1, "1", "1", "1", "1", new Date());
    }

    @GetMapping("/pedido")
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = { "application/json" })
    public Pedido postPedido(@RequestParam(value = "idPedido") int idPedido) {
        return new Pedido(1, "1");
    }

    @GetMapping("/pedido")
    @RequestMapping(method = RequestMethod.DELETE, produces = {"application/json"})
    public Pedido deletePedido(@RequestParam(value = "idPedido") int idPedido) {
        return new Pedido(1, "1");
    }

}
