package model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Odataselect {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List odatasel(String as){
		List data = new ArrayList();
		//Client client;
		//client = ClientBuilder.newClient();
		//String gaha = "http://services.odata.org/V3/Northwind/Northwind.svc/Employees/$count";
		//WebTarget target = client.target(gaha);
		//Integer lastname = target.request(MediaType.APPLICATION_JSON).get(Integer.class);
		for(int id=1;id<10;id++){
			Client client;
			client = ClientBuilder.newClient();
			String gaha1 = "http://services.odata.org/V3/Northwind/Northwind.svc/Employees("+id+")/" + as;
			WebTarget target2 = client.target(gaha1);
			String lastname2 = target2.request(MediaType.APPLICATION_JSON).get(String.class);
			lastname2 = new WijzigString().wijzigNaam(lastname2);
//			String data2 = "http://services.odata.org/V3/Northwind/Northwind.svc/Employees/$count/?$filter=substringof('"+ lastname2 +"',"+as+")";
//			WebTarget target21 = client.target(data2);
//			String aant = target21.request(MediaType.APPLICATION_JSON).get(String.class).toString();
//			aant = new WijzigString().wijzigNaam(aant);
			data.add(lastname2);
//			data.add(aant);
		}
		return data;
	}
}
