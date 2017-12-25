package database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.hibernate.query.Query;

import javafx.util.Callback;

import org.hibernate.Session;

import model.*;

public class StatisticDAO {

	@SuppressWarnings("rawtypes")
	public static List getPieData(String arg, String archiveString, String tabel){
		Session session = Main.factory.getCurrentSession();
		List test = null;

		try {
			session.beginTransaction();

			String az = ("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
					+ "archief "+archiveString +" 1 group by 1");

			Query q = session.createNativeQuery(az);
			test = q.getResultList();

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}

		return test;
	}

	@SuppressWarnings("rawtypes")
	public static List getLineData(String arg, String archiveString, String tabel, String ja){
		Session session = Main.factory.getCurrentSession();
		List test = null;

		try {
			session.beginTransaction();
			String az = null;
			if (tabel.equals("Training")) {
				az = ("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
						+ "archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			} else if(tabel.equals("TrainingDetail")){
				az = ("SELECT td."+arg+", count(td."+ arg+") FROM Training tr join TrainingDetail td on tr.idTraining" 
						+ " = td.idTraining where tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}else if(tabel.equals("Adres")){
				az = ("SELECT a."+arg+", count(a."+ arg+") FROM Training tr join Adres a on tr.idAdres"
						+ " = a.idAdres where tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}else if(tabel.equals("Leerkracht")){
				az = ("SELECT l."+arg+", count(l."+ arg+") FROM Training tr join Leerkracht l on tr.idLeerkracht"
						+ " = l.idLeerkracht where " + "tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}

			Query q = session.createNativeQuery(az);
			test = q.getResultList();

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}
		return test;
	}

	@SuppressWarnings("rawtypes")
	public static List getBarData(String arg, String archiveString, String tabel, String ja){
		Session session = Main.factory.getCurrentSession();
		List test = null;

		try {
			session.beginTransaction();
			String az = null;
			if (tabel.equals("Training")) {
				az = ("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
						+ "archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			} else if(tabel.equals("TrainingDetail")){
				az = ("SELECT d."+arg+", count(d."+ arg+") FROM Training tr join TrainingDetail d on tr.idTraining " 
						+ " = d.idTraining where tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}else if(tabel.equals("Adres")){
				az = ("SELECT a."+arg+", count(a."+ arg+") FROM Training tr join Adres a on tr.idAdres"
						+ " = a.idAdres where tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}else if(tabel.equals("Leerkracht")){
				az = ("SELECT l."+arg+", count(l."+ arg+") FROM Training tr join Leerkracht l on tr.idLeerkracht"
						+ " = l.idLeerkracht where tr.archief "+archiveString +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}

			Query q = session.createNativeQuery(az);
			test = q.getResultList();

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}

		return test;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getTable(String tabel) {
		Session session = Main.factory.getCurrentSession();
		List test = null;
		List <Object[]> geta = null;
		ArrayList<String> tds = new ArrayList<String>();

		try {
			session.beginTransaction();

			Query b = session.createNativeQuery("desc "+ tabel);
			test = b.getResultList();
			geta = test;
			for(Object[] obj : geta){
				String attnaam = String.valueOf(obj[0]);
				tds.add(attnaam);
			}

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}

		return tds;

	}

	public static List<String> getJaar() {
		Session session = Main.factory.getCurrentSession();
		List test = null;

		try {
			session.beginTransaction();

			Query q = session.createNativeQuery("SELECT  distinct year(beginDatum) from Training");
			test = q.getResultList();

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}

		List<String> result = new Vector<String>();
		test.parallelStream().forEach( o -> result.add(o.toString()));
		return result;

	}

	public static List getpresData(String arg, String a, String tabel, String ja) {
		Session session = Main.factory.getCurrentSession();
		List test = null;

		try {
			session.beginTransaction();
			String az = null;
			if (tabel.equals("Training")) {
				az = ("SELECT "+arg+", count("+ arg+") FROM "+ tabel +" where "
						+ "archief "+a +" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			} else if(tabel.equals("TrainingDetail")){
				az = ("SELECT "+arg+", count("+ arg+") FROM Training tr join TrainingDetail d on tr.idTraining " 
						+ " = d.idTraining where tr.archief "+a+" 1");
				if (ja.equals("Alles")) {
				} else {
					az += " and year(beginDatum) = " + ja;
				}
				az += " group by 1";
			}

			Query q = session.createNativeQuery(az);
			test = q.getResultList();

			session.getTransaction().commit();

		}
		catch(Exception e) {
			e.printStackTrace();

		}

		return test;
	}
}