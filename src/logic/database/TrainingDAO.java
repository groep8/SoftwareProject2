package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Training;


public class TrainingDAO {
	
	public static void saveTraining(Training t) {

	SessionFactory factory = new Configuration()
			.configure()
			.addAnnotatedClass(Training.class)
			.buildSessionFactory();


	Session session = factory.getCurrentSession();


	try {
		//Creating new Training object
	
		session.beginTransaction();

		//saving the new Training object
		session.save(t);

		session.getTransaction().commit();

		System.out.println("Done");

	}
	finally {
		factory.close();
		}
}
}
