package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import model.Login;
import model.Main;
import logic.HashFunctions;

public class LoginDAO {
	public static boolean saveLogin(String username, String password) {
		
		Session session = Main.factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Login temp = new Login();
			temp.setUsername(username);
			temp.setPassword(HashFunctions.getHash(password.getBytes()));
			
			session.save(temp);
			session.getTransaction().commit();
			
		}
		catch(NullPointerException e) {
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public static ArrayList<Login> getAll(){
		Session session = Main.factory.getCurrentSession();
		ArrayList<Login> logins = null;
		try {
			session.beginTransaction();
			logins = (ArrayList<Login>)session.createNativeQuery("select * from Login", Login.class).getResultList();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return logins;
	}
	public static boolean getLogUser(Login user) {
		Session session = Main.factory.getCurrentSession();
		user.setPassword(HashFunctions.getHash(user.getPassword().getBytes()));
		Login log = null;
			try {
				session.beginTransaction();
				log = (Login)session.createNativeQuery("select * from Login where username='" + user.getUsername() +"' and password='"+user.getPassword()+"'", Login.class).getSingleResult();
				if(log.equals(user)) {
					session.getTransaction().commit();
					return true;
				}
				else {
					session.getTransaction().commit();
					return false;
				}

			}
			catch(NoResultException e) {
				session.getTransaction().commit();
				return false;
			}
			catch(Exception e){
				e.printStackTrace();
				session.getTransaction().commit();
				return false;
			}
	}
}

