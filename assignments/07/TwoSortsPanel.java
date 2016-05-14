/**
  TwoSorts.java
  Draws two copies of a numerical array
  and displays a step-by-step comparison
  between selection sort and insertion sort
############################################
  @author: E. Jo Zimmerman
  @version: 1.2
  @since: 2016-04-25
*/

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TwoSortsPanel extends JPanel
{
	private int screenWidth;
	private int screenHeight;

	private Random rnd = new Random();

	private int arraySize;
	private int[] selectArray;
	private int[] insertArray;
	private int selectPos;
	private int insertPos;

	private int upperBase;
	private int lowerBase;
	private Color selectColor;
	private Color insertColor;

	private JButton sortButton;
	private JLabel scope;
	private JLabel status;

	public TwoSortsPanel(int w, int h)
	{
		screenWidth = w;
		screenHeight = h;

		upperBase = screenHeight/2 - 2;
		lowerBase = screenHeight/2 + 2;

		// randomly determine array size in range of 10 - 30
		arraySize = rnd.nextInt(21) + 10;
		selectArray = new int[arraySize];
		insertArray = new int[arraySize];

		boolean[] arrayTracker = new boolean[101];
		int i = 0;

		// populate both arrays with the same random number for each element
		while (i < arraySize)
		{
			int randomInt = rnd.nextInt(100) + 1;

			// ensure number is unique to array(s)
			if (!arrayTracker[randomInt])
			{
				insertArray[i] = selectArray[i] = randomInt;
				arrayTracker[randomInt] = true;
				i++;
			}
		}

		selectPos = insertPos = 0;
		selectColor = Color.BLUE;
		insertColor = Color.RED;

		sortButton = new JButton("Sort");
		sortButton.addActionListener(new SortListener());
		sortButton.setEnabled(true);

		status = new JLabel("Begin passes");
		scope = new JLabel("Array size: " + arraySize);

		add(status);
		add(sortButton);
		add(scope);
		setBackground(Color.white);
		setPreferredSize(new Dimension(screenWidth, screenHeight));
	} // end constructor

	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		int barX = 75;
		int widthX = (screenWidth-100)/arraySize/2;

		g.setColor(selectColor);
		drawSelect(g,barX,widthX);

		g.setColor(insertColor);
		drawInsert(g,barX,widthX);

		drawLegend(g);
	}

	// separate select draw method to fit the spec
	private void drawSelect(Graphics g, int start, int spacer)
	{
		int barX = start;

		Font origFont = g.getFont();
		Font smallerFont = origFont.deriveFont(8.0f);
		g.setFont(smallerFont);

		for (int i = 0;i<arraySize;i++)
		{
			g.fillRect(barX,upperBase - selectArray[i],spacer,selectArray[i]);
			g.drawString(Integer.toString(selectArray[i]),
				barX - (int)Math.log(selectArray[i]),
				upperBase - selectArray[i] - 5);

			barX += spacer*2;
		}
		g.setFont(origFont);
	}

	// separate insert draw method to fit the spec
	private void drawInsert(Graphics g, int start, int spacer)
	{
		int barX = start;

		Font origFont = g.getFont();
		Font smallerFont = origFont.deriveFont(8.0f);
		g.setFont(smallerFont);

		for (int i = 0;i<arraySize;i++)
		{
			g.fillRect(barX,lowerBase,spacer,insertArray[i]);
			g.drawString(Integer.toString(insertArray[i]),
				barX - (int)Math.log(insertArray[i]),
				lowerBase + insertArray[i] + 10);

			barX += spacer*2;
		}
		g.setFont(origFont);
	}

/*	// combo draw method originally created
	// replaced by individual draw methods
	private void drawArrays(Graphics g)
	{
		// horizontal control
		int barX = 75;
		int widthX = (screenWidth-100)/arraySize/2;

		for (int i = 0;i<arraySize;i++)
		{
			g.setColor(selectColor);
			g.fillRect(barX,upperBase - selectArray[i],widthX,selectArray[i]);

			g.setColor(insertColor);
			g.fillRect(barX,lowerBase,widthX,insertArray[i]);

			barX += widthX*2;
		}

	}
*/
	// labels for each sorting bar chart
	private void drawLegend(Graphics g)
	{

		// background
		g.setColor(selectColor);
		g.fillRect(3,upperBase-106,75,20);

		g.setColor(insertColor);
		g.fillRect(3,upperBase+95,75,20);

		// text & borders
		g.setColor(Color.WHITE);

		g.drawString("Select Sort",8,upperBase-91);
		g.drawString("Insert Sort",8,lowerBase+106);

		g.drawRect(3,upperBase-106,75,20);
		g.drawRect(3,upperBase+95,75,20);
	}


	private boolean selectSortByOne()
	{
		if (selectPos < arraySize - 1)
		{
			int min = selectPos;

			// find the next minimum for select sort
			for (int i = selectPos + 1;i<arraySize;i++)
				if (selectArray[i] < selectArray[min])
					min = i;

			// perform the swap
			int temp = selectArray[min];
			selectArray[min] = selectArray[selectPos];
			selectArray[selectPos] = temp;

			selectPos++;

			if (selectPos < arraySize - 1)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	private boolean insertSortByOne()
	{
		if (insertPos + 1 < arraySize)
		{
			int sortedPos = ++insertPos;
			int check = insertArray[sortedPos];

			while (sortedPos > 0 && check < insertArray[sortedPos-1])
			{
				insertArray[sortedPos] = insertArray[sortedPos-1];
				sortedPos--;
			}

			insertArray[sortedPos] = check;

			if (insertPos + 1 < arraySize)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	private class SortListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			boolean select = selectSortByOne();
			boolean insert = insertSortByOne();

			if (!select && !insert)
			{
				selectColor = Color.GRAY;
				insertColor = Color.LIGHT_GRAY;
				sortButton.setText("Sorted");
				sortButton.setEnabled(false);
				status.setText("Passes Complete");
			}
			else
			{
				if (selectPos == 1)
					status.setText(selectPos + " pass");
				else
					status.setText(selectPos + " passes");
			}

			repaint();
		}
	}
}
