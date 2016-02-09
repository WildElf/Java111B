/**
  Creates a star background
  Accepts a factor of 10 scale
#########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-04
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Stars
{
  private int populationFactor;
  private Random rand = new Random(System.nanoTime());
  private int screenWidth;
  private int screenHeight;
  
  public Stars(int width, int height)
  {
    screenWidth = width;
    screenHeight = height;
    populationFactor = 6000;
  }
  
  public void draw(Graphics g)
  {
    g.setColor(Color.white);
    for (int down = 0; down < screenHeight; down++)
      for (int across = 0; across < screenWidth; across++)
      {
        if (rand.nextInt(populationFactor) <= 1)
          g.drawLine(across, down, across, down);
          
      }
  }
}