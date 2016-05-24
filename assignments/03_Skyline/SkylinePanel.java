/**
  Creates building objects in a JPanel extension
  Draws buildings and background when called 
  by a frame.getContentPane() method
#################################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-04
*/

import javax.swing.*;
import java.awt.*;

public class SkylinePanel extends JPanel
{
    
   private Building build1, build2, build3, build4, build5;
   private Color buildColor;
   
   final int GROUND = 190;
   final int SCREEN_WIDTH = 300;
   final int SCREEN_HEIGHT = 200;
   
   final Color TWILIGHT = new Color(153, 0, 153);

   //-----------------------------------------------------------------
   //  Constructor: Creates five building objects.
   //-----------------------------------------------------------------
   public SkylinePanel()
   {
      buildColor = Color.black;
      
      build1 = new Building (35, 70, 15, GROUND, buildColor);
      build2 = new Building (55, 110, 55, GROUND, buildColor);
      build3 = new Building (40, 145, 115, GROUND, buildColor);
      build4 = new Building (60, 180, 160, GROUND, buildColor);
      build5 = new Building (50, 130, 225, GROUND, buildColor);

      setPreferredSize (new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
      setBackground (TWILIGHT);
   }

   //-----------------------------------------------------------------
   //  Draws this panel by requesting that each building draw itself.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);

      build1.draw(page);
      build2.draw(page);
      build3.draw(page);
      build4.draw(page);
      build5.draw(page);

      page.setColor(buildColor);
      page.fillRect(0, GROUND, SCREEN_WIDTH, SCREEN_HEIGHT - GROUND);
   }
}
