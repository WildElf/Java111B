/**
  Creates a random Skyline object with
  different color themes and names
#################################
  @author: E. Jo Zimmerman
  @version: 1.1
  @since: 2015-02-09
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RandomSkyline
{
   //-----------------------------------------------------------------
   //  Presents a city skyline.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Random rand = new Random();

      // an enum is probably better, but it created additional .class files
      // theme int used here for frame name, then passed to SkylinePanel
      int theme = rand.nextInt(3);
      JFrame frame;

      if (theme == 0)
        frame = new JFrame ("Night City");
      else if (theme == 1)
        frame = new JFrame ("Noir City");
      else // if (theme == 2)
        frame = new JFrame ("Morning City");
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new SkylinePanel(theme));

      frame.pack();
      frame.setVisible(true);
   }
}
