/**
  TwoSorts.java
  Draws two copies of a numerical array
  and displays a step-by-step comparison
  between selection sort and insertion sort
############################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2016-04-20
*/

import java.io.*;
import java.lang.*;
import javax.swing.JFrame;

public class TwoSorts
{
	public static void main (String[] args)
	{
		final int SCREEN_WIDTH = 420;
		final int SCREEN_HEIGHT = 300;
		JFrame frame = new JFrame("TwoSorts");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		TwoSortsPanel twoSortsPane = new TwoSortsPanel(SCREEN_WIDTH, SCREEN_HEIGHT);

		frame.getContentPane().add(twoSortsPane);
		frame.pack();
		frame.setVisible(true);

	}
}
