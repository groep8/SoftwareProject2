package model;
//info gevonden op http://www.vogella.com/tutorials/JUnit/article.html#junit5
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class MyEmployee1 {
	
	
	@Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Employee tester = new Employee(); // MyClass is tested
        EmployeeOdata tester2 = new EmployeeOdata();
        // assert statements
        assertEquals(null,tester2.getAllEmployees(),null);
        assertEquals(0,tester.getId(),0);
        assertEquals(null,tester.getLastName(),null);
        assertEquals(null,tester.getFirstname(),null);
        assertEquals(null,tester.getCity(),null);
        assertEquals(null,tester.getRegion(),null);
        assertEquals(null,tester.getHomePhone(),null);
        assertEquals(null,tester.getTitle(),null);
        
        
    }
	
	
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(Employee.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	  }

}
