package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User;

public interface UserService {
	public void save(User user);

	public List<User> getUser();
	
	public void saveRole(User user, String role);

	public User getUser(String username);
}
