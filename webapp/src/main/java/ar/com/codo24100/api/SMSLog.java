package ar.com.codo24100.api;

public class SMSLog implements ILog {

    // Este es el COMO hago para enviar SMS
    public void log(String msj) {
        System.out.println("Enviando SMS a Pepe: ");
        System.out.println(msj);
    }

}
