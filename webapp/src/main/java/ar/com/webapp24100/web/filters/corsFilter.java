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
public class CorsFilter implements Filter {

	private List<String> origins = List.of("http://localhost:5500", "http://127.0.0.1:5500");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String origin = req.getHeader("Origin");
		//esto viene desde el front
		//String origin = ((HttpServletRequest) request).getHeader("origin");

        System.out.println(origin);
		//ese front esta permido?
		if (origin != null && origins.contains(origin)) {
			res.setHeader("Access-Control-Allow-Origin", origin);
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            res.setHeader("Access-Control-Allow-Headers", "Content-Type");
            res.setHeader("Access-Control-Allow-Credentials", "true");
        }

		// Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            res.setStatus(HttpServletResponse.SC_OK);
            return;
        }

		chain.doFilter(request, response);
	}
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
/*
		//Get the Origin header from the request
        String origin = httpRequest.getHeader("Origin");
        
        // Check if the origin is allowed
        if (origin != null && origins.contains(origin)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }
        chain.doFilter(request, response);
        @Override
    public void destroy() {
        // This method is used to clean up any resources used by the filter
    }
		 */
	

