<%@page import="com.service.DeleteService"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.model.dao.CheckUserType"%>
<%@page import="java.io.PrintWriter" %>
<%@page import="com.service.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deny</title>
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
			
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				int deleteProductId = Integer.parseInt(String.valueOf(request.getParameter("productId")));
				//Denying Service is getting called.
				ApproveService deny = new ApproveService();
				deny.denyProductRequest(userName, deleteProductId);
				response.sendRedirect("AfterDeny.jsp");
			}
			
		%>
</body>
</html>