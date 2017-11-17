
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
		
		
       
        Personeel p= new Personeel("jonas","leblank",8,"WISKUNDE","hr manager",false);
      
       
        
        PersoneelDAO.addPersoneel(p);
      
       
  
		} catch (Exception e) { 
           e.printStackTrace();
		
}
}
}
