/**
  Creates a random Skyline object with
  different color themes and names
#################################
  @author: D. Duffy-Halseth
  @author: E. Jo Zimmerman
  @version: 1.2
  @since: 2015-03-17
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
      // an enum is probably better, but it created additional .class files
      // theme int used here for frame name, then passed to SkylinePanel
      JFrame frame = new JFrame ("This is an Inappropriate Place to Name A City");
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new SkylinePanel());

      frame.pack();
      frame.setVisible(true);
   }
}
