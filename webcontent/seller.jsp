<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="market.productController"%>
<%@page import="market.product"%>
<%@page import="market.review"%>
<%@page import="market.reviewController"%>
<%@page import="market.UserController"%>
<%@page import="market.Dbmanager"%>

    
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
String username =(String)session.getAttribute("username");
String sellername = (String)request.getParameter("seller");
String productname = (String)request.getParameter("product");
%>
<%

UserController uc = new UserController();
String status = uc.ChenkUserStatus(sellername);
/* if(status.equals("TRUE")){
	
	response.sendRedirect("home.jsp");
} */


%>
<%
  int s = 0;
try{
	 s = Integer.parseInt( (String)session.getAttribute("userlevel"));
	}catch(Exception e){		 	
}
%>

<%
if(s == 2) {
%>
<h3>The products you are selling:</h3>
<%
productController pc = new productController();
ArrayList<product> plist = new ArrayList<product>();
plist = pc.checkproduct(username);
Iterator<product> it = plist.iterator();
while(it.hasNext()){
 product p = it.next();	
%>
<table border="1" class="table">
<tr><td><%=p.getpname()%></td><td><%=p.getPrice()%></td><td><%=p.getStock()%></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=p.getpname() %>.jpg" class="img-rounded" length="40" width="40"></td></tr>
</table>
<%
  }
}

if(s == 1 && sellername!= null && sellername.equals("") == false && ("submit").equals(request.getParameter("button")) == false && !status.equals("TRUE")) {
out.println(sellername);
%>
<h3>Products the seller are selling:</h3> 
<% 
productController pc = new productController();
ArrayList<product> plist = new ArrayList<product>();
plist = pc.checkproduct(sellername);
Iterator<product> it = plist.iterator();
while(it.hasNext()){
 product p = it.next();	
%>
<table border="1" class="table">
<tr><td><%=p.getpname()%></td><td><%=p.getPrice()%></td><td><%=p.getStock()%></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=p.getpname() %>.jpg" class="img-rounded" length="40" width="40"></td></tr>
</table>
<form method="post" action="cart.jsp"> 
<input type="hidden" name="pname" value="<%= p.getpname() %>">
<input type="hidden" name="price" value="<%= p.getPrice() %>">
<input type="submit" name="button" value="addtocart">
</form>
<%
  }
}
%>

<%
if(s == 1 && productname != null && productname.equals("") == false  && sellername.equals("")) {
out.println("The product you search: ");
productController pc = new productController();
product pro = new product();
String buketLine = "https://s3-us-west-2.amazonaws.com/qijunliu1113/";
pro = pc.search1product(productname);
%>
<table class="table">
<tr><td><%=pro.getpname()%></td><td><%=pro.getPrice()%></td><td><%=pro.getStock()%></td><td><img src="https://s3-us-west-2.amazonaws.com/qijunliu1113/<%=pro.getpname() %>.jpg" class="img-rounded" length="40" width="40"></td></tr>
</table>
<form method="post" action="cart.jsp"> 
<input type="hidden" name="pname" value="<%= pro.getpname() %>">
<input type="hidden" name="price" value="<%= pro.getPrice() %>">
<input type="submit" name="button" value="addtocart"></form>


<%
  }
%>




<ul>
<%
if(s == 2){
ArrayList<review> review = new ArrayList<review>();
review = reviewController.showreview(username);
Iterator<review> it = review.iterator();
%>
<h3>The review you have get:</h3>


<% 
while(it.hasNext())
{
	review re = it.next();
%>
	<table class="table">
		
			<tr>
				<td ><%=re.getContent() %></td>
			</tr>
	</table>
<%
 }
} %>	
</ul>


<%
	if(s == 1){
%>
<form action="seller.jsp" method="post">
		<input type="text" name="review" placeholder="Please enter the review" /><br/>
		<input type="submit" name="button" value="submit" />
		<input type="hidden" name="seller" value="<%= sellername %>"/><br/>
</form>
	<% if(("submit").equals(request.getParameter("button"))) { 
		 String review = request.getParameter("review");
		 reviewController rc = new reviewController();
		 rc.storereview(sellername, review);
		 response.sendRedirect("home.jsp");
	 } 
} %>

<%
if(s == 2){
%>
<form action="upload" method="post" enctype="multipart/form-data" >
<h3>Add your new product here:</h3> <br/>
                             <input type="text" name="username" placeholder="username"/><br/>
                             <input type="text" name="pname" placeholder="productname"/><br/>
                             <input type="text" name="desc"placeholder="desription"/><br/>
                             <input type="text" name="cat"placeholder="category"/><br/>
                             <input type="text" name="price"placeholder="price"/><br/>
                             <input type="text" name="stock"placeholder="stock"/><br/>
                            
                           picture:    <input type="file" name="pic"/></br>
                           <input type="submit" name="button" value="add">                      
</form>
<% /* if(("add").equals(request.getParameter("button"))) { 
	 String name = request.getParameter("username");
	 String pname = request.getParameter("pname");
	 String desc = request.getParameter("desc");
	 String cat = request.getParameter("cat");
	 String url = request.getParameter("file");
	 String pic = pname + ".jpg";
	 Double price = Double.parseDouble(request.getParameter("price"));
	 int stock = Integer.parseInt(request.getParameter("stock"));
	 productController pc = new productController();
	 product po = new product();
	 po = pc.createproduct(name, price, stock, desc, cat, pname, pic);
	 pc.addproduct(po);
	 //add the pic to S3
	 Part filePart = request.getPart("pic");
	
  } */
}
%>

<!-- <input type="file" id="file" >
<input type="button" value="Upload picture" onClick="get()">
<script type="text/javascript">
function get(){			
var filePath= document.getElementById("file");
var filePathValue = filePath.value;
Dbmanager dbm = new Dbmanager();
dbm.addpicture(filePathValue);
}	
</script> -->


</body>           
</html>