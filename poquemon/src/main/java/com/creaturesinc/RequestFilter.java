package com.creaturesinc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creaturesinc.entity.RequestLog;
import com.creaturesinc.repository.RequestRepository;

@Component
public class RequestFilter implements Filter{

		RequestRepository repo;
	
		public  RequestFilter() {

		}
		
		@Autowired
		public RequestFilter(RequestRepository repo) {
			this.repo = repo;
		}
	
	   @Override
	   public void destroy() {}

	   @Override
	   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
	      throws IOException, ServletException {
		   String url = "";
		   String queryString = "";
		   HttpServletRequest httpRequest = null;
		   String uri = "";
		   String ip = "";
		   
		   if (request instanceof HttpServletRequest) {
			   url = ((HttpServletRequest)request).getRequestURL().toString();
			   queryString = ((HttpServletRequest)request).getQueryString();
			   httpRequest = (HttpServletRequest)request;
			   uri = httpRequest.getRequestURI();
			   ip = httpRequest.getLocalAddr();
			  }
	      
		   if(uri != null) {
			   registerRequest(uri, ip);
		   }

	      
	      RequestLog requestLog = new RequestLog(request.getRemoteHost(), queryString);
	      
	      filterchain.doFilter(request, response);
	   }

	   @Override
	   public void init(FilterConfig filterconfig) throws ServletException {}
	
	   private void registerRequest(String uri, String ip) {
		   String[] uriParts = uri.split("/");
		   String service = uriParts[(uriParts.length-2)];
		   if(!service.equals("creatures")) {
			   return;
		   }
		   String method = uriParts[(uriParts.length-1)];
		   RequestLog requestLog = new RequestLog(ip, method);
		   String[] partitionedMethod = method.split("\\.");
		   if(partitionedMethod.length<2) {
			   repo.save(requestLog);
		   }
		   
	   }
	   
}
