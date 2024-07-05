package ar.com.webapp24100.web.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.webapp24100.web.dto.ClientesDto;
import ar.com.webapp24100.web.service.ClientesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crearClientesController")
public class crearClientesController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String jsonKeMandaElFront = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(jsonKeMandaElFront);
        
        //Usamos Jackson para convertir el texto QUE VIENE del FRONT en 
        //Un objeto JAVA "magicamente" creado por
        ObjectMapper mapper = new ObjectMapper();
        
        //Crea el DTO!!
        ClientesDto dto = mapper.readValue(jsonKeMandaElFront, ClientesDto.class);

        ClientesService service = new ClientesService();

        //Crear el DTO
                
        service.crearCliente(dto);

        //respondemos algo al front por medio del codigo de estado
        //http status code: 100,200,300,400,500
        // Send success response
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Cliente creado exitosamente");
   
        //resp.setStatus(HttpServletResponse.SC_CREATED);/////creado
        }
}
