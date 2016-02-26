/**
  Temperature.java
  Sets up the JFrame for drawing a spaceship
  that totally shoots lasers
############################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-14
*/

import javax.swing.JFrame;

public class Spaceship
{

   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
     final int SCREEN_WIDTH = 640;
     final int SCREEN_HEIGHT = 400;
     JFrame frame = new JFrame ("Spaceship");
     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      
     frame.getContentPane().add (new SpaceshipPanel(SCREEN_WIDTH,SCREEN_HEIGHT));

     frame.pack();
     frame.setVisible(true);
   }
}
