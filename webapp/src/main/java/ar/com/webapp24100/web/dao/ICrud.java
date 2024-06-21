package ar.com.webapp24100.web.dao;

import ar.com.webapp24100.web.domain.Clientes;

public interface ICrud {

    //Este es el QUE
    public Clientes getById(long id);
    //esto es el: select * from clientes where id=?
}
