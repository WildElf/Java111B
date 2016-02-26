/**
  Creates a star background
  for deep space
  with stars of varying brightness
  including two kinds of super-bright
  stars that are drawn larger
###########################################
  @author: E. Jo Zimmerman
  @version: 2.0
  @since: 2015-02-09
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class Stars
{
  private int populationFactor;
  private Random rand = new Random();
  private int screenWidth;
  private int screenHeight;
  private ArrayList<Star> starField;
  
  public Stars(int width, int height)
  {
    screenWidth = width;
    screenHeight = height;
    populationFactor = 50;
    
    starField = new ArrayList<Star>();
  }
  
  public void draw(Graphics g)
  {
    g.setColor(Color.white);
    
    int tooBright = 0;
    int starCount = 0;
    int rightBright = 0;
    
    for (Star star: starField)
    {
      int bright = star.getBrightness();
      
      starCount++;
      if (bright == 9)
      	tooBright++;
      else if (bright == 8)
        rightBright++;
      
      if (bright <= 8)
      {
        g.setColor(star.getColor());
        g.drawLine(star.getX(), star.getY(), star.getX(), star.getY());
      
      }
      else if (bright == 9)
      {
        g.setColor(star.getColor());
        int starX = star.getX();
        int starY = star.getY();
        
        g.drawRect(starX-1,starY-1,2,2);
        g.drawLine(starX-3, starY, starX+3, starY);
        g.drawLine(starX, starY+3, starX, starY-3);
      
      }
      else
      {
        g.setColor(star.getColor());
        int starX = star.getX();
        int starY = star.getY();

        g.fillRect(starX-2,starY-2,5,5);
        g.fillRect(starX-4,starY-1,9,3);
        g.fillRect(starX-1,starY-4,3,9);

        g.drawLine(starX-6, starY, starX+6, starY);
        g.drawLine(starX,starY+6,starX, starY-6);
      }  
    }
    
  }

  public void generate()
  { 
    for (int down = 0; down < screenHeight; down++)
    {
      for (int across = 0; across < screenWidth; across++)
      {
        if (rand.nextInt(populationFactor) < 1)
        {        
          starField.add(new Star(across,down));
        } // end of if for normal stars 
      }
    }
  }

}
