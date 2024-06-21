package ar.com.webapp24100;

public class MainVehiculo {

    public static void main(String[] args) {
        // 1- Crear el auto
        // Instanciando un ojeto de la Clase Vehiculo
        Vehiculo clio = new Vehiculo("renault", "clio", 2018, "12345678", 5);

        // El clio esta alive

        clio.encender();

        clio.mostrarDatos();
        /*
        System.out.println(clio.obtenerVelocidad());  */

        clio.acelerar();
        clio.acelerar();
        clio.acelerar();
        clio.acelerar();
        clio.acelerar();

        clio.acelerar();

        clio.detener();
        
        clio.mostrarDatos();
    }

}
