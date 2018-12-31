package service;

import java.util.ArrayList;

import dao.Dao;
import entity.User;

public class UserService extends Dao<User> {
	public User getUserByLoginPass(String login, String password) {
		return this.getByLogin(login, password, "User");
	}

	public boolean addUser(User user) {
		return this.add(user);
	}

	public boolean updateUser(User user) {
		return this.update(user);
	}

	public boolean deleteUser(User user) {
		return this.delete(user.getIduser(), User.class);
	}

	public ArrayList<User> getAllUser() {
		return this.getAll("User");
	}

	public User getUserById(int idUser) {
		return this.getById(idUser, User.class);
	}

	public int countAllUser() {
		return this.getCount("User");
	}
}
