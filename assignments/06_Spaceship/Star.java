/**
  Creates a star background
  Using theme(int) as a multiplier
  so that the brighter the sky, fewer stars
  Also draws 10% of stars brighter
###########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-16
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.lang.reflect.Array;

public class Star
{
  private Point position;
  private int brightness;
  private Color color;

  public Star()
  {
    position = new Point(0,0);
    setBrightness();
    color = makeColor();

  }

  public Star(int x, int y)
  {
    position = new Point(x, y);
    setBrightness();
    color = makeColor();
  }

  public Star(Point p)
  {
    position = p;
    setBrightness();
    color = makeColor();
  }

  public Star(int x, int y, int b)
  {
    position = new Point(x, y);
    brightness = b;
    color = makeColor();
  }

  public Star(Point p, int b)
  {
    position = p;
    brightness = b;
    color = makeColor();
  }

  public Point getPosition()
  {
    return position;
  }

  public int getX()
  {
    return position.x;
  }

  public int getY()
  {
    return position.y;
  }

  public Color getColor()
  {
    return color;
  }

  public int getBrightness()
  {
    return brightness;
  }

  private Color makeColor()
  {
    Color starColor = Color.white;
    if (brightness < 9)
      for (int i = brightness; i < 8; i++)
    	starColor = starColor.darker();
    else if (brightness >= 10)
    {
      int randColor = (int)(Math.random()*20) + 1;
   	  if (randColor == 1)
        starColor = Color.cyan.brighter();
      else if (randColor >= 2 && randColor <= 8)
        starColor = Color.yellow.brighter();
      else if (randColor >= 9 && randColor <= 12)
        starColor = Color.orange.brighter();
      else if (randColor == 13)
        starColor = Color.magenta.brighter();

    }

    return starColor;
  }

  private void setBrightness()
  {
    int randBright = (int)(Math.random()*1000);

    if (randBright < 10)
    {
      if (randBright == 0)
        brightness = 10; // 1 in 1000 is a super bright star
      else
        brightness = 9; // 1 in 100 stars are brighter
    }
    else if (randBright < 110)
      brightness = 0; // one in ~10 is a point that's a shade of white
    else if (randBright < 205)
      brightness = 1;
    else if (randBright < 300)
      brightness = 2;
    else if (randBright < 400)
      brightness = 3;
    else if (randBright < 500)
      brightness = 4;
    else if (randBright < 600)
      brightness = 5;
    else if (randBright < 725)
      brightness = 6;
    else if (randBright < 850)
      brightness = 7;
    else
      brightness = 8; // this will be a normal white star
  }
}
