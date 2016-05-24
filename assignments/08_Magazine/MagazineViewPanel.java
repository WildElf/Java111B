/**
  MagazinePanel.java
  Displays a MagazineList of Magazine objects
  within a JPanel also handling user input
  and display in subpanels
############################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2016-05-13
*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

public class MagazineViewPanel extends JPanel
{
  private MagazineList rack;

  private JLabel addZineLabel;
  private Scanner userInput;
  private TextField inputField;

  private TextArea zineArea;

  private TextField deleteField;
  private JLabel deleteMagazineLabel;
  private JLabel deleteResultsLabel;
  private JButton deleteAll;

  private JPanel inputPanel;
  private JPanel areaPanel;
  private JPanel controlPanel;

  public final int SCREEN_WIDTH = 500;
  public final int SCREEN_HEIGHT = 250;

  public MagazineViewPanel(MagazineList r)
  {
    rack = r;
    BorderLayout bLayout = new BorderLayout();
    setLayout(bLayout);

    // user input panel components
    userInput = new Scanner(System.in);
    userInput.useDelimiter("\n");
    addZineLabel = new JLabel("Insert Magazine: ");
    try
    {
      inputField = new TextField("",16);
    }
    catch (HeadlessException e)
    {
      System.out.println("ERROR: " + e.toString());
    }
    inputField.addActionListener(new FieldListener());

    // input panel creation
    inputPanel = new JPanel();
    inputPanel.add(addZineLabel);
    inputPanel.add(inputField);

    // text area and panel creation
    try
    {
      zineArea = new TextArea();
    }
    catch (Exception e)
    {
      System.out.println("ERROR: " + e.toString());
    }
    zineArea.setEditable(false);
    areaPanel = new JPanel();
    areaPanel.add(zineArea);

    // control (e.g. delete) operations and panel creation
    deleteMagazineLabel = new JLabel("Delete Magazine: ");
    try
    {
      deleteField = new TextField("",16);
    }
    catch (HeadlessException e)
    {
      System.out.println("ERROR: " + e.toString());
    }
    deleteField.addActionListener(new DeleteOneListener());
    deleteResultsLabel = new JLabel("         ");
    deleteResultsLabel.setPreferredSize(new Dimension(64,16));
    deleteAll = new JButton("Delete All");
    deleteAll.addActionListener(new DeleteAllListener());
    deleteAll.setEnabled(false);
    controlPanel = new JPanel();
    controlPanel.add(deleteMagazineLabel);
    controlPanel.add(deleteField);
    controlPanel.add(deleteResultsLabel);
    controlPanel.add(deleteAll);

    // panel layouts
    add(inputPanel, bLayout.NORTH);
    add(areaPanel, bLayout.CENTER);
    add(controlPanel, bLayout.SOUTH);

    setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
  }

  private void addZine(String s)
  {
    String title = s;
    Magazine mag = new Magazine(title);
    rack.insert(mag);
  }

  private class FieldListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      addZine(inputField.getText());
      inputField.setText("");
      zineArea.setText(rack.toString());
      deleteAll.setEnabled(true);
    }
  }

  private class DeleteAllListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      rack.deleteAll();
      zineArea.setText(rack.toString());
      deleteAll.setEnabled(false);
    }
  }

  private class DeleteOneListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      Dimension print = new Dimension();
      if (rack.delete(deleteField.getText()))
      {
        deleteField.setText("");
        deleteResultsLabel.setText("         ");
        zineArea.setText(rack.toString());
      }
      else
        deleteResultsLabel.setText("Not found");

//      print = deleteLabel.getSize(print);
//      System.out.println(print.toString());

      if (rack.isEmpty())
        deleteAll.setEnabled(false);
    }
  }
}
