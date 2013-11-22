package market;

import static org.junit.Assert.*;

import org.junit.Test;

public class usersTest {

	@Test
	public void testSetUser_name() {	
		users user = new users();
		user.setUser_name("July");
		assertEquals("Is the username correct?", "July", user.getUser_name());
	}

	@Test
	public void testSetUser_passward() {
		users user = new users();
		user.setUser_passward("july");
		assertEquals("Is the password correct?", "july", user.getUser_passward());
	}

	@Test
	public void testSetLast_name() {
		users user = new users();
		user.setLast_name("Kobe");
		assertEquals("Is the Lastname correct?", "Kobe", user.getLast_name());
	}

	@Test
	public void testSetFirst_name() {
		users user = new users();
		user.setFirst_name("Bryrant");
		assertEquals("Is the Firstname correct?", "Bryrant", user.getFirst_name());
	}

	@Test
	public void testSetEmail() {
		users user = new users();
		user.setEmail("123@gmail.com");
		assertEquals("Is the email correct?", "123@gmail.com", user.getEmail());
	}

	@Test
	public void testSetState() {
		users user = new users();
		user.setState("NY");
		assertEquals("Is the state correct?", "NY", user.getState());
	}

	@Test
	public void testSetCity() {
		users user = new users();
		user.setCity("albany");
		assertEquals("Is the city correct?", "albany", user.getCity());
	}

	@Test
	public void testSetStreet() {
		users user = new users();
		user.setStreet("NorthAllen");
		assertEquals("Is the street correct?", "NorthAllen", user.getStreet());
	}

}
