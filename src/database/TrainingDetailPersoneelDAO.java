package database;

import java.util.ArrayList;

import org.hibernate.Session;


import model.Main;
import model.Training;
import model.TrainingDetail;


public class TrainingDetailPersoneelDAO {


	public static ArrayList<Training> getTraining() {
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
		


public static boolean saveTrainingDetail(TrainingDetail td) {

	Session session = Main.factory.getCurrentSession();


	try {
	
		session.beginTransaction();
		
		
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
public static ArrayList<TrainingDetail> getall() {
	Session session = Main.factory.getCurrentSession();
	
	ArrayList<TrainingDetail> tds = null;
	
	try {
	session.beginTransaction();
	
	tds = (ArrayList<TrainingDetail>)session.createNativeQuery("SELECT * from TrainingDetail where archief=0 order by idTraining", TrainingDetail.class).getResultList();
	

	session.getTransaction().commit();
	session.close();
}
	catch(Exception e) {
		e.printStackTrace();
		session.close();
		
}
	return tds;
}


public static ArrayList<Training> getallTrainingen() {
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

public static ArrayList<TrainingDetail> getall2() {
	Session session = Main.factory.getCurrentSession();
	
	ArrayList<TrainingDetail> tds = null;
	
	try {
	session.beginTransaction();
	
	tds = (ArrayList<TrainingDetail>)session.createNativeQuery("SELECT * from TrainingDetail where archief=1", TrainingDetail.class).getResultList();
	

	session.getTransaction().commit();
	session.close();
	
}
	catch(Exception e) {
		e.printStackTrace();
		session.close();
		
}
	return tds;
}


public static void deleteknop1(int id){
	Session session = Main.factory.getCurrentSession();
	try {

    session.beginTransaction();
    
    TrainingDetail td=(TrainingDetail) session.get(TrainingDetail.class, id);

   
    td.setArchief(true);


    session.getTransaction().commit();
    session.close();
    
	}
	catch(Exception e) {
		e.printStackTrace();
		session.close();
	}

}


public static void deleteknop2(int id){
	Session session = Main.factory.getCurrentSession();
	try {

    session.beginTransaction();
    
    TrainingDetail td=(TrainingDetail) session.get(TrainingDetail.class, id);

   
    td.setArchief(false);


    session.getTransaction().commit();
    session.close();
    
	}
	catch(Exception e) {
		e.printStackTrace();
		session.close();
	}

}


}
	
	
	
	

