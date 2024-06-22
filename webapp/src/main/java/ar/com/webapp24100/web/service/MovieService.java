package ar.com.webapp24100.web.service;

import ar.com.webapp24100.web.dao.ICrud;
import ar.com.webapp24100.web.dao.MySQLCrudImpl;
import ar.com.webapp24100.web.dto.ClientesDTO;

public class MovieService {

    private ICrud crud;  //Vale null=muerto, por que no es primitivo

    public MovieService() {
        //Interface nombre = new ClaseQueImplementaLaInterface()
        crud = new MySQLCrudImpl();
    }

    public void crearCliente(ClientesDTO dto) {
        //this.crud.getById(null);
    }

    public Clientes obtenerClientePorId(Long id) {
        return this.crud.getById(id);
    }

}
