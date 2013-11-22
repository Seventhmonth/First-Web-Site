<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="market.UserController"%>
    <%@page import="market.users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> welcome to register</h1>
<form action="register.jsp"  method ="post">
Username <input type="text" name="username" /> <br/>
Password <input type="password" name="password" value=""/> <br/>
Firstname <input type="text" name="firstname" /> <br/>
Lastname <input type="text" name="lastname" /> <br/>
email <input type="text" name="email" /> <br/>
state <input type="text" name="state" /> <br/>
city <input type="text" name="city" /> <br/>
street <input type="text" name="street" /> <br/>
zip <input type="text" name="zip" /> <br/>
usertype:buyer please type 1,seller please type 2,admi please input 0<input type="text" name="usertype" /> <br/>
<input type="submit" name="button" value="submit"  /><br/>
<% if(("submit").equals(request.getParameter("button"))) { 
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String lastname = request.getParameter("lastname");
	String firstname = request.getParameter("firstname");
	String street = request.getParameter("street");
	String city = request.getParameter("city");
	String state = request.getParameter("state");
	String zip = request.getParameter("zip");
	int usertype = Integer.parseInt(request.getParameter("usertype"));	

	UserController us = new UserController();
	users user = new users();
	
	user = us.createUser(email, city, firstname, lastname, state, street, username, password, usertype, zip);
	us.Insteruser(user);
%>
<h1>Register successful!</h1>
<a href="login.jsp">Goto LogIn</a>	
<%}%>



</body>
</html>