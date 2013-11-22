<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="market.purchase"%>
<%@page import="market.ordercontroller"%>
<%@page import="market.product"%>
<%@page import="market.Dbmanager"%>
<%@page import="market.productController"%>

    
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
String username =(String) session.getAttribute("username");
%>
<%
ordercontroller oc = new ordercontroller();
ArrayList<purchase> order = oc.searchorder(username);
int ordernumber = order.size();
//System.out.println("++++++++++"+ordernumber);
if(ordernumber == 0){
%>
<h2>
No order in the history
</h2>	
<%
}
%>	

<% 
Iterator<purchase> it = order.iterator();
while(it.hasNext()){
%>
<h3>Order:</h3>

<%
	purchase p = it.next();
	String plist = p.getPlist();
	String[] str = plist.split(",");
	/* int i = str.length;
	System.out.println(i); */
	product pro = new product();
	for(String s : str){
		productController pc = new productController();
		pro = pc.search1product(s);	
		//System.out.println(s);
		String buketLink = "https://console.aws.amazon.com/s3/home?region=us-west-2#";
		
%>

<table border="1" class="table">
<tr>
<tr><td><%=pro.getpname()%></td><td><%=pro.getPrice()%></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=pro.getpname() %>.jpg" class="img-rounded" length="40" width="40"></td></tr>
</tr>
</table>
	
<%
	}
}
%>

</body>
</html>