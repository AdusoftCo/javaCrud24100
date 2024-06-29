package ar.com.webapp24100.web.controllers;

import ar.com.webapp24100.web.service.ClientesService;

public class eliminarClientesController {

    public static void main(String[] args) {
        //Aca quiero Borrar un cliente de la DB con id=1
        Long id = 3l;  //recibo desde el request que envio algun Frontend
         
        ClientesService service = new ClientesService();

        service.eliminarClientesController(id);

    }

}
