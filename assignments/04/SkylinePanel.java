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
import java.util.*;

public class SkylinePanel extends JPanel
{
    
   private ArrayList<Building> buildings = new ArrayList<Building>();
   private Color buildColor;
   private Color backColor;
   private Color horizonColor;
   private Stars stars;
   private Random rand;
   
   final int GROUND = 190;
   final int SCREEN_WIDTH = 300;
   final int SCREEN_HEIGHT = 200;
   
   //-----------------------------------------------------------------
   //  Constructor: Creates five building objects.
   //-----------------------------------------------------------------
   public SkylinePanel()
   {
      buildColor = foreground(1);
      backColor = background(1);
      horizonColor = horizon(1);
      
      rand = new Random(System.nanoTime());
      
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
      stars = new Stars(SCREEN_WIDTH, SCREEN_HEIGHT);
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
       
       for (int glow = 0; glow > GROUND; glow++)
       {
         changeDelta = (float)glow / GROUND;

		 // deltaR starts at 200, ends at 100
		 // R = 200; backR = 100
		 // deltaR = (R-bR) = 100
		 // G = 50, backG = 150
		 // deltaG = (G-bG) = -100
         curR = R - (deltaR * glow);
         curG = G - (deltaG * glow);
         curB = B - (deltaB * glow);
         // this should work?
         
/*         deltaR = (int)(R * changeDelta);
         deltaG = (int)(G * changeDelta);
         deltaB = (int)(B * changeDelta);
*/
         hg.setColor(new Color(curR, curG, curB));
         hg.drawLine(0, GROUND-glow, SCREEN_WIDTH, GROUND-glow);
         
       }
       
   }
   
   Color horizon(int theme)
   {
     switch (theme) {
       case 0: return new Color(153, 0, 153);
       case 1: return new Color(193, 193, 124);
       case 2: return new Color(255, 200, 240);
       default: return Color.yellow;
     }
   }
   
   Color background(int theme)
   {
     switch (theme) {
       case 0: return new Color(25, 0, 25);
       case 1: return Color.black;
       case 2: return Color.cyan;
       default: return Color.black;
     }
   }
   
   Color foreground(int theme)
   {
     switch (theme) {
       case 0: return Color.black;
       case 1: return Color.gray;
       case 2: return Color.gray;
       default: return Color.darkGray;
     }
   }
}
