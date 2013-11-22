<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello,
</title>
<link href="./bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<center>



<form action = "seller.jsp" method = "post"  class="form-search">
 <input type="text" name="seller" placeholder="seller"/> <input type="submit" value="search" /><br/>
<input type="text" name="product"placeholder="product" /> <input type="submit" value="search"  /><br/> 
</form>

<form action="orderlist.jsp" method="post" class="form-search">
<input type="submit" name="button" value="searchorder" /><br/>
</form>

<a href="cart.jsp">Go to cart to check</a>


</center>

</body>
</html>