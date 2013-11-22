package market;
import java.util.ArrayList;


public class ordercontroller {
     
	public static ArrayList<purchase> searchorder(String username){
		ArrayList<purchase> order = null;
		Dbmanager dbm = new Dbmanager();
		order = dbm.searchorder(username);		
		return order;		
	}
	
// plist!!!have problem!!!!
	public purchase createorder(double totalprice, String plist,String username,int ordertype){
			purchase order = new purchase();
			//order.setOrderid(orderid);
			order.setOrdertype(ordertype);
			order.setPlist(plist);
			order.setTotalprice(totalprice);
			order.setUsername(username);			
			return order;		
	}
		
		

	
	public void changeordertype(){
	Dbmanager dbm = new Dbmanager();
	dbm.changeotype();   
	}
	
	public void storeorder(purchase order){
		Dbmanager dbm = new Dbmanager();
		dbm.addpurchase(order);
	}
	

}
  