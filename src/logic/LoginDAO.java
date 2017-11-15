package logic;

import java.util.List;

public interface LoginDAO {
	Login getLogin(String username);
	List<Login> getAllLogins();
	List<String> getUsers();
	List<String> getPass();
}