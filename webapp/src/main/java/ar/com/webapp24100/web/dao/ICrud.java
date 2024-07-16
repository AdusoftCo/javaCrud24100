package ar.com.webapp24100.web.dao;

import java.util.ArrayList;

import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.dto.ClientesDto;

public interface ICrud {

    //Este es el QUE
    public Clientes getById(Long id);
    //esto es el: select * from clientes where id=?
    
    public void create(ClientesDto dto);

    public void delete(Long pk);

    public ArrayList<Clientes> findAll();

    public void update(ClientesDto cliente);
}
