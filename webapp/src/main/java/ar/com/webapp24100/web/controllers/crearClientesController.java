package ar.com.webapp24100.web.controllers;

import ar.com.webapp24100.web.dto.ClientesDto;
import ar.com.webapp24100.web.service.ClientesService;

public class crearClientesController {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Aca quiero Crear un cliente en la DB
        //Long id = 1l;  //recibo desde el request que envio algun Frontend
        String nombre = "Ximena";
        String apellido = "Aduviri Fernandez";
        String email = "xime@gmail.com";
        String imagen = "/imagenes/lina.jpg";
        Long tipoClientesId = 1l;

        //Agregar Validaciones-y esto seria desde el Backend!!
        if (nombre == null || nombre.isBlank()){
            //ACA HABRIA UN ERROR!
            return;
        }
         
        ClientesService service = new ClientesService();

        //Crear el DTO
        ClientesDto dto = new ClientesDto(nombre, apellido, email, imagen, tipoClientesId);

        service.crearCliente(dto);
    }
}
