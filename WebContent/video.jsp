<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
	    response.setHeader("Pragma","no-cache"); //HTTP 1.0
	    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	%>
	<%
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<video width="320" height="240" controls>
 	 <source src="https://www.youtube.com/watch?v=wty6OROO__8" type="video/mp4">
 	 <source src="https://www.youtube.com/watch?v=wty6OROO__8" type="video/ogg">
 	 Your browser does not support the video tag.
	</video>
	
	<form action="Logout" >
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>