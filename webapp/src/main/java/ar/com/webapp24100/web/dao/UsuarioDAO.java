package ar.com.webapp24100.web.dao;

import ar.com.webapp24100.web.domain.Usuario;

public interface UsuarioDAO {

     public Usuario findByUsername(String username);
}
