package ar.com.webapp24100.web.controllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.webapp24100.web.domain.Usuario;
import ar.com.webapp24100.web.dto.loginRequestDto;
import ar.com.webapp24100.web.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/auth")
public class loginController extends HttpServlet{

    protected void doPost(
        HttpServletRequest req, 
        HttpServletResponse resp)
     throws ServletException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();

        loginRequestDto loginRequestDTO = mapper.readValue(req.getReader(), loginRequestDto.class);
        
        UsuarioService service = new UsuarioService();

        Usuario usuario = service.buscarUsuario(loginRequestDTO.getUsername());

        if(usuario == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if(!loginRequestDTO.getPassword().equals(usuario.getPassword())) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        resp.setStatus(HttpServletResponse.SC_CREATED);//201 - se creo usuario        
    }
}
