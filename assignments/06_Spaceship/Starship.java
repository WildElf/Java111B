/**
  Creates a starship
  with a custom size
  and draws around a center point
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
// Begin Constructors
// *********************************
/**
  Default constructor
  Configures a starship shape and colors that can be drawn
  
  @param  int  sets the size of the ship, default 100
  @param  Point  ship's center point, default new Point()
  @param  Color  ship's main color, from which a brighter and darker shade are made
                default is GRAY.
*/
  public Starship()
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = new Point();
  }
  
/**
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = new Point();
  }

/**
  @param  int  sets the size of the ship, default 100
  @param  Point  ship's center point
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(Point center)
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = center;
  }
  
/**
  @param  int  ship's center point at x, to create new point, default Point.getx()
  @param  int  ship's center point at y, to create new point, default Point.gety()
*/
  public Starship(int x, int y)
  {
    shipSize = 100;
    setColor(Color.gray);
    shipCenter = new Point(x,y);
  }
  
/**
  @param  int  sets the size of the ship, default 100
  @param  Point  ship's center point
*/
  public Starship(int size, Point center)
  {
    setSize(size);
    setColor(Color.gray);
    shipCenter = center;
  }
  
/**
  @param  int  sets the size of the ship, default 100
  @param  int  ship's center point at x, to create new point, default Point.getx()
  @param  int  ship's center point at y, to create new point, default Point.gety()
*/
  public Starship(int size, int x, int y)
  {
    setSize(size);
    setColor(Color.gray);
    shipCenter = new Point(x,y);
  }
  
/**
  @param  Point  ship's center point
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(Point center, Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = center;
  }
  
/**
  @param  int  ship's center point at x, to create new point, default Point.getx()
  @param  int  ship's center point at y, to create new point, default Point.gety()
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(int x, int y, Color color)
  {
    shipSize = 100;
    setColor(color);
    shipCenter = new Point(x,y);
  }
  
/**
  @param  int  sets the size of the ship, default 100
  @param  Point  ship's center point
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(int size, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = new Point();
  }

/**
  @param  int  sets the size of the ship, default 100
  @param  Point  ship's center point
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(int size, Point center, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = center;
  }
  
/**
  @param  int  sets the size of the ship, default 100
  @param  int  ship's center point at x, to create new point, default Point.getx()
  @param  int  ship's center point at y, to create new point, default Point.gety()
  @param  Color  ship's main color, from which a brighter and darker shade are made
*/
  public Starship(int size, int x, int y, Color color)
  {
    setSize(size);
    setColor(color);
    shipCenter = new Point(x,y);
  } 
// *********************************
// End Constructors
// *********************************
// Begin public methods
// *********************************

/**
  @param int  changes the ship's size, which will update with the next draw call
*/
  public void setSize(int size)
  {
    if (Math.abs(size) > 0)
      shipSize = Math.abs(size);
    else
      shipSize = 100;
  }
  
/**
  @param Color  changes the value of the ship's base color 
                and derives the darker and brighter colors
*/
  public void setColor(Color color)
  {
    shipColor = color;
    shipColorShade = color.darker();
    shipColorHigh = color.brighter();
  }
  
/**
  @param Point  changes the value of the ship's center point
*/
  public void setPosition(Point center)
  {
    shipCenter = center;
  }
  
/**
  uses two integers to update the ships center Point
  @param int  changes the value of the ship's x position
  @param int  changes the value of the ship's y position
*/
  public void setPosition(int x, int y)
  {
    shipCenter.x = x;
    shipCenter.y = y;
  }
  
/**
  @return Point  the value of the ship's center
*/
  public Point getPosition()
  {
    return shipCenter;
  }
  
/**
  @return Color  the value of the ship's primary color
*/
  public Color getBaseColor()
  {
    return shipColor;
  }
  
/**
  @return Color  the value of the ship's brighter color
*/
  public Color getHighColor()
  {
    return shipColorHigh;
  }
  
/**
  @return Color  the value of the ship's darker color
*/
  public Color getShadeColor()
  {
    return shipColorShade;
  }
  
/**
  @return int  the value of the ship's size
*/
  public int getSize()
  {
    return shipSize;
  }
    
  // draw the ship's parts with colors applied
  public void draw(Graphics g)
  {
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
// *********************************
// End public methods
// *********************************
// Begin private methods
// *********************************
/**
  @return Polygon  a rhomboid based on ship size to serve as the ships middle body
*/
  private Polygon buildMiddleBody()
  {
    int[] midBodyX = { shipCenter.x-shipSize/2, shipCenter.x+shipSize/2, 
            shipCenter.x+shipSize/2-shipSize/10, shipCenter.x-shipSize/2+shipSize/10 };
    int[] midBodyY = { shipCenter.y, shipCenter.y, 
            shipCenter.y-shipSize/10, shipCenter.y-shipSize/10 };
    
    return new Polygon(midBodyX, midBodyY, Array.getLength(midBodyX)); 
  }
  
/**
  @return Polygon  a rhomboid based on ship size to serve as the ships lower body
*/
  private Polygon buildLowBody()
  {
    int[] lowerBodyX = { (int)(shipCenter.x-shipSize/3), (int)(shipCenter.x+shipSize/3), 
            (int)(shipCenter.x+shipSize/3-shipSize/10), (int)(shipCenter.x-shipSize/3+shipSize/10) };
    int[] lowerBodyY = { shipCenter.y, shipCenter.y, 
            shipCenter.y+shipSize/12, shipCenter.y+shipSize/12 };
    
    return new Polygon(lowerBodyX, lowerBodyY, Array.getLength(lowerBodyX));
  }
  
/**
  @return Polygon  a rhomboid based on ship size to serve as the ships upper body
*/
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