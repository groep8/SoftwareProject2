package model;

public class WijzigString {

	public String wijzigNaam(String name){
		if (name.length() > 103) {
			name = name.substring(103);
			name = name.substring(0, name.length()-2);
		}else {
			name = name.substring(101);
			name = name.substring(0, name.length()-1);
		}
		return name;
	}
	
	public String wijzigUri(String uri){
		return uri;
	}
	
}
