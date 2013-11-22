package market;

public class UserController {
   
	public static void main(String[] args) throws Exception{
		UserController uc = new UserController();
		users aa = uc.createUser("aa", "nyc", "wu", "xin", "ny", "5 th ave", "suny", "suny", 2, "100001");
		uc.Insteruser(aa);
		//System.out.println( uc.ChenkUserType("hook") );
	}
	public users createUser(String email, String city,String first_name,
			String last_name,String state,String street,String user_name,
			String user_passward,int user_type,String zip) {
		users user = new users();
		user.setEmail(email);
		user.setCity(city);
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setState(state);
		user.setStreet(street);
		//user.setUser_id(user_id);
		user.setUser_name(user_name);
		user.setUser_passward(user_passward);
		user.setUser_type(user_type);
		user.setZip(zip);
		
		return user;
	}
	public int ChenkUserType(String username){
		int type = 0;
		Dbmanager dbm = new Dbmanager();
		type = dbm.checktype(username);
		return type;
	}
	
	public String ChenkUserStatus(String username){
		String status = "";
		Dbmanager dbm = new Dbmanager();
		status = dbm.checkstatus(username);
		return status;
	}
	
	
	public String Chenkpassword(String username){
		String pw = "";
		Dbmanager dbm = new Dbmanager();
		pw = dbm.checkpw(username);
		return pw;
	}
	
	public void Insteruser(users user){
		Dbmanager dbm = new Dbmanager();
		dbm.adduser(user);
		
	}
	public void Deleteuser(String username){
		Dbmanager dbm = new Dbmanager();
		dbm.deleteuser(username);
		
	}
    
}
