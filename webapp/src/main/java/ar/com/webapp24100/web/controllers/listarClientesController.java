package ar.com.webapp24100.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.webapp24100.web.domain.Clientes;
import ar.com.webapp24100.web.service.ClientesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarClientesController")
public class listarClientesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("listarClientesController doGet called"); // Debug stat
        //Aca quiero obtener TODOS los clientes de la DB con id=?
        //Crear al Service
        ClientesService service = new ClientesService();
        
        //Invocar metodo ListarClientes > Lista
        ArrayList<Clientes> clientes = service.listarClientes();

        ObjectMapper mapper = new ObjectMapper();

        String clientesJSON =  mapper.writeValueAsString(clientes);

        //Mostar por consola | Envia al front end
        /* */
        // Configurar cabeceras CORS
        resp.setHeader("Access-Control-Allow-Origin", "*"); // Permitir acceso desde cualquier origen
        resp.setHeader("Access-Control-Allow-Methods", "*"); // Métodos permitidos(GET, POST, PUT, DELETE ...)
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Cabeceras permitidas

        resp.getWriter().println(clientesJSON);
    }
}
