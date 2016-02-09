/**
  Creates a building object
###############################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-04
*/

import javax.swing.*;
import java.awt.*;

public class RandomSkyline
{
   //-----------------------------------------------------------------
   //  Presents a city skyline.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Noir City");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new SkylinePanel());

      frame.pack();
      frame.setVisible(true);
   }
}
