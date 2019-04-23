package com.dlala.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dlala.params.Constant;

public class RestrictionFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
        HttpSession session = ((HttpServletRequest) request).getSession();

  
        if ( session.getAttribute( Constant.UTILISATEUR ) == null ) {
            request.getRequestDispatcher("/").forward( request, response );
        } else {
            chain.doFilter( request, response );
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
