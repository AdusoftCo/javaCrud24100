package ar.com.webapp24100.web.service;
import ar.com.webapp24100.web.dao.UsuarioDAO;
import ar.com.webapp24100.web.dao.UsuarioDAOMysqlImpl;
import ar.com.webapp24100.web.domain.Usuario;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAOMysqlImpl();
    }

    public Usuario buscarUsuario(String email) {
        return this.dao.findByUsername(email);
    }
}
