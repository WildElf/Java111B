/**
  SpaceshipControl.java
  Create & control a button that displays & resets
  the laser shot count for a SpaceshipPanel

#########################################
  @author: E. Jo Zimmerman
  @version: 1.2
  @since: 2015-04-07
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceshipControl extends JPanel
{
  private SpaceshipPanel spaceship;
  private JButton reset, sound;
  private boolean soundOn;
//  private JLabel shots;
//  private JPanel resetPanel;

  public SpaceshipControl(SpaceshipPanel shipPanel)
  {
    setLayout(new BorderLayout());

    spaceship = shipPanel;
    reset = new JButton("Reset Shots");
    reset.setEnabled (!spaceship.isCountZero());
    reset.addActionListener (new ResetListener());

    sound = new JButton("Sound Off");
    soundOn = false;
    sound.setEnabled(true);
    sound.addActionListener (new SoundListener());

    setPreferredSize(new Dimension(20,75));
    setBackground(Color.darkGray);

    spaceship.add(reset, BorderLayout.NORTH);
    spaceship.add(sound, BorderLayout.NORTH);
    spaceship.setControl(this);
  }

  public void enableReset()
  {
    reset.setEnabled (true);
  }

  public void update()
  {
    reset.setEnabled (!spaceship.isCountZero());
//    shots.setText("Shots: " + spaceship.getCount());
  }

  private class ResetListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      reset.setEnabled (false);
      spaceship.resetCount();
//      shots.setText("Shots: " + spaceship.getCount());
    }
  }

  private class SoundListener implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      if (soundOn)
      {
        sound.setText("Sound Off");
        soundOn = false;
        spaceship.soundOff();
      }
      else
      {
        sound.setText("Sound On");
        soundOn = true;
        spaceship.soundOn();
      }
    }
  }
}
