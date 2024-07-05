package ar.com.webapp24100.web.filters;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class corsFilter implements Filter{

    private List<String> origins = List.of("http://localhost:5500", "http://127.0.0.1:5500");

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // This method is used to initialize the filter configuration
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Cast the request and response objects to their HTTP versions
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the Origin header from the request
        String origin = httpRequest.getHeader("Origin");

		System.out.println(origin);

        // Check if the origin is allowed
        if (origin != null && origins.contains(origin)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }

        // If the request method is OPTIONS, we can short-circuit the request and return immediately
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Pass the request along the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // This method is used to clean up any resources used by the filter
    }
	
	/*
		//esto viene desde el front
		String origin = ((HttpServletRequest) request).getHeader("origin");

        
		//ese front esta permido?
		if (origin != null && origins.contains(origin)) {
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", origin);
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "*");
		    
        }   

		chain.doFilter(request, response); */
	
}
