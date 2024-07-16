package ar.com.webapp24100.web.service;

import java.util.ArrayList;

import ar.com.webapp24100.web.dao.ICrud;
import ar.com.webapp24100.web.dao.MySQLCrudImpl;
import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.dto.ClientesDto;

public class ClientesService {

    private ICrud crud;  //Vale null=muerto, por que no es primitivo

    public ClientesService() {
        //Interface nombre = new ClaseQueImplementaLaInterface()
        crud = new MySQLCrudImpl();
    }

    public void crearCliente(ClientesDto dto) {
        this.crud.create(dto);
    }

    public Clientes obtenerClientePorId(Long id) {
        return this.crud.getById(id);
    }

    public void eliminarClientesPorID(Long id) {
        this.crud.delete(id);        
    }

    public ArrayList<Clientes> listarClientes() {
        return this.crud.findAll();
    }

    public void actualizarCliente(ClientesDto cliente) {
        this.crud.update(cliente);
    }

}
