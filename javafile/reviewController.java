package market;
import java.util.ArrayList;


public class reviewController {
	
    public static ArrayList showreview(String username){
    	ArrayList<review> review = new ArrayList<review>();
    	Dbmanager dbm = new Dbmanager();
    	review = dbm.checkreview(username);    	
    	return review;  	
    }
    
    public void storereview(String username,String review){
    	Dbmanager dbm = new Dbmanager();
    	dbm.addreview(username,review);
    }
	

}
