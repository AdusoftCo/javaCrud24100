package ar.com.codo24100.api;

public class DefaultLog implements ILog {

    public void log(String msj) {
        System.out.println("Log en file System por defecto: " + msj);
        
    }
    
}
