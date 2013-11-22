<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="market.UserController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="./bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<form  method = "post" class="form-search">
 <input type="text" name="deletename" placeholder="user you want to delete"/>
                         <input type="submit" name="button" value="delete" /><br/>
</form>
<%if(("delete").equals(request.getParameter("button"))) { 
    String username = (String)request.getParameter("deletename");
    UserController uc = new UserController();
    uc.Deleteuser(username);	
}

%>


</body>
</html>