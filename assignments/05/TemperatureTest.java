import java.util.Scanner;

public class TemperatureTest 
{
   public static void main(String[] args)
   {
	
        //dummy variable to stop scrolling so user can see test results
	String junk;
	Scanner scan = new Scanner(System.in);
	header();
		
	System.out.println("Test case 1: default constructor and");
	System.out.println("writeOutput() method.");
	Temperature t1 = new Temperature();
   	System.out.println("Results of default constructor:");
	System.out.println("Verify 0 degrees C.");
	t1.writeOutput();	

 	System.out.println("Test case 2: readInput() method.");
   	t1.readInput();
	System.out.println("Verify temperature and units:");
	System.out.println("Should be whatever you just entered.");
	t1.writeOutput();

	System.out.println("Test case 3: constructor with just"
		+ " temperature.");
	Temperature t2 = new Temperature(20.5);
          	System.out.println("Verify 20.5 degrees C.");
          	t2.writeOutput();
     
   	System.out.println("Test case 4: constructor with just units," 
		+ " f.");
          	System.out.println("Verify 0 degrees f.");
          	Temperature t3 = new Temperature('f');
     	t3.writeOutput();
     
	System.out.println("Test case 5: constructor with just units,"
				+ " c.");
           	System.out.println("Verify 0 degrees c.");
          	Temperature t4 = new Temperature('c');
     	t4.writeOutput();
     
	System.out.println("Test case 6: constructor with"
			+ " temperature and units.");
          	System.out.println("Verify -51.2 degrees F.");
          	Temperature t5 = new Temperature(-51.2, 'F');
     	t5.writeOutput();
     
	System.out.println("Test case 7: writeC degrees C, "
			+ "original in F.");
	System.out.println("Verify -46.2 degrees Celsius.");
	t5.writeC();
     	
	System.out.println("Test case 8: writeC degrees C, "
			+ "original in C.");
	System.out.println("Verify 0 degrees Celsius.");
	t4.writeC();
     	
	System.out.println("Test case 9: writeF degrees F, "
			+ "original in C.");
	System.out.println("Verify 32 degrees Fahrenheit");
	t4.writeF();
          	
  	System.out.println("Test case 10: writeF degrees F, "
			+ " original in F.");
	System.out.println("Verify -51.2 degrees Fahrenheit");
	t5.writeF();
          	
	System.out.println("Test case 11: getF method with "
			+ "original temperature in F.");
	System.out.println("Verify -51.2");
	System.out.println(t5.getF());
          	
	System.out.println("Test case 12: getF method with original" 
			+ " temperature in C.");
	System.out.println("Verify 32");
	System.out.println(t4.getF());
          	
	System.out.println("Test case 13: getC method with "
			+ "original temperature in F.");
	System.out.println("Verify -46.2");
	System.out.println(t5.getC());
    
     	System.out.println("Test case 14: getC method with "
			+ "original temperature in C.");
	System.out.println("Verify 0");
	System.out.println(t4.getC());

	System.out.println("Test case 15: set method for "
			+ "both parameters.");
	System.out.println("t5 before:");
	t5.writeOutput();
	t5.set(72.8, 'C');
	System.out.println("After set: verify 72.8 degrees C.");
	t5.writeOutput();
          	
	System.out.println("Test case 16: set method for just "
			+ "temperature.");
	System.out.println("t5 before:");
	t5.writeOutput();
	t5.set(100);
	System.out.println("After set: verify 100 degrees C.");
	t5.writeOutput();
     	
	System.out.println("Test case 17: set method for just units.");
	System.out.println("t5 before:");
	t5.writeOutput();
	t5.set('F');
	System.out.println("After set: verify 100 degrees F.");
	t5.writeOutput();
		
	System.out.println("Test case 18: equals test 1.");
	t1.set(100, 'C');
	t2.set(212, 'F');
	System.out.println("T1 = 100 degrees C.");
	System.out.println("T2 = 212 degrees F.");
	System.out.println("Here are the two temperatures "
			+ "converted to degrees C:");
	t1.writeC();
	t2.writeC();
	System.out.println("Verify results: should be true.");
	System.out.println(t1.equals(t2));
		
	System.out.println("Test case 19: equals test 2.");
	t1.set(100.1);
	System.out.println("T1 changed to 100.1 degrees C.");
	System.out.println("T2 = 212 degrees F.");
	System.out.println("Here are the two temperatures in "
			+ " degrees C:");
	t1.writeC();
	t2.writeC();
	System.out.println("Verify results: should be false.");
	System.out.println(t1.equals(t2));

	System.out.println("Test case 20: equals test 3.");
	t1.set(100);
	t2.set(212.1);
	System.out.println("T1 changed back to 100 degrees C.");
	System.out.println("T2 = 212.1 degrees F.");
	System.out.println("Here are the two temperatures in "
			+ "degrees C:");
	t1.writeC();
	t2.writeC();
	System.out.println("Verify results: should be false.");
	System.out.println(t1.equals(t2));
		
	System.out.println("Test case 21 (at last): toString method");
	System.out.println("T2 = 212.1 degrees F.");
	System.out.println(t2);
		
   }
   
	//header information
    public static void header()
    {
	System.out.println("TEMPERATURE TEST PROGRAM");
	System.out.println("Author: Constance Conner - Section 001");
	System.out.println("Author: Luke Skywalker  - Section 001");
	System.out.println("Date:   August 08, 2005");
	System.out.println("Course: CIS 111B -Temperature Application");
    }
}
