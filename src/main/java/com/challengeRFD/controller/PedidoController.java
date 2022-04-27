package com.challengeRFD.controller;

import java.sql.*;
import java.util.Date;
import java.util.Properties;

import com.challengeRFD.model.DatosCoche;
import com.challengeRFD.model.Pedido;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    @GetMapping("/ubicacion")
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public DatosCoche getUbicacion(@RequestParam(value = "idPedido") int idPedido) {
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","admin");
        //props.setProperty("ssl","true");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM localizaciones WHERE idpedido = "+idPedido+
                    " ORDER BY timestamp DESC LIMIT 1");
            if (rs.next()) {
                return new DatosCoche(rs.getInt("idpedido"),
                        rs.getString("idvehiculo"),
                        rs.getString("localizacion"),
                        rs.getString("latitud"),
                        rs.getString("longitud"),
                        rs.getTimestamp("timestamp").toString());
            }
        } catch (SQLException sql){
           sql.printStackTrace();
        }

        return null;

    }

    /**
  @PostMapping("/ubicacion")
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = { "application/json" })
    public DatosCoche postUbicacion(@RequestParam(value = "idPedido") int idPedido) {
        return new DatosCoche(1, "1", "1", "1", "1", "Hola");
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
**/
}
