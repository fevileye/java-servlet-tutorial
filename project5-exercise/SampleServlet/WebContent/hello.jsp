<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="java.util.Vector" language="java" %>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Add Student</p>
	
	<form action="Servlet" method="POST" >
		<label> Name : </label> <input name="Nama"/>
		<input type="submit"/>
	</form>
	
	
	<% 
		
		
	%> 
	
	<ul>
		<% 
		if (session.getAttribute("greeting")!=null)
		{
			 Vector listNama=(Vector)session.getAttribute("greeting");
				
		
			for (int i=0;i<listNama.size();i++)
			{
				
				out.print("<li><form action \"Servlet\"> <input name=\"index\" type=\"hidden\" value='"+i+"'>"+(i+1)+listNama.get(i)+" <input type=\"submit\"/> </form></li>");
			}
		}%>
		
	</ul>
	
	
	
</body>
</html>