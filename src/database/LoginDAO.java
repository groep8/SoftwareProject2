package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import model.HashFunctions;
import model.Login;
import model.Main;

public class LoginDAO {	
	public static boolean saveLogin(Login l) {
		
		Session session = Main.factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Login temp = new Login();
			temp.setUsername(l.getPassword());
			temp.setPassword(HashFunctions.getHash(l.getPassword().getBytes()));
			temp.setAdmin(l.isAdmin());
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
	public static ArrayList<Login> getAllVis(){
		Session session = Main.factory.getCurrentSession();
		ArrayList<Login> logins = null;
		try {
			session.beginTransaction();
			logins = (ArrayList<Login>)session.createNativeQuery("select * from Login where archief=0", Login.class).getResultList();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return logins;
	}
	public static ArrayList<Login> getAllArch(){
		Session session = Main.factory.getCurrentSession();
		ArrayList<Login> logins = null;
		try {
			session.beginTransaction();
			logins = (ArrayList<Login>)session.createNativeQuery("select * from Login where archief=1", Login.class).getResultList();
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
			try {
				session.beginTransaction();
				Main.currentLogged = (Login)session.createNativeQuery("select * from Login where username='" + user.getUsername() +"' and password='"+user.getPassword()+"' and archief='false'", Login.class).getSingleResult();
				if(Main.currentLogged.equals(user)) {
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
	public static boolean delUser(int idLogin) {
		Session session = Main.factory.getCurrentSession();
		try {
			session.beginTransaction();
			Login temp = (Login) session.get(Login.class, idLogin);
			temp.setArchief(true);
			session.getTransaction().commit();
			return true;
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
	public static boolean undelUser(int idLogin) {
		Session session = Main.factory.getCurrentSession();
		try {
			session.beginTransaction();
			Login temp = (Login) session.get(Login.class, idLogin);
			temp.setArchief(false);
			session.getTransaction().commit();
			return true;
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
	public static boolean modUser(Login l) {
		Session session = Main.factory.getCurrentSession();
		try {
			session.beginTransaction();
			Login temp = (Login) session.get(Login.class, l.getIdLogin());
			temp.setUsername(l.getUsername());
			temp.setPassword(l.getPassword());
			temp.setAdmin(l.isAdmin());
			session.getTransaction().commit();
			return true;
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

