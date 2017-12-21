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
		
			for(int id=1;id<10;id++){
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
			
		/*	Client client3;
			client3 = ClientBuilder.newClient();
			WebTarget target3 = client3.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Title");
			String title = target3.request(MediaType.APPLICATION_JSON).get(String.class);
			title = new WijzigString().wijzigNaam(title);
			e.setTitle(title);
			
			Client client5;
			client5 = ClientBuilder.newClient();
			WebTarget target5 = client5.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Address");
			String address = target5.request(MediaType.APPLICATION_JSON).get(String.class);
			address = new WijzigString().wijzigNaam(address);
			e.setAddress(address);
			
			Client client6;
			client6 = ClientBuilder.newClient();
			WebTarget target6 = client6.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/City");
			String city = target6.request(MediaType.APPLICATION_JSON).get(String.class);
			city = new WijzigString().wijzigNaam(city);
			e.setCity(city);*/

		/*	Client client7;
			client7 = ClientBuilder.newClient();
			WebTarget target7 = client7.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/Region");
			String region = target7.request(MediaType.APPLICATION_JSON).get(String.class);
			region = new WijzigString().wijzigNaam(region);
			e.setRegion(region);
			Thread.sleep(1);*/
			/*sClient client8;
			client8 = ClientBuilder.newClient();
			WebTarget target8 = client8.target("http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/HomePhone");
			String homePhone = target8.request(MediaType.APPLICATION_JSON).get(String.class);
			homePhone = new WijzigString().wijzigNaam(homePhone);
			e.setHomePhone(homePhone);*/
			ae.add(e);
			ae
		    .parallelStream()
		   
			.forEachOrdered(et -> System.out.print(et + " "));
		System.out.println("");
			
		//
		//System.out.println(e);

			}

		
			
			
			return ae;
		}
		
		
	
		
		
		public static void main(String[] args) {
			getAllEmployees();
		}
	
	
	

	
	
	
	
	
	
	

		
	
	
		
	
}

