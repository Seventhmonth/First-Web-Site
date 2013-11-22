<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="market.ordercontroller"%>
    <%@page import="market.cartController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uname = (String)session.getAttribute("username");
String price = request.getParameter("totalprice");
%>
<%  cartController cartc = new cartController();
    cartc.delete(uname);
    //update the ordertype in the biggest orderid to 1 
    ordercontroller oc = new ordercontroller();
    oc.changeordertype();
%>

<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" name="paypal_form" id="paypal_form">
<input type="hidden" name="cmd" value="_cart">
<input type="hidden" name="upload" value="1">
<input type="hidden" name="business" value="beauty1298@gmail.com">
<input type="hidden" name="item_name_1" value="Total">
<input type="hidden" name="amount_1" value="<%=price%>">
<input type="image" src="https://www.sandbox.paypal.com/en_US/i/btn/btn_xpressCheckout.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.sandbox.paypal.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>


</body>
</html>