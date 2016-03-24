/**
  SpaceshipPanel.java
  A spaceship that responds to the mouse
  and totally shoots lasers

#########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-14
*/

import java.util.*;
import javax.swing.JPanel;
//import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class SpaceshipPanel extends JPanel
{
  private Point shipCenter, laserTarget;
  private Stars starField;
  private Color defaultShipColor, laserColor;
  private Starship starship;
  private AudioStream sfx;
//  private AudioInputStream sfx;

  private boolean mouseOnScreen;
  private boolean fireAtTarget;

  private final int SHIP_SIZE = 100;
  private int screenWidth;
  private int screenHeight;
  
  private int shotCount;
  private SpaceshipControl countControl;
  
  public SpaceshipPanel(int w, int h)
  {
    mouseOnScreen = false;
    fireAtTarget = false;
    screenWidth = w;
    screenHeight = h;
    laserColor = Color.red;
    
    String mp3 = "laser.mp3";
    String au = "bonk.au";
    try 
    {
      InputStream in = new FileInputStream(au);
      try
      {
        sfx = new AudioStream(in);
      }
      catch (IOException ex)
      {
        System.out.println ("Error: " + ex);
      }    
    }
    catch (FileNotFoundException ex)
    {
      System.out.println ("Error: " + ex);
    }

//    InputStream in = new FileInputStream(au);
    

    starship = new Starship();
    defaultShipColor = starship.getBaseColor();

    ShipListener listener = new ShipListener();
    addMouseListener (listener);
    addMouseMotionListener (listener);

    starField = new Stars(screenWidth, screenHeight);
    starField.generate();
    setBackground (Color.black);
    setPreferredSize (new Dimension(screenWidth, screenHeight));
  }
  
  public void paintComponent (Graphics g)
  {
    super.paintComponent (g);
    
    starField.draw(g);

    if (mouseOnScreen) // only draw ship while mouse is on the screen
    {
      starship.draw(g);
    }

    if (fireAtTarget) // laser draw control
    {
        shipCenter = starship.getPosition();

        g.setColor(laserColor);
        g.drawLine(shipCenter.x,shipCenter.y,laserTarget.x, laserTarget.y);

	} // end laser timer if

    // draw shots fired
    g.setColor(Color.darkGray);
    g.fillRect(20,20,50 + ((int)Math.log10(shotCount)+1)*8,20);
    g.setColor(laserColor);
    g.drawRect(20,20,50 + ((int)Math.log10(shotCount)+1)*8,20);
    g.setColor(Color.white);
    g.drawString("Shots: " + shotCount,24,35);
    
    // draw button
    countControl.update();
  }
  
  public void setControl(SpaceshipControl control)
  {
    countControl = control;
  }
  
  public boolean isCountZero()
  {
    return (shotCount == 0);
  }
  
  public void resetCount()
  {
    shotCount = 0;
    repaint();
  }
  
  public int getCount()
  {
    return shotCount;
  }
  
  // draws the space ship based on a center point
  private class ShipListener implements MouseListener,
                                         MouseMotionListener
  {
    // update ship's position during mouse movement
    public void mouseMoved (MouseEvent event) 
    {
      starship.setPosition(event.getPoint());
      repaint();
    }

    // make sure ship is drawn while mouse is on screen
    public void mouseEntered (MouseEvent event) 
    {
      mouseOnScreen = true;
      repaint();
    }

    // hide the ship when mouse is off screen
    public void mouseExited (MouseEvent event) 
    {
      mouseOnScreen = false;
      repaint();
    }

    // set laser target once, increment shot counter
    public void mousePressed (MouseEvent event) 
    {
      // fire laser, get a new target once
      if (!fireAtTarget)
      {
        laserTarget = acquireTarget();
        fireAtTarget = true;
        if (shotCount == 0)
          countControl.enableButton();
        shotCount++;
//        AudioPlayer.player.start(sfx);
      }
      repaint();
    }
    
    // finish laser fire
    public void mouseReleased (MouseEvent event) 
    {
      fireAtTarget = false; 
      repaint();
    }

    // move the ship during laser fire
    public void mouseDragged (MouseEvent event) 
    {
      starship.setPosition(event.getPoint());
      repaint();
    }
    // unused event
    public void mouseClicked (MouseEvent event) {}
  }
    
  private Point acquireTarget()
  {
    // set a new laser color
    int colorShift = shotCount % 6;
    
    if (colorShift == 0)
      laserColor = Color.red;
    else if (colorShift == 1)
      laserColor = Color.green;
    else if (colorShift == 2)
      laserColor = Color.cyan;
    else if (colorShift == 3)
      laserColor = Color.magenta;
    else if (colorShift == 4)
      laserColor = Color.yellow;
    else
      laserColor = Color.blue;

    // laser always fires at or below the ship's center
    shipCenter = starship.getPosition();
    int targetAngle = (int)(Math.random()*181+180);

    int targetX = shipCenter.x + (int)(screenWidth * 2 * Math.cos(targetAngle));
    int targetY = shipCenter.y + (int)(screenHeight*2*Math.abs(Math.sin(targetAngle)));
    
    return new Point(targetX, targetY);
  }

}