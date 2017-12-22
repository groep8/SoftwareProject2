package model;


import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class EmployeeOdata {

		// info gevonden op http://www.vogella.com/tutorials/REST/article.html
		public static ArrayList<Employee> getAllEmployees(){
			
			ArrayList<Employee> ae=new ArrayList<Employee>();
		
			for(int id=1;id<=9;id++){
			Employee e=new Employee();
			e.setId(id);
		
		
			Client client;
			client = ClientBuilder.newClient();
			WebTarget target = client.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/LastName");
			String lastname = target.request(MediaType.APPLICATION_JSON).get(String.class);
			lastname = new WijzigString().wijzigNaam(lastname);
			e.setLastName(lastname);
		
			Client client2;
			client2 = ClientBuilder.newClient();
			WebTarget target2 = client2.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/FirstName");
			String firstname = target2.request(MediaType.APPLICATION_JSON).get(String.class);
			firstname= new WijzigString().wijzigNaam(firstname);
			e.setFirstname(firstname);
			
		
			ae.add(e);
			ae
		    .parallelStream()
		   
			.forEachOrdered(et -> System.out.print(et + " "));
		System.out.println("");
			
	

			}

		
			
			
			return ae;
		}
		
		
	
		
		
		
	
	
	

	
	
	
	
	
	
	

		
	
	
		
	
}

