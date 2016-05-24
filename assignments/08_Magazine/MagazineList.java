// original header
//*******************************************************************
//  MagazineList.java       Author: Lewis/Loftus
//  Represents a collection of magazines.
//*******************************************************************
/** Class header
  MagazineList.java
  Manages MagazineNodes to create
  a linked list of Magazine objects
############################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2016-05-12
*/

public class MagazineList
{
  private MagazineNode list;

  //----------------------------------------------------------------
  //  Sets up an initially empty list of magazines.
  //----------------------------------------------------------------
  public MagazineList()
  {
    list = null;
  }

  //----------------------------------------------------------------
  // Returns true if the list is empty
  //----------------------------------------------------------------
  public boolean isEmpty()
  {
    return list == null;
  }
  //----------------------------------------------------------------
  //  Creates a new MagazineNode object and adds it to the end of
  //  the linked list.
  //----------------------------------------------------------------
  public void add (Magazine mag)
  {

    MagazineNode node = new MagazineNode (mag);
    MagazineNode current;

    if (list == null)
      list = node;
    else
    {
      current = list;
      while (current.next != null)
        current = current.next;
      current.next = node;
    }

  }

  //----------------------------------------------------------------
  //  Creates a new MagazineNode object and adds it to the beginning
  //  of the linked list.
  //----------------------------------------------------------------
  public void insert (Magazine mag)
  {
    MagazineNode node = new MagazineNode(mag);
    node.next = list;
    list = node;

  }

  //----------------------------------------------------------------
  //  Disconnects the list to be garbage collected
  //----------------------------------------------------------------
  public void deleteAll()
  {
    list = null;
  }

  //----------------------------------------------------------------
  //  Deletes a MagazineNode based on the passed String
  //  returns true if deletion was successful
  //----------------------------------------------------------------
  public boolean delete(String del)
  {
    MagazineNode current = list;
    MagazineNode prev = null;
    boolean deleted = false; // loop control & return

    while (!deleted && current != null)
    {
      if (del.compareTo(current.magazine.toString()) == 0)
      {
        if (prev != null) // are we in the middle of the list?
          prev.next = current.next;
        else // must be at the start of the list
          list = current.next;

        deleted = true; // we only delete the first match found
      }
      else // no match, prep next node to be tested
      {
        prev = current;
        current = current.next;
      }
    }

    return deleted;
  }

  //----------------------------------------------------------------
  //  Returns this list of magazines as a string.
  //----------------------------------------------------------------
  public String toString ()
  {
    String result = "";

    MagazineNode current = list;

    while (current != null)
    {
      result += current.magazine + "\n";
      current = current.next;
    }

    return result;
  }

  //*****************************************************************
  //  An inner class that represents a node in the magazine list.
  //  The public variables are accessed by the MagazineList class.
  //*****************************************************************
  private class MagazineNode
  {
    public Magazine magazine;
    public MagazineNode next;

    //--------------------------------------------------------------
    //  Sets up the node
    //--------------------------------------------------------------
    public MagazineNode (Magazine mag)
    {
      magazine = mag;
      next = null;
    }

    //----------------------------------------------------------------
    //  Returns the title of the stored Magazine
    //----------------------------------------------------------------
    public String toString()
    {
        return magazine.toString();
    }

  }
}
