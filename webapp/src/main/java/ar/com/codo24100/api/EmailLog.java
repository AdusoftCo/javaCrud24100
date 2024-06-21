package ar.com.codo24100.api;

public class EmailLog implements ILog {

    // Esto es el COMO
    public void log(String msj) {
        System.out.println("Enviando Email ...");
        System.out.println("body :" + msj);
    }

}
