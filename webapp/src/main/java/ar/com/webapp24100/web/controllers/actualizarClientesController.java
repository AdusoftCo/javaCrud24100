package ar.com.webapp24100.web.controllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import ar.com.webapp24100.web.dto.ClientesDto;
import ar.com.webapp24100.web.service.ClientesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/actualizarClientesController")
public class actualizarClientesController extends HttpServlet{

    @Override
    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp)
    throws ServletException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();

        //crar el DTO
        ClientesDto dto = mapper.readValue(req.getReader(), ClientesDto.class);

        ClientesService service = new ClientesService();
        
        try {
            service.actualizarCliente(dto);
            resp.setStatus(HttpServletResponse.SC_OK); // Updated to SC_OK for update
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"error\":\"" + e.getMessage() + "\"}");
        }
        //service.actualizarCliente(dto);
      
        //resp.setStatus(HttpServletResponse.SC_CREATED);/////actualizado
    }
}