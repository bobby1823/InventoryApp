<%@page import="com.service.DeleteService"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.model.dao.CheckUserType"%>
<%@page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
		<%
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
		    response.setHeader("Pragma","no-cache"); //HTTP 1.0
		    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
		%>
		<%
			HttpSession sessionObject = request.getSession();
			String userName = sessionObject.getAttribute("username").toString();
			int deleteProductId = Integer.parseInt(String.valueOf(request.getParameter("productId")));
			//Delete Service is getting called.
			DeleteService deleteService = new DeleteService();
			deleteService.deleteProduct(userName, deleteProductId);
			response.sendRedirect("AfterDelete.jsp");
			/* if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				
			}
			response.setContentType("text/html");
		    PrintWriter op = response.getWriter();

		    op.println("<html>");
		    op.println("<head>");
		    op.println("<title>Delete</title>");
		    op.println("</head>");
		    op.println("<body bgcolor=\"blue\">");
		    op.println("</body>");
		    op.println("</html>"); */
		%>
</body>
</html>