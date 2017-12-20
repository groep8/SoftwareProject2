package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.*;

public class StatisticDAO {
	
	public static List getPieData(String arg, String archiveString, String tabel){
		Session session = Main.factory.getCurrentSession();
		List test = null;
		
		try {
			session.beginTransaction();
			
			Query q = session.createNativeQuery("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where archief <= "+archiveString +" group by " + arg);
			test = q.getResultList();
			 
			session.getTransaction().commit();
			
		}
			catch(Exception e) {
				e.printStackTrace();
				
		}
		
		return test;
		
	}
	
	public static List getLineData(String arg, String archiveString, String tabel, String ja){
		Session session = Main.factory.getCurrentSession();
		List test = null;
		
		try {
			session.beginTransaction();
			
			Query q = session.createNativeQuery("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
					+ "archief <= "+archiveString +" and year(beginDatum) = " + ja + " group by " + arg );
			test = q.getResultList();
			 
			session.getTransaction().commit();
			
		}
			catch(Exception e) {
				e.printStackTrace();
				
		}
		
		return test;
		
	}
	
	public static List getBarData(String arg, String archiveString, String tabel, String ja){
		Session session = Main.factory.getCurrentSession();
		List test = null;
		
		try {
			session.beginTransaction();
			
			Query q = session.createNativeQuery("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
					+ "archief <= "+archiveString +" and year(beginDatum) = " + ja + " group by " + arg );
			test = q.getResultList();
			 
			session.getTransaction().commit();
			
		}
			catch(Exception e) {
				e.printStackTrace();
				
		}
		
		return test;
		
	}
	
	
}