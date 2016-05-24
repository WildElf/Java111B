// original header
//*******************************************************************
//  MagazineRack.java       Author: Lewis/Loftus
//  Driver to exercise the MagazineList collection.
//*******************************************************************
/** Class header
  MagazineView.java
  Driver for a MagazineList of Magazine objects
  Allows user to input new magazines
  Displays Magazine objects from a MagazineList using
  a MagazinePanel
############################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2016-05-12
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

public class MagazineView
{
   //----------------------------------------------------------------
   //  Creates a MagazineList object, JFrame, and MagazinePanel
   //----------------------------------------------------------------
   public static void main (String[] args)
   {
      MagazineList rack = new MagazineList();
      JFrame frame = new JFrame("Magazine Rack");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      MagazineViewPanel magazines = new MagazineViewPanel(rack);

      frame.getContentPane().add(magazines);
      frame.pack();
      frame.setVisible(true);
   }
}
