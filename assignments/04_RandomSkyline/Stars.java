/**
  Creates a star background
  Using theme(int) as a multiplier
  so that the brighter the sky, fewer stars
  Also draws 10% of stars brighter
###########################################
  @author: E. Jo Zimmerman
  @author: D. Duffy-Halseth
  @version: 1.1
  @since: 2015-03-01
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Stars
{
  private int populationFactor;
  private Random rand = new Random();
  private int screenWidth;
  private int screenHeight;
  
  public Stars(int width, int height, int factor)
  {
    screenWidth = width;
    screenHeight = height;
    populationFactor = 200 * (factor*factor + 1);
  }
  
  public void draw(Graphics g)
  {
    g.setColor(Color.white);
    for (int down = 0; down < screenHeight; down++)
      for (int across = 0; across < screenWidth; across++)
      {
        // stars get less likely the closer to the bottom
        if (rand.nextInt(populationFactor + (down * 100)) < 1)
        {
          g.drawLine(across, down, across, down);
          // 1 in 10 stars is a brighter star
          if (rand.nextInt(10) == 0)
          {
            g.drawRect(across-1,down-1,2,2);
            
            g.drawLine(across-3, down, across+3, down);
            g.drawLine(across,down+3,across, down-3);
          }
        }
      }
  }
}