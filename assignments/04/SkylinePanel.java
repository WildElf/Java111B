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
  @version: 2.0
  @since: 2015-02-09
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SkylinePanel extends JPanel
{
    
   private ArrayList<Building> buildings = new ArrayList<Building>();
   private Color buildColor;
   private Color backColor;
   private Color horizonColor;
   private Stars stars;
   
   final int GROUND = 190;
   final int SCREEN_WIDTH = 300;
   final int SCREEN_HEIGHT = 200;
   
   //-----------------------------------------------------------------
   //  Constructor: Creates five building objects.
   //-----------------------------------------------------------------
   public SkylinePanel(int theme)
   {
      Random rand = new Random();
         	  
      buildColor = foreground(theme);
      backColor = background(theme);
      horizonColor = horizon(theme);
      
      
      int xMark = 0;
      int yTall;
      int xWide;
      
      while (xMark + 5 < SCREEN_WIDTH)
      {
        xMark += (rand.nextInt(5) + 1);
        
        yTall = 20 + rand.nextInt(GROUND/19) * 16;
        xWide = 20 + rand.nextInt(12) * 5;
        
        buildings.add(new Building (xWide, yTall, xMark, GROUND, buildColor));
        
        xMark += xWide;
      }
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

      for (Building build : buildings)
        build.draw(page);

      page.setColor(buildColor);
      page.fillRect(0, GROUND, SCREEN_WIDTH, SCREEN_HEIGHT - GROUND);
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
