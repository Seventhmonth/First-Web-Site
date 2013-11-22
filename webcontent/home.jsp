<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome to UAlbany Market</h1>
<%
  int s = 5;
try{
	 s = Integer.parseInt( (String)session.getAttribute("userlevel"));
	}catch(Exception e){
		 	
}

 if(s == 1) { %>
    <a href="logout.jsp">Logout</a><br/>

<%
out.print("Hello,");
out.print((String)session.getAttribute("username"));
%>
	<jsp:include page="user.jsp" />
	
<% }else if(s == 2) {%>
    <a href="logout.jsp">Logout</a>
 <%
out.print("Hello,");
out.print((String)session.getAttribute("username"));
%>   
	<jsp:include page="seller.jsp" />
<%} else if(s == 0){ %>
  <a href="logout.jsp">Logout</a>
 <%
  out.print("Hello,");
  out.print((String)session.getAttribute("username"));
%>   
	<jsp:include page="admi.jsp" />
<% } else {%>
	<a href="login.jsp">Login</a>
	<%} %>
</center>
</body>
</html>