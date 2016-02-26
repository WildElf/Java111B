/**
  Creates a starship
  with a custom size
  and defined center point
###########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-23
*/

import javax.swing.JPanel;
import java.awt.*;
import java.lang.reflect.Array;

public class Starship
{
  // main utility variables
  private Point shipCenter;
  private int shipSize;
  
  // for drawing the ship
  private Polygon shipBodyTop, shipBodyMid, shipBodyLow;
  private Color shipColor, shipColorHigh, shipColorShade;
  
  // *********************************
  // begin constructors
  // default constructor
  public Starship()
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = new Point();
  }
  
  public Starship(Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = new Point();
  }

  public Starship(Point center)
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = center;
  }
  
  public Starship(int x, int y)
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = new Point(x,y);
  }
  
  public Starship(int size, Point center)
  {
    setSize(size);
    setColor(Color.gray);
    shipCenter = center;
  }
  
  public Starship(int size, int x, int y)
  {
    setSize(size);
    setColor(Color.gray);
    shipCenter = new Point(x,y);
  }
  
  public Starship(Point center, Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = center;
  }
  
  public Starship(int x, int y, Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = new Point(x,y);
  }
  
  // Size
  public Starship(int size, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = new Point();
  }

  // Custom size; custom point, custom color constructor
  public Starship(int size, Point center, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = center;
  }
  
/**

*/
  public Starship(int size, int x, int y, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = new Point(x,y);
  } // end constructors
  // *********************************

  public void setSize(int size)
  {
    if (Math.abs(size) > 0)
      shipSize = Math.abs(size);
    else
      shipSize = 100;
  }
  
  public void setColor(Color color)
  {
    shipColor = color;
    shipColorShade = color.darker();
    shipColorHigh = color.brighter();
  }
  
  public void setPosition(Point center)
  {
    shipCenter = center;
  }
  
  public void setPosition(int x, int y)
  {
    shipCenter.x = x;
    shipCenter.y = y;
  }
  
  public Point getPosition()
  {
    return shipCenter;
  }
  
  public Color getBaseColor()
  {
    return shipColor;
  }
  
  public Color getHighColor()
  {
    return shipColorHigh;
  }
  
  public Color getShadeColor()
  {
    return shipColorShade;
  }
  
  public int getSize()
  {
    return shipSize;
  }
  
  public void draw(Graphics g)
  {
//    setPosition(shipLoc);
    shipBodyMid = buildMiddleBody();
    shipBodyLow = buildLowBody();
    shipBodyTop = buildTopBody();    
    
    g.setColor(shipColor);
    g.fillPolygon(shipBodyMid);
    
    g.setColor(shipColorShade);
    g.fillPolygon(shipBodyLow);
    
    g.setColor(shipColorHigh);
    g.fillPolygon(shipBodyTop);
	
  }
  
  private Polygon buildMiddleBody()
  {
    int[] midBodyX = { shipCenter.x-shipSize/2, shipCenter.x+shipSize/2, 
            shipCenter.x+shipSize/2-shipSize/10, shipCenter.x-shipSize/2+shipSize/10 };
    int[] midBodyY = { shipCenter.y, shipCenter.y, 
            shipCenter.y-shipSize/10, shipCenter.y-shipSize/10 };
    
    return new Polygon(midBodyX, midBodyY, Array.getLength(midBodyX)); 
  }
  
  private Polygon buildLowBody()
  {
    int[] lowerBodyX = { (int)(shipCenter.x-shipSize/3), (int)(shipCenter.x+shipSize/3), 
            (int)(shipCenter.x+shipSize/3-shipSize/10), (int)(shipCenter.x-shipSize/3+shipSize/10) };
    int[] lowerBodyY = { shipCenter.y, shipCenter.y, 
            shipCenter.y+shipSize/12, shipCenter.y+shipSize/12 };
    
    return new Polygon(lowerBodyX, lowerBodyY, Array.getLength(lowerBodyX));
  }
  
  private Polygon buildTopBody()
  {
    int[] topBodyX = { shipCenter.x-shipSize/5, shipCenter.x+shipSize/5, 
            shipCenter.x+shipSize/6, shipCenter.x+shipSize/8,
             shipCenter.x-shipSize/8, shipCenter.x-shipSize/6 };
    int[] topBodyY = { shipCenter.y-shipSize/10, shipCenter.y-shipSize/10, 
            shipCenter.y-shipSize/8, shipCenter.y-shipSize/7,
             shipCenter.y-shipSize/7, shipCenter.y-shipSize/8 };
    
    return new Polygon(topBodyX, topBodyY, Array.getLength(topBodyX));
  
  }

}