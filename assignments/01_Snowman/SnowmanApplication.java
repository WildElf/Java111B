//********************************************************************
//  SnowmanApplication.java       Author: Lewis/Loftus
//  Modified: Conner   Date: 1/13/15
//  Demonstrates basic drawing methods and the use of color.
//  Modified Snowman applet to be stand-along application.
//********************************************************************

/**
  * @author  Eric Zimmerman
  * @title   Assignment 1
  * @since   2016-01-26
*/
/**
  Algorithm as follows:
  Draw sun & background
  Draw snowman shadow
  Draw snowman body
  Draw snowman buttons, face & hat
  
*/
/*
  Required changes:
  a) Add two red buttons to the upper torso
  b) Make the snowman frown instead of smile
  c) Move the sun to the upper-right corner of the picture
  d) Display your name in the upper-left corner of the picture
  e) Shift the snowman 20 pixels to the right
  Additional changes:
  a) Increased thickness to hat brim
  b) Changed background to richer blue
  c) created a shadow based on body values
  d) Added two sun rays
  e) changed ground to white (the shadow makes this work)
*/

import javax.swing.*;
import java.awt.*;

public class SnowmanApplication
{
   public static void main (String [] args)
   {
      JFrame frame = new JFrame("Snowman Application");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SnowmanPanel panel = new SnowmanPanel();
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
      
        
//********************************************************************
//  SnowmanPanel class used for drawing shapes 
//********************************************************************

class SnowmanPanel extends JPanel
{

   //-----------------------------------------------------------------
   //  Constructor sets size and color of panel
   //-----------------------------------------------------------------
   public SnowmanPanel()
   {
     setPreferredSize(new Dimension(300,225));
     setBackground(Color.cyan);
   }
     
   //-----------------------------------------------------------------
   //  Draws a snowman.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      final int MID = 170;
      final int TOP = 50;

      // constants for snow body
      final int head = 40;
      final int UP_T[] = { 70, 50 };
      final int LOW_T[] = { 100, 60 };
      
      // coordinates for shadow hat polygon
      final int hatX[] = { MID-70, MID-50, MID-65, MID-85 };
      final int hatY[] = { TOP+168, TOP+173, TOP+193, TOP+188 };
      
      // coordinates for sun rays
      final int ray1X[] = { 250, 255, -100, -110 };
      final int ray1Y[] = { 5, 15, 95, 45 };
      
      final int ray2X[] = { 260, 280, 170, -130 };
      final int ray2Y[] = { 30, 45, 360, 220 };

      final char name[] = { 'E','.','Z','.' };

      setBackground (Color.blue);

      page.setColor (Color.yellow);
      page.fillOval (260, -40, 80, 80);  // sun
      
      page.fillPolygon (ray1X, ray1Y, 4); // upper sun ray
      page.fillPolygon (ray2X, ray2Y, 4); // lower sun ray

      // ground changed to white
      page.setColor (Color.white);
      page.fillRect (0, 175, 300, 50);  // ground

      // shadow body added
      page.setColor (Color.lightGray);
      page.fillOval (MID-60, TOP+120,LOW_T[0],LOW_T[1]/2); // lower torso shadow
      page.fillOval (MID-65, TOP+140,UP_T[0],UP_T[1]/2);   // upper torso shadow
      page.fillOval (MID-70, TOP+155,head, head/2);        // head shadow
      
      page.drawLine (MID-75, TOP+165, MID-45, TOP+180);    // hat brim shadow
      page.drawLine (MID-75, TOP+166, MID-45, TOP+181);    // thicker brim shadow
      page.fillPolygon (hatX, hatY, 4);                        // had shadow
	
      page.setColor (Color.white);
      page.fillOval (MID-20, TOP, 40, 40);      // head
      page.fillOval (MID-35, TOP+35, UP_T[0], UP_T[1]);   // upper torso
      page.fillOval (MID-50, TOP+80, LOW_T[0], LOW_T[1]);  // lower torso
      
      page.setColor (Color.red);
      page.fillOval (MID-5, TOP+45, 10, 10); // 1st button
      page.fillOval (MID-5, TOP+65, 10, 10); // 2nd button

      page.setColor (Color.black);
      page.fillOval (MID-10, TOP+10, 5, 5);   // left eye
      page.fillOval (MID+5, TOP+10, 5, 5);    // right eye

      page.drawArc (MID-10, TOP+25, 20, 10, 10, 160);   // frown, was smile

      page.drawLine (MID-25, TOP+60, MID-50, TOP+40);  // left arm
      page.drawLine (MID+25, TOP+60, MID+55, TOP+60);  // right arm

      page.drawLine (MID-20, TOP+5, MID+20, TOP+5);  // brim of hat
      page.drawLine (MID-20, TOP+4, MID+20, TOP+4);  // thicker brim
      page.fillRect (MID-15, TOP-20, 30, 25);        // top of hat
      
      page.setColor (Color.white);
      page.drawChars(name,0,4, 10, 20); // display name

   }
}
