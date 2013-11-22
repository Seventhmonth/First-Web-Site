package market;
import java.util.ArrayList;
import java.util.Iterator;


public class purchase {
   private int ordertype;
   private String plist;
   private double totalprice;
   private String username;
   private int orderid;
   
public int getOrdertype() {
	return ordertype;
}
public void setOrdertype(int ordertype) {
	this.ordertype = ordertype;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getPlist() {
	return  plist;
}
/*public void setPlist(ArrayList<String> p) {
	Iterator<String> it = p.iterator();
	String plist = null;
	String pname = it.next();
	while(it.hasNext()){
		plist = pname + ",";		
	}	
	this.plist = plist;
}*/
public void setPlist(String plist){
	this.plist = plist;
}

public double getTotalprice() {
	return totalprice;
}
public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
//public int getOrderid() {
	//return orderid;
//}
//public void setOrderid(int orderid) {
	//this.orderid = orderid;
//}
   
   

}
