package database;



import java.io.Serializable;
import java.time.LocalDate;
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
	public static boolean saveTraining(Training td, int adresId, int leerkrachtId) {

		Session session = Main.factory.getCurrentSession();
		
		


		try {
		
			session.beginTransaction();
			
			Adres a = session.get(Adres.class, adresId);
			Leerkracht l = session.get(Leerkracht.class, leerkrachtId);
			td.setAdres(a);
			td.setLeerkracht(l);
			/*td.getTraining().setAdres(a);
			td.getTraining().setLeerkracht(l);*/
			
			//saving the new Training object
			session.save(td);

			session.getTransaction().commit();	
			session.close();
			return true;
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			return false;
		
			}
		
		
	}
	
	public static ArrayList<Training> getall() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Training> tds = null;
		try {
		session.beginTransaction();
		tds = (ArrayList<Training>)session.createNativeQuery("SELECT * FROM Training where archief=0", Training.class).getResultList();


		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			session.close();
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
	
	public static ArrayList<Leerkracht> getallLeerkracht() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Leerkracht> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Leerkracht>)session.createNativeQuery("SELECT * FROM Leerkracht where archief=0", Leerkracht.class).getResultList();
		

		session.getTransaction().commit();
		
	}
		catch(Exception e) {
			e.printStackTrace();
			
	}
		return tds;
	}
	
	public static ArrayList<Leerkracht> getallLeerkrachtDelete() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Leerkracht> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Leerkracht>)session.createNativeQuery("SELECT * FROM Leerkracht where archief=1", Leerkracht.class).getResultList();
		

		session.getTransaction().commit();
		
	}
		catch(Exception e) {
			e.printStackTrace();
			
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
			session.close();
			e.printStackTrace();
			session.close();
		}


    }
	public static ArrayList<Adres> getadres() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Adres> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Adres>)session.createNativeQuery("SELECT * from Adres where archief =0", Adres.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			
	}
		return tds;
	}
	public static ArrayList<Adres> getadresDelete() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Adres> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Adres>)session.createNativeQuery("SELECT * from Adres where archief =1", Adres.class).getResultList();
		

		session.getTransaction().commit();
		
	}
		catch(Exception e) {
			e.printStackTrace();
			
	}
		return tds;
	}
	
	public static ArrayList<Leerkracht> getLeerkracht() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Leerkracht> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Leerkracht>)session.createNativeQuery("SELECT * from Leerkracht where archief=0", Leerkracht.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			
	}
		return tds;
	}
	
	public static void updateTrainingLeerkracht(int id, Leerkracht idleerkracht){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
       
        t.setLeerkracht(idleerkracht);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateTrainingAdres(int id, Adres adres){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
       
        t.setAdres(adres);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	
	public static void updateTrainingDatum(int id, LocalDate datum){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
        t.setBeginDatum(datum);


        session.getTransaction().commit();
        
		}
		catch(Exception e) {
			e.printStackTrace();
		}


    }
	public static void updateEindeTrainingDatum(int id, LocalDate datum){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
       
       t.setEindDatum(datum);


        session.getTransaction().commit();
        
		}
		catch(Exception e) {
			e.printStackTrace();
		}

    }
	public static ArrayList<Training> getallDelete() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Training> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Training>)session.createNativeQuery("SELECT * FROM Training where archief=1", Training.class).getResultList();
		

		session.getTransaction().commit();
		
	}
		catch(Exception e) {
			e.printStackTrace();
			
	}
		return tds;
	}
	
	public static void deleteknop(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
        t.setArchief(true);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

    }
	public static void undeleteknop(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);
       
        t.setArchief(false);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

    }
	public static ArrayList<Leerkracht> getallLeerkracht() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Leerkracht> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Leerkracht>)session.createNativeQuery("SELECT * FROM Leerkracht where archief=0", Leerkracht.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			
	}
		return tds;
	}
	public static boolean saveLeerkracht(Leerkracht l) {

		Session session = Main.factory.getCurrentSession();


		try {
		
			session.beginTransaction();
			
			
			session.save(l);

			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			return false;
		
			}
		
	}
	public static boolean saveAdres(Adres a) {

		Session session = Main.factory.getCurrentSession();


		try {
		
			session.beginTransaction();
			
			
			session.save(a);

			session.getTransaction().commit();	
			session.close();
			return true;
		}
		catch(Exception e) {
			session.close();

			e.printStackTrace();
			return false;
		
			}
		
	}
	public static void deleteknopLeerkracht(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Leerkracht t=(Leerkracht) session.get(Leerkracht.class, id);

       
        t.setArchief(true);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

	}
	public static void undeleteknopleerkracht(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();

        Leerkracht t=(Leerkracht) session.get(Leerkracht.class, id);
       
        t.setArchief(false);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

    }
	public static void deleteknopAdres(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
       
       a.setArchief(true);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

    }
	public static void undeleteknopAdres(int id){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
       
       a.setArchief(false);


        session.getTransaction().commit();
        session.close();
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

    }
	public static ArrayList<Leerkracht> getallLeerkrachtDelete() {
		Session session = Main.factory.getCurrentSession();
		
		ArrayList<Leerkracht> tds = null;
		
		try {
		session.beginTransaction();
		
		tds = (ArrayList<Leerkracht>)session.createNativeQuery("SELECT * FROM Leerkracht where archief=1", Leerkracht.class).getResultList();
		

		session.getTransaction().commit();
		session.close();
		
	}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
			
	}
		return tds;
	}
	public static void changeBook(int id, String book , String auteur){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Training t=(Training) session.get(Training.class, id);

       
        t.setBook(book);
        t.setAuteurBoek(auteur);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}

	}
	public static void updateLeerkrachtName(int id, String voornaam){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Leerkracht t=(Leerkracht) session.get(Leerkracht.class, id);
        t.setVoornaam(voornaam);


        session.getTransaction().commit();
        session.close();
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateLeerkrachtLastname(int id, String familienaam){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Leerkracht t=(Leerkracht) session.get(Leerkracht.class, id);
        t.setFamilienaam(familienaam);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateAdresStraat(int id, String straat){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
        a.setStraat(straat);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateAdreshuisn(int id, int huisnummer){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
        a.setHuisnum(huisnummer);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateAdrespostcode(int id, int postcode){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
        a.setPostcode(postcode);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateAdresStad(int id, String stad){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
        a.setStad(stad);


        session.getTransaction().commit();
        session.close();
        
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
	public static void updateAdresland(int id, String land){
		Session session = Main.factory.getCurrentSession();
		try {

        session.beginTransaction();
        
        Adres a=(Adres) session.get(Adres.class, id);
        a.setLand(land);


        session.getTransaction().commit();
        session.close();
		}
		catch(Exception e) {
			session.close();
			e.printStackTrace();
		}


    }
}
