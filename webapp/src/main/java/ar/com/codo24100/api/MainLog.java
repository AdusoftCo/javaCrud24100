package ar.com.codo24100.api;

import ar.com.codo24100.api.service.LogService;

//import java.util.Scanner;

public class MainLog {

    public static void main(String[] args) {
        
        //1- Obtengo el mensaje ke kiero Enviar
        //Scanner teclado = new Scanner(System.in)->teclado.next();

        String msj = "Error en el File!!";

        //2- Creo una instancia de mi Log particular
        //SMSLog log = new SMSLog();
        //EmailLog log2 = new EmailLog();

        //Interface nombre = new ClaseQueImplementaLaInterface()
        // el Que  =  el Como ->ILog miLog = new EmailLog();

        //Instancia LogService
        int log = 3;

        LogService service = new LogService(log);

        //3- Envio el mensaje= msj ->miLog.log(msj);
        service.enviarMensaje(msj);

        //Cerrar el teclado
        //teclado.close();
    }
}
