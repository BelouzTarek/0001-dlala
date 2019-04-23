package com.dlala.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlala.params.Constant;

public class RequestFilter implements Filter{

	private FilterConfig filterConfig=null;
	List<String> servletNonFiltre = java.util.Arrays.asList("/connexion","/photos","/annonces","/images");
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    //Setting the character set for the request
	    request.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) request).getSession();
        String path = ((HttpServletRequest) request).getServletPath();
        if(servletNonFiltre.contains(path) || path.isEmpty()) {
        	chain.doFilter( request, response );
        	response.setContentType("text/html; charset=UTF-8");
        	return;
        }
        
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		String redirection = url.substring(0, url.length() - path.length()) + "/";
        
        if ( session.getAttribute( Constant.UTILISATEUR ) == null ) {
            ((HttpServletResponse) response).sendRedirect(redirection);
        } else {
            chain.doFilter( request, response );
        }

	    //Setting the character set for the response
	    response.setContentType("text/html; charset=UTF-8");
		
	}

	@Override
	public void destroy() {
		this.filterConfig=null;
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		
	}

}
