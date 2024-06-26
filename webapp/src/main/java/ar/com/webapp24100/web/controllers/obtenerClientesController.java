package ar.com.webapp24100.web.controllers;

import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.service.ClientesService;

public class obtenerClientesController {

    public static void main(String[] args) {
        //Aca quiero obtener un cliente de la DB con id=1
        Long id = 2l;  //recibo desde el request que envio algun Frontend
         
        ClientesService service = new ClientesService();

        Clientes cliente = service.obtenerClientePorId(id);

        System.out.println(cliente);
    }
}
