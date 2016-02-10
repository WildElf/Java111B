/**
  Temperature.java
#########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-10
*/
import java.lang.*;
import java.util.*;

public class Temperature
{
  double temperature;
  char type;
  
  // default constructor
  public Temperature()
  {
    type = 'C';
    set(0.0);
  }
  
  // temperature only constructor assumes Celcius
  public Temperature(double temp)
  {
    type = 'C';
    set(temp);
  }

  // type only constructor assumes freezing
  public Temperature(char scale)
  {
    type = Character.toUpperCase(scale);
    set(0.0);
  }

  // temperature and type constructor
  public Temperature(double temp, char scale)
  {
    type = Character.toUpperCase(scale);
    set(temp);    
  }
  
  // displayers both class parameters
  public void writeOutput()
  {
    System.out.println(temperature + "˚" + type);
     
  }
  
  // displays stored temp in F
  public void writeF()
  {
    System.out.println(getF() + "˚F");
  }
  
  // displays stored temp in C
  public void writeC()
  {
    System.out.println(getC() + "˚C");
  }
  
  // returns stored temp as F
  public double getF()
  {
    double fTemp;
    if (type == 'C')
      fTemp = temperature * 9/5.0 + 32;
    else
      fTemp = temperature;

    return Math.round(fTemp*10)/10.0;
  }
 
  // returns stored temp as C
  public double getC()
  {
    double cTemp;
    if (type == 'F')
      cTemp = (temperature-32) * 5/9.0;
    else
      cTemp = temperature;
      
    return Math.round(cTemp*10)/10.0;
  }
  
  
  // updates temperature according to existing type
  public void set(double temp)
  {
    temperature = Math.round(temp*10)/10.0;
  }
  
  // changes scale, and updates stored temp accordingly
  public void set(char scale)
  {      
    type = Character.toUpperCase(scale); 
  }

  // sets both temperature and type
  public void set(double temp, char scale)
  {
    set(scale);
    set(temp);
  }
  
  public boolean equals(Temperature temp2)
  {
    // this operator as "temp1"
    return (Math.abs(this.getF() - temp2.getF()) < 0.01);
  }
  
  public String toString()
  {
    return Double.toString(temperature) + "˚" + type;  
  }
  
  public void readInput()
  {
    Scanner tempStr = new Scanner(System.in);
    
    System.out.println("Enter degrees: ");
    temperature = Double.parseDouble(tempStr.next());
    
    System.out.println("Enter temperature scale (F/C): ");
    String scale = tempStr.next();
    type = Character.toUpperCase(scale.charAt(0));
    
  }
   
}