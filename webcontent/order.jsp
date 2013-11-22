<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="market.cartController"%>
    <%@page import="market.productController"%>
    <%@page import="market.ordercontroller"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="./bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<%
String username =(String)session.getAttribute("username");
%>
<% 
cartController cc = new cartController();
ArrayList<String> plist = new ArrayList<String>();
plist = cc.searchcartproduct(username);
Iterator<String> it = plist.iterator();
double price = 0;
while(it.hasNext()){
	String pname = it.next();	
	productController pd = new productController();
    double pi = pd.checkprice(pname);
 %>
 <table border="1" class="table">
<tr><td> product name:<%=pname%></td><td>product price: <%= pi %></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=pname %>.jpg" class="img-rounded" length="40" width="40"></td></tr>
</table>
 
 <% 
	price += pi;	
 }
 %>
 <table border="1" class="table">
<tr><td>The total price is :<%= price %></td></tr>
</table>


<form action="paypal.jsp" method="post">
<input type="submit" name="button" value="paypal"/>
<input type="hidden" name="totalprice" value="<%=price%>"></form>


</body>
</html>