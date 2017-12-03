package softwareproject;
import java.sql.*;
public class mains {

	public static void main (String[] args) throws SQLException { 
		
       /* try { 
            String url = "jdbc:mysql://dt5.ehb.be/SP2Team08"; 
            Connection conn = DriverManager.getConnection(url,"SP2Team08","aqwzsxedc123"); 
            Statement st = conn.createStatement(); 
            st.executeUpdate("INSERT INTO Training " + 
                "VALUES (1005, 'younes', 5, 333)"); 
          
            
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } */
		try {
		
		
        Adres a = new Adres (2,"rue",4,1070,"Bx","Be");
        Personeel p= new Personeel(1, "jan","Willem",a,"sales","hr manager","ok","ok");
        Leerkracht l = new Leerkracht(2,"Mr.Do","Remi",a);
        Training te = new Training(4,"Matheo",l,"ok","ok",a,p);
       
        
        TrainingDAO.addTraining(te);
      
       
  
		} catch (Exception e) { 
           e.printStackTrace();
		
}
}
}
