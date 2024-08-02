package ar.com.webapp24100.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

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
                String password = resultSet.getString(5);
                Long tipoClienteId = resultSet.getLong(6);
                String imagen = resultSet.getString(7);
                String pais = resultSet.getString(8);
                //LocalDate fechaNac = resultSet.getDate(7).toLocalDate();
                // Handling null date value
                Date fechaNacSql = resultSet.getDate("fecha_nac");
                LocalDate fechaNac = (fechaNacSql != null) ? fechaNacSql.toLocalDate() : null;
                
                cliente = new Clientes(idCliente, nombre, apellido, email, password, tipoClienteId, imagen, pais, fechaNac);
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }

        return cliente;
    }

    //El COMO!!
    public void create(ClientesDto dto) {
        String sql = "INSERT INTO clientes (nombre, apellido, email, password, clientes_tipos_id, imagen, pais, fecha_nac) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        Connection connection = AdministradorDeConexiones.conectar();

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            //Seteo en orden cada parametro
            pst.setString(1, dto.getNombre());
            pst.setString(2, dto.getApellido());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getPassword());
            // Handle null for tipoClienteId
            if (dto.getTipoClienteId() != null) {
                pst.setLong(5, dto.getTipoClienteId());
            } else {
                pst.setNull(5, java.sql.Types.BIGINT);
            }
            
            pst.setString(6, dto.getImagen());
            pst.setString(7, dto.getPais());
            // handle date null
            Date fechaNac = dto.getFechaNac();
            if (fechaNac != null) {
                pst.setDate(8, fechaNac);
            } else {
                pst.setNull(8, Types.DATE);
            }
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Insert failed");
            } else {
                System.out.println("Insert successful");
            }
        
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    //Implemento el Delete
    public void delete(Long pk) {
        
        Connection con = null;
        String sql = "DELETE FROM clientes WHERE id = ?";

        try {
            con = AdministradorDeConexiones.conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, pk);
            if (pstmt.executeUpdate() > 0) {
                System.out.println("El usuario con ID = " + pk + " ha sido Eliminado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }
        
    }

    //Implemento el Listado
    public ArrayList<Clientes> findAll() {
        // Armo la sentencia SQL
        String sql = "SELECT * FROM clientes";
        
        //1- Conectarme a la DB
        ArrayList<Clientes> clientes = new ArrayList<>();

        Connection con = null;

        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            //DEBO leer el result y crear mis entidades

            //SI hay datos, solo existe (1)un registro!!!
            while (resultSet.next()) {
                Long idCliente = resultSet.getLong(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(5);
                Long tipoClienteId = resultSet.getLong(6);
                String imagen = resultSet.getString(7);
                String pais = resultSet.getString(8);
                //LocalDate fechaNac = resultSet.getDate(8).toLocalDate();
                // Handling null date value
                Date fechaNacSql = resultSet.getDate("fecha_nac");
                LocalDate fechaNac = (fechaNacSql != null) ? fechaNacSql.toLocalDate() : null;
                
                //cliente = new Clientes(idCliente, nombre, apellido, email, imagen, tipoClienteId);
               Clientes cliente = new Clientes(idCliente, nombre, apellido, email, password, tipoClienteId, imagen, pais, fechaNac);

               clientes.add(cliente);
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }

        return clientes;
    }
   
    //Actualizo un registro
       public void update(ClientesDto cliente) {
        // Armo la sentencia SQL
        String sql = new String("UPDATE clientes set nombre=?, apellido=?, email=?, password=?, clientes_tipos_id=?, imagen=?, pais=?, fecha_nac=? WHERE id=? ");

        Connection connection = AdministradorDeConexiones.conectar();        

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getPassword());
            // Handle null for tipoClienteId
            if (cliente.getTipoClienteId() != null) {
                pst.setLong(5, cliente.getTipoClienteId());
            } else {
                pst.setNull(5, Types.BIGINT);
            }
            pst.setString(6, cliente.getImagen());
            pst.setString(7, cliente.getPais());
            //Handle date type
            
            // Handle null for fechaNac
            if (cliente.getFechaNac() != null) {
                pst.setDate(8, new java.sql.Date(cliente.getFechaNac().getTime()));
            } else {
                pst.setNull(8, Types.DATE);
            }
                        
            pst.setLong(9, cliente.getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("update ok");
            } else {
                System.out.println("update failed");
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }            
    } 
}
