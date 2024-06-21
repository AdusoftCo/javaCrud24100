package ar.com.codo24100.api.service;

import ar.com.codo24100.api.DefaultLog;
import ar.com.codo24100.api.EmailLog;
import ar.com.codo24100.api.ILog;
import ar.com.codo24100.api.SMSLog;

public class LogService {
    private ILog logger; //???? es un interface(ILog) con valor= null

    //Ahora el Constructor
    public LogService (int logHabilitado) {
        // Interface i = new Clase()

        switch (logHabilitado) {
            case 1:
                this.logger = new SMSLog();
                break;
            case 2:
                this.logger = new EmailLog();
                break;
        
            default:
                this.logger = new DefaultLog();
                break;
        }
    }
    
    public void enviarMensaje (String msjAEnviar) {
        this.logger.log(msjAEnviar);
    }
}
