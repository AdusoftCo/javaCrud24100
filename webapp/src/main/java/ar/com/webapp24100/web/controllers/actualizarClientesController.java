/*package ar.com.webapp24100.web.controllers;

//import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.dto.ClientesDto;
import ar.com.webapp24100.web.service.ClientesService;

public class actualizarClientesController {

    public static void main(String[] args) {
        //Datos ke kiero actualizar, vienen desde el front
        Long id = 2l;
        String nombre = "Nuevo nombre";
        String apellido = "Nuevo apellido";
        String email = "nuevo@email.com";
        String imagen = "bla/imag.jpg";
        Long tipoClienteId = 2l;
        
        //Ahora lo de siempre
        ClientesService service = new ClientesService();

        ClientesDto cliente = new ClientesDto(id, nombre, apellido, email, imagen, tipoClienteId);

        service.actualizarCliente(cliente);
    }
}
*/