package ar.com.webapp24100.web.dao;

import java.sql.Connection;
//D.A.O.(dao) = Data Access Object
import java.sql.DriverManager;

public class AdministradorDeConexiones {
    private Connection connection;

    //Obtener una Conexion
    public Connection conectar() {
        //toda la logica para obtener Conexion!
        String url = "jdbc:mysql://127.0.0.1:3306/24100CaC?serverTimeZone=UTC&userSSL=false";
        String user = "root";
        String password = "";
        //Como usamos JDBC necesito decirle ke driver voy a usar:Mysql
        String driver = "com.mysql.cj.jdbc.Driver";

        //Connection connection = null;

        //Como puede dar Error tonces try/catch
        try {
            //Si va todo bien
            //forName es un metodo estatico: ke NO necesito una instancia para USAR dicho metodo
            Class.forName(driver);
            
            //Ahora que ya tengo el driver. ME CONECTO
            this.connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            // SI Falla
            System.err.println("No se ha conectado a la DB: " + e.getMessage());
        }

        return connection;
    }

    public void desconectar() {
        //Controlo el posible Error del metodo Close()
        try {
            this.connection.close();    
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }

    public static void main(String[] args) {
        //Como hago la prueba de conectar a DB?
        //1- Crear instancia de AdmDeConec()
        AdministradorDeConexiones adm = new AdministradorDeConexiones();
        //2- llamo a conectar
        adm.conectar();
        adm.desconectar();
    }
}
