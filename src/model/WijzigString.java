package model;

public class WijzigString {

	public String wijzigNaam(String name){
		
		name = name.substring(103);
		name = name.substring(0, name.length()-2);
		return name;
		}
	
	public String wijzigUri(String uri){
		return uri;
	}
	
}
