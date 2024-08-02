package ar.com.webapp24100.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
    protected void doPost(
        HttpServletRequest req, //esto tiene los datos del front
        HttpServletResponse resp//va todo lo que el back quiera enviarle al front
    ) throws ServletException, IOException {
        // Configurar cabeceras CORS para las solicitudes preflight
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods","POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers","x-requested-with, Content-Type");
        
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        String jsonQueMandaElFront = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("Request JSON: " + jsonQueMandaElFront);
        System.out.println(jsonQueMandaElFront);
        
        //usamos jackson para convertir el texto que viene desde el front en 
        //un objecto java "magicamente" creado
        ObjectMapper mapper = new ObjectMapper();

        //crear el DTO
        ClientesDto dto = mapper.readValue(jsonQueMandaElFront, ClientesDto.class);
        //System.out.println("Parsed DTO: " + dto);
        ClientesService service = new ClientesService();
        
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        
        try {
            service.crearCliente(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            out.print("{\"message\":\"Cliente created successfully\"}");
        } catch (Exception e) {
            e.printStackTrace(); // Add this line to print the exception stack trace
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
        //service.crearCliente(dto);
      
        //respondemos algo al front por medio del codigo de estado
        //http status code: 100,200,300,400,500
        
        //resp.setStatus(HttpServletResponse.SC_CREATED);/////creado
}
