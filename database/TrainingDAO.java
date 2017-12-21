package database;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Adres;
import model.Leerkracht;
import model.Main;
import model.Training;
import model.TrainingDetail;


public class TrainingDAO  {
	
	
	public static boolean saveTraining(TrainingDetail td, int adresId, int leerkrachtId) {

		Session session = Main.factory.getCurrentSession();


		try {
		
			session.beginTransaction();
			
			Adres a = session.get(Adres.class, adresId);
			Leerkracht l = session.get(Leerkracht.class, leerkrachtId);
			
			td.getTraining().setAdres(a);
			td.getTraining().setLeerkracht(l);
			
			//saving the new Training object
			session.save(td);

			session.getTransaction().commit();	
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
			
		return false;
			}
		
		return true;
	}
	
	public static ArrayList<TrainingDetail> getall() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<TrainingDetail> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<TrainingDetail>)session.createNativeQuery("SELECT td.* FROM Training t, TrainingDetail td WHERE t.idTraining = td.idTraining", TrainingDetail.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
	}
		return tds;
	}
	
	
	public static ArrayList<Training> getallt() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Training> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Training>)session.createNativeQuery("SELECT td.* FROM Training t, TrainingDetail td WHERE t.idTraining = td.idTraining", Training.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
	}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
	}
		return tds;
	}
	
	
	public static ArrayList<Training> getall2() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Training> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Training>)session.createNativeQuery("SELECT * from Training", Training.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
	}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
			
	}
		return tds;
	}
	
	public static void updateTrainingName(int id, String trainingNaam){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
        t.setTrainingNaam(trainingNaam);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
		}


    }
	
}
