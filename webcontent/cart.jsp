<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.Iterator"%>
    <%@page import="java.util.ArrayList"%>
     <%@page import="market.cartController"%>
     <%@page import="market.productController"%>
     <%@page import="market.ordercontroller"%>
     <%@page import="market.purchase"%>
     <%@page import="market.product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<% 
String pname = request.getParameter("pname");
String price1 = request.getParameter("price");
String username = (String)session.getAttribute("username");

if( pname != null && ("createorder").equals(request.getParameter("button")) == false) { 
	cartController cc = new cartController();
	cc.addproducttocart(username, pname);
}

ArrayList<String> productname = new ArrayList<String>();
cartController control = new cartController();
productname = control.searchcartproduct(username);
Iterator<String> ite = productname.iterator();
%>
<h3>Previous selected product: </h3>
<% 
while(ite.hasNext()){
	String pro = (String)ite.next();
	productController  pc = new productController();
	product p = pc.search1product(pro);
%>
<table border="1" class="table"><tr><td><%=p.getpname() %></td><td><%=p.getPrice() %></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=p.getpname() %>.jpg" class="img-rounded" length="40" width="40"></td></tr></table>

<% 	

}
%>

<form action="cart.jsp" methond="post">
<input type="submit" name="button" value="Back to Search"/>
<%if(("Back to Search".equals(request.getParameter("button"))) && ("createorder").equals(request.getParameter("button")) == false){
%>
	<jsp:forward  page="home.jsp"/>
<% 
}
%>

<form action="cart.jsp" methond="post">
<input type="submit" name="button" value="createorder"/>
<% if(("createorder").equals(request.getParameter("button"))) { 
   //store cart info to order
   cartController cartcon = new cartController();
   ArrayList<String> plist = new ArrayList<String>();
   //it should be a string of all pname store in a order
   String allpname = "";
   plist = cartcon.searchcartproduct(username);
   double price = 0;
   Iterator<String> it = plist.iterator();
   productController pc = new productController();
   while(it.hasNext()){
	   String eachpname = it.next();
	   double eachprice = pc.checkprice(eachpname);
	   price += eachprice; 
	   allpname = allpname + eachpname + ",";
   }
   
   ordercontroller oc = new ordercontroller();
   purchase order = oc.createorder(price, allpname, username, 0);
   oc.storeorder(order);	
 %>
 <jsp:forward  page="order.jsp"/>
 
 <% 
 } 
 %>
</form>

</body>
</html>