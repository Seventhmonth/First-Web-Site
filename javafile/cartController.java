package market;
import java.util.ArrayList;


public class cartController {
    
	public ArrayList<String> searchcartproduct(String username){
		Dbmanager dbm = new Dbmanager();
		ArrayList<String> p = new ArrayList<String>();
		p = dbm.searchcartprodcut(username);
		return p;		
	}
	public void addproducttocart(String username,String pname){
		Dbmanager dbm = new Dbmanager();
		dbm.addproducttocart(username, pname);
	}
	public void delete(String username){
		Dbmanager dbm = new Dbmanager();
		dbm.deletecart(username);
	}
	

}
