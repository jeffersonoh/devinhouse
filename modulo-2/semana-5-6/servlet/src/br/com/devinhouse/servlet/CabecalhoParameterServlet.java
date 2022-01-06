package br.com.devinhouse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CabecalhoParameterServlet extends HttpServlet {

	private static final long serialVersionUID = 5840501935678537227L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enumeration headerNames = request.getHeaderNames();
		List<String> lHeaderN = new ArrayList<String>();

		String headerNamesForHtml = new String();

		while (headerNames.hasMoreElements()) {
			String HeaderName = (String) headerNames.nextElement();
			lHeaderN.add(HeaderName + "=" + request.getHeader(HeaderName));
			headerNamesForHtml += (String) headerNames.nextElement() + "=" + request.getHeader(HeaderName) + "<br/>";
		}

		PrintWriter out = response.getWriter();
		out.append(lHeaderN.toString());
	}
}
