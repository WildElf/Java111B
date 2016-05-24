/**
  Creates building objects in a JPanel extension
  Draws buildings and background when called 
  by a frame.getContentPane() method
  Uses a theme(int) to determine color palette
  Creates buildings of random (constrained) sizes
  going left to right until off the screen
  Draws a gradient horizon over the background
#################################################
  @author: E. Jo Zimmerman
  @author: D. Duffy-Halseth
  @version: 2.1
  @since: 2015-03-07
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SkylinePanel extends JPanel
{
   private Building building;
   private Color buildColor;
   private Color backColor;
   private Color horizonColor;
   private Color nameColor;
   private Stars stars;
   private String cityName;
   
   final int GROUND = 190;
   final int SCREEN_WIDTH = 300;
   final int SCREEN_HEIGHT = 200;
   
   //-----------------------------------------------------------------
   //  Constructor: Creates five building objects.
   //-----------------------------------------------------------------
   public SkylinePanel()
   {
      Random rand = new Random();
      
      int theme = rand.nextInt(3);
      if (theme == 0)
      {
        cityName = new String("Night City");
        nameColor = Color.yellow.brighter().brighter();
      }
      else if (theme == 1)
      {
        cityName = new String("Noir City");
        nameColor = Color.white;
      }
      else // if (theme == 2)
      {
        cityName = new String("Morning City");
        nameColor = Color.blue.darker();
      }
   	  
      buildColor = foreground(theme);
      backColor = background(theme);
      horizonColor = horizon(theme);

      stars = new Stars(SCREEN_WIDTH, SCREEN_HEIGHT, theme);
      setPreferredSize (new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
      setBackground (backColor);
   }

   //-----------------------------------------------------------------
   //  Draws this panel by requesting that each building draw itself.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);

      horizonGlow(page);
      stars.draw(page);

      // draw buildings
      int xMark = 0;
      int yTall;
      int xWide;
      Random rand = new Random();

      while (xMark + 21 < SCREEN_WIDTH)
      {
        xMark += (rand.nextInt(5) + 1);
        
        xWide = 20 + rand.nextInt(12) * 5;
        
        if (xWide + xMark > SCREEN_WIDTH)
        {
          xWide = SCREEN_WIDTH - xMark - 2;
        }

        yTall = 20 + (rand.nextInt(GROUND/19) * 16);
        
        building = new Building (xWide, yTall, xMark, GROUND, buildColor);
        building.draw(page);
        
        xMark += xWide;
      }

      page.setColor(buildColor);
      page.fillRect(0, GROUND, SCREEN_WIDTH, SCREEN_HEIGHT - GROUND);

      page.setColor(nameColor);
      page.drawString(cityName, 15, 20);
   }
   
   void horizonGlow(Graphics hg)
   {

     final int R = horizonColor.getRed();
     final int G = horizonColor.getGreen();
     final int B = horizonColor.getBlue();

     final int deltaR = R - backColor.getRed();
     final int deltaG = G - backColor.getGreen();
     final int deltaB = B - backColor.getBlue();
       
     int curR, curG, curB;       
     float changeDelta;
       
     for (int glow = 0; glow < GROUND; glow++)
     {
       // grows closer & closer to 1
       changeDelta = (float)glow / GROUND;

       curR = R - (int)(deltaR * changeDelta);
       curG = G - (int)(deltaG * changeDelta);
       curB = B - (int)(deltaB * changeDelta);

       hg.setColor(new Color(curR, curG, curB));
       hg.drawLine(0, GROUND-glow, SCREEN_WIDTH, GROUND-glow);
         
     }
       
   }
   
   // sets horizon color based on theme
   Color horizon(int theme)
   {
     switch (theme) {
       case 0: return new Color(193, 193, 124);
       case 1: return new Color(153, 0, 153);
       case 2: return new Color(255, 150, 200);
       default: return Color.yellow;
     }
   }
   
   // sets background color based on theme
   Color background(int theme)
   {
     switch (theme) {
       case 0: return Color.black;
       case 1: return new Color(10, 0, 50);
       case 2: return Color.cyan;
       default: return Color.black;
     }
   }
   
   // sets building color based on theme
   // building colors used as basis for window color in Building class
   Color foreground(int theme)
   {
     switch (theme) {
       case 0: return Color.darkGray;
       case 1: return Color.black;
       case 2: return Color.gray;
       default: return (Color.darkGray).darker();
     }
   }
}
