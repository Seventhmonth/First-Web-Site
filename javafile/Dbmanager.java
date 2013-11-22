package market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Dbmanager {
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	public Connection getConnection(){
			   try{
				   Class.forName("com.mysql.jdbc.Driver");
			   }catch(ClassNotFoundException e){
				   e.printStackTrace();
			   }
			   try{
				   con = (Connection) DriverManager.getConnection("jdbc:mysql:"+
			             "//localhost:3306/UAlbanyMarket","root","root");
			   }catch(SQLException e){
				   e.printStackTrace();
			   }	   
			 return con;
	}
	
	
	
     public ArrayList<product> searchproduct(String username){
    	 con = this.getConnection();
    	 ArrayList<product> pro = new ArrayList<product>();
    	 try{
    		 sql = con.prepareStatement("select * from product where username = ?");
    		 sql.setString(1,username);
    		// System.out.println(sql.toString());
    		 res = sql.executeQuery();
    		 while(res.next()){
    		  String pname = res.getString("pname");
    		  double price = res.getDouble("price");
    		  String desc = res.getString("description");
    		  String cat = res.getString("cat");
    		  int stock = res.getInt("stock");
    		  String url = res.getString("picture");
    		  product p = new product();
    		  p.setCat(cat);
    		  p.setStock(stock);
    		  p.setDesc(desc);
    		  p.setpname(pname);
    		  p.setPrice(price);
    		  p.setpic(url);
    		  pro.add(p);    			 
    		 }
    	 }catch(Exception e){
    		 e.printStackTrace();   		 
    	 }
    	 return pro;
     }
	
     public void addproduct(product po){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into product(username,pname,description,cat,price,stock,picture) value(?,?,?,?,?,?,?)");
    		 sql.setString(1,po.getusername());
    		 sql.setString(2,po.getpname());
    		 sql.setString(3,po.getDesc());
    		 sql.setString(4,po.getCat());
    		 sql.setDouble(5,po.getPrice());
    		 sql.setInt(6,po.getStock());
    		 sql.setString(7, po.getpic());
    		 //System.out.println(sql.toString());
    		 sql.executeUpdate();   		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
     public void addpicture(String url){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into product(picture) value(?)");
    		 sql.setString(1,url);
    		// System.out.println(sql.toString());
    		 sql.executeUpdate();   		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
    
     public void addpurchase(purchase order){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into purchase(username,order_type,plist,total_price) value(?,?,?,?)");
    		 sql.setString(1,order.getUsername());
    		 sql.setInt(2,order.getOrdertype());
    		 // i make all pname to a string store in the database
    		 sql.setString(3,order.getPlist());
    		 sql.setDouble(4,order.getTotalprice());
    		 System.out.println(sql.toString());
    		 sql.executeUpdate();   		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
     public void adduser(users user){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into users value(?,?,?,?,?,?,?,?,?,?,?)");
    		 sql.setString(1,user.getCity());
    		 sql.setString(2,user.getEmail());
    		 sql.setString(3,user.getFirst_name());
    		 sql.setString(4,user.getLast_name());
    		 sql.setString(5,user.getState());
    		 sql.setString(6,user.getStreet());
    		 sql.setString(7,user.getUser_name());
    		 sql.setString(8,user.getUser_passward());
    		 sql.setString(9,user.getZip());
    		 sql.setInt(10,user.getUser_type());  
    		 sql.setString(11, "FALSE");
    		 sql.executeUpdate();
    	 }catch(Exception e){
    	 e.printStackTrace();
    	 }
     }
     
    
     public int checktype(String username){
    	 int type = 0;
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("select user_type from users where user_name = ?");
    		 sql.setString(1,username);
    		 res = sql.executeQuery();
    		 res.next();
    		 type = res.getInt("user_type"); 		 		 
    	 }catch(SQLException e){
    		 	return Integer.MAX_VALUE;
    		 }
    	 
    	 return type;
     }
     
     public product search1product(String pname){
    	 con = this.getConnection();    	 
    	 product p = new product();
    	 try{
    		 sql = con.prepareStatement("select * from product where pname = ?");
    		 sql.setString(1,pname);
    		 //System.out.println(sql.toString());
    		 res = sql.executeQuery();
    		 res.next();
    		 String productname = res.getString("pname");
    	     double price = res.getDouble("price");
    	     String desc = res.getString("description");
    	     String cat = res.getString("cat");
    	     String username = res.getString("username");
    	     int stock = res.getInt("stock");
    	     String url = res.getString("picture");
    	     p.setCat(cat);
   		     p.setDesc(desc);
   		     p.setusername(username);
   		     p.setPrice(price);  
   		     p.setpname(productname);
   		     p.setStock(stock);
   		     p.setpic(url);
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }    	
    	 return p;
     }
     
     public ArrayList<review> checkreview(String username){
    	ArrayList<review> review = new ArrayList<review>();
    	con = this.getConnection();
    	try{
    		sql = con.prepareStatement("select * from review where username = ?");
   		    sql.setString(1,username);
   		  //  System.out.println(sql.toString());
   		    res = sql.executeQuery();
   		    while(res.next()){
   		    	String content = res.getString("content");
   		    	review re = new review();
   		    	re.setContent(content);
   		    	review.add(re);  		    	
   		    }   		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	 return review;
     }
     
     public ArrayList<purchase> searchorder(String username){
     	ArrayList<purchase> order = new ArrayList<purchase>() ;
     	con = this.getConnection();
     	try{
     		 sql = con.prepareStatement("select *  from purchase where username = ?");
    		 sql.setString(1,username);
    		 System.out.println(sql.toString());
    		 res = sql.executeQuery();
    		 while(res.next()){
    			 String plist = res.getString("plist");
    			 double totalprice = res.getDouble("total_price");
    			 int ordertype = res.getInt("order_type");
    			// int orderid = res.getInt("orderid");
    			 purchase pur = new purchase();
    			 pur.setOrdertype(ordertype);
    			 pur.setPlist(plist);
    			// pur.setOrderid(orderid);
    			 pur.setTotalprice(totalprice);
    			 order.add(pur);    			 
    		 }     		
     	}catch(Exception e){
     		e.printStackTrace();
     	}
     	 return order;
      }
 //get the biggest orderid  change it type to 1
     public void changeotype(){
    	 con = this.getConnection();
    	 int maxid = 0;
    	 try{
    		 sql = con.prepareStatement("select max(order_id) from purchase");
    		 res = sql.executeQuery();
    		 res.next();
    		 int id = res.getInt("max(order_id)");
    		 maxid = id;

    		 sql = con.prepareStatement("update purchase set order_type=? where order_id = ?");

    		 sql.setInt(1,1);
    		 sql.setInt(2, maxid);
    		 System.out.println(sql.toString());
    	     sql.executeUpdate();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
      }
     
     public ArrayList<String> searchcartprodcut(String username){
    	 ArrayList<String> p = new ArrayList<String>();
    	 con = this.getConnection();
    	 try{
     		 sql = con.prepareStatement("select * from cart where username = ?");
    		 sql.setString(1,username);
    		 System.out.println(sql.toString());
    		 res = sql.executeQuery();
    		 while(res.next()){
    			 String pname = res.getString("pname");
    			 p.add(pname);
    		 }
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
    	 return p;  	 
     }
     public void addreview(String username,String review){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into review value(?,?)");
    		 sql.setString(1, username);
    		 sql.setString(2, review);
    		 System.out.print(sql.toString());
    		 sql.executeUpdate();  		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     public void addproducttocart(String username,String pname){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("insert into cart value(?,?)");
    		 sql.setString(1, username);
    		 sql.setString(2, pname);
    		 System.out.println(sql.toString());
    		 sql.executeUpdate();  		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
     public double checkprice(String pname){
    	 double price = 0;
    	 con = this.getConnection();
      	try{
      		 sql = con.prepareStatement("select * from product where pname = ?");
     		 sql.setString(1,pname);
     		 res = sql.executeQuery();
     		 res.next();
     		 double pri = res.getDouble("price");
     		 price = pri;
      	}catch(Exception e){
      		e.printStackTrace();
      	}
    	 return price;
     }
     
     public String checkstatus(String username){
    	 String status = "";
    	 con = this.getConnection();
      	try{
      		 sql = con.prepareStatement("select * from users where user_name = ?");
     		 sql.setString(1,username);
     		 res = sql.executeQuery();
     		 System.out.println(sql.toString());
     		 res.next();
     		 String sta = res.getString("is_delete");
     		 status = sta;
     		 System.out.println(status);
      	}catch(Exception e){
      		e.printStackTrace();
      	}
    	 return status;
     }
     
     public String checkpw(String username){
    	 String pw = "";
    	 con = this.getConnection();
      	try{
      		 sql = con.prepareStatement("select * from users where user_name = ?");
     		 sql.setString(1,username);
     		 res = sql.executeQuery();
     		 res.next();
     		 String paw = res.getString("user_password");
     		 pw = paw;
      	}catch(Exception e){
      		e.printStackTrace();
      	}
    	 return pw;
     }
     
     public void deletecart(String username){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("delete from cart where username=?");
    		 sql.setString(1, username);
    		 System.out.println(sql.toString());
    		 sql.executeUpdate();  		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     //need to delete username as foreign key
     public void deleteuser(String username){
    	 con = this.getConnection();
    	 try{
    		 sql = con.prepareStatement("update users set is_delete = ? where user_name = ?");
    		 sql.setString(1, "TRUE");
    		 sql.setString(2, username);
    		 System.out.println(sql.toString());
    		 sql.executeUpdate();  		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
}
