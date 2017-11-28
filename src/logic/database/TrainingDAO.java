package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Main;
import model.Training;
import model.TrainingDetail;


public class TrainingDAO {
	
	
	public static boolean saveTraining(TrainingDetail td) {

		Session session = Main.factory.getCurrentSession();


		try {
			//Creating new Training object
		
			session.beginTransaction();
			
			//saving the new Training object
			session.save(td);

			session.getTransaction().commit();	
		}
		catch(Exception e) {
			e.printStackTrace();
			
		return false;
			}
		
		return true;
	}
	
}
