package model;

import java.io.File;
import java.net.URL;

public class Javaloc {
	// source https://stackoverflow.com/questions/227486/find-where-java-class-is-loaded-from

	public static String javaloc(String b) {
	        ClassLoader loader = Javaloc.class.getClassLoader();        
	        String a = loader.getResource("model/Javaloc.class").toString();
	        System.out.println(a);
	        a = a.replaceFirst("bin/model/Javaloc.class", b);
	        a = a.replaceAll("%20", " ");
	        a = a.substring(6);
			return "\"" +  a + "\"";
	    }
	
    }

