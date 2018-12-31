package test;

import entity.User;
import service.UserService;

public class Mail {

	public static void main(String[] args) {
		User user = new User("azer", "qwer", "azer@wqer.az", "azer", "123456");
		UserService us = new UserService();
		us.addUser(user);
		/*user = us.getUserById(1);
		user.setNom("abd");
		user.setPrenom("ben");
		user.setLogin("abdben");
		user.setEmail("abd@ben.ka");
		user.setPassword("123456");
		
		us.updateUser(user);
		ContactService cs = new ContactService();
		cs.add(new Contact("anas", "Abel", "0615487933", us.getUserById(1)));
		*/
	}

}
