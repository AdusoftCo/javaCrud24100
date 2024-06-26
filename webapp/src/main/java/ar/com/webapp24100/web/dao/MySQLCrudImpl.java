package ar.com.webapp24100.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.dto.ClientesDto;

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
                String email = resultSet.getString(4);
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

    
    public void create(ClientesDto dto) {
        String sql = "INSERT INTO clientes(nombre, apellido, email, imagen, clientes_tipo_id) VALUES(?, ?, ?, ?, ?)";
    
        Connection connection = AdministradorDeConexiones.conectar();

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            //Seteo en orden cada parametro
            pst.setString(1, dto.getNombre());
            pst.setString(2, dto.getApellido());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getImagen());
            pst.setLong(5, dto.getTipoClienteId());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }


    }
       
}
