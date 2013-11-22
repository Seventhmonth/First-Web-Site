package market;
import java.util.ArrayList;

//import com.sun.tools.javac.util.List;


public class productController {
	

	public product createproduct(String username,double price,int stock,String desc,
			String cat,String pname,String pic){
		product pro = new product();
		pro.setCat(cat);
		pro.setDesc(desc);
		pro.setPrice(price);
		pro.setusername(username);
		pro.setStock(stock);
		pro.setpname(pname);
		pro.setpic(pic);
		return pro;		
	}
//	public product createproduct(String url){
//		
//		product pro = new product();
//		pro.seturl(url);
//		return pro;
//	}

	public ArrayList<product> checkproduct(String username){
		ArrayList<product> pro = new ArrayList<product>();
		Dbmanager dbm = new Dbmanager();
		pro = dbm.searchproduct(username);
		return pro;
	}
	
	public void addproduct(product po){
		Dbmanager dbm = new Dbmanager();
		dbm.addproduct(po);
	}
	
	public product search1product(String pname){
		product p = new product();
        Dbmanager dbm = new Dbmanager();
        p = dbm.search1product(pname);
		return p;
	}
	public double checkprice(String pname){
		Dbmanager dbm = new Dbmanager();
		double price = dbm.checkprice(pname);
		return price;
		
	}

}
