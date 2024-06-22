package ar.com.webapp24100.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ar.com.webapp24100.web.domain.Clientes;

public class MySQLCrudImpl implements ICrud {

    //Debo decirle el COMO: implementar el/los metodos de ICrud
    public Clientes getById(Long id) {
        // Armo la sentencia SQL
        String sql = "SELECT * from clientes WHERE id = " + id;
        
        //1- Conectarme a la DB
        Clientes cliente = null;

        Connection con = null;

        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            //DEBO leer el result y crear mis entidades

            //SI hay datos, solo existe (1)un registro!!!
            if (resultSet.next()){
                Long idCliente = resultSet.getLong(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String email = resultSet.getString(4)
                String imagen = resultSet.getString(5);
                Long tipoClienteId = resultSet.getLong(6);
                
                cliente = new Clientes(idCliente, nombre, apellido, email, imagen, tipoClienteId);
               
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }

        return cliente;
    }
       
}
