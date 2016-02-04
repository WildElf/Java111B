//********************************************************************
//  Demonstrates the use of image icons in labels.
//********************************************************************
/**
  Displays a series of JLabels inside a JFrame
  with a mix of images & matching text
  * @author  Eric Zimmerman
  * @since   2015-01-28
*/

import java.awt.*;
import javax.swing.*;

public class LabelDemo2
{
   //-----------------------------------------------------------------
   //  Creates and displays the primary application frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Swing Labels");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      ImageIcon icon = new ImageIcon ("dukehat.jpg");
      ImageIcon icon1 = icon;
      ImageIcon icon2 = new ImageIcon ("dukesmooth.jpg");
      ImageIcon icon3 = new ImageIcon ("duketop.jpg");
      ImageIcon icon4 = new ImageIcon ("dukedown.jpg");
      ImageIcon spacer = new ImageIcon ("spacer.jpg");

      JLabel label1, label2, label3, label4, label5, spaceLabel;

      label1 = new JLabel ("Duke Ellington Left", icon1, SwingConstants.LEFT);

      label2 = new JLabel ("Duke Ellington Right", icon2, SwingConstants.CENTER);
      label2.setHorizontalTextPosition (SwingConstants.LEFT);
      label2.setVerticalTextPosition (SwingConstants.BOTTOM);

      label3 = new JLabel ("Duke Ellington Above", icon3, SwingConstants.CENTER);
      label3.setHorizontalTextPosition (SwingConstants.CENTER);
      label3.setVerticalTextPosition (SwingConstants.BOTTOM);

      label4 = new JLabel ("Duke Ellington Below", icon4, SwingConstants.RIGHT);
      label4.setHorizontalTextPosition (SwingConstants.CENTER);
      label4.setVerticalTextPosition (SwingConstants.TOP);
      
      label5 = new JLabel ("It don't mean a thing if you don't import that javax.swing");
      label5.setFont(new Font("Serif", Font.BOLD, 18));
      
      spaceLabel = new JLabel (spacer);

      JPanel panel = new JPanel();
      panel.setBackground (Color.orange);
      panel.setPreferredSize (new Dimension (800, 175));
      panel.add (label1);
      panel.add (label2);
      panel.add (label3);
      panel.add (label4);
      panel.add (spaceLabel);
      panel.add (label5);
      
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
