package com.ardnew.iba;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author ardnew
 */
public class Iba
{
  public static void main(String[] args)
  { 
    IRCThread t;
    
    t = new IRCThread(
          new IRCHost("irc.binaryshadow.org", 6667, null), 
          new IRCUser("nick", "user", "name"), 
          new LinkedList<IRCEventHandler>(
            Arrays.asList(
              new IRCEventHandler("main event handler"))
          )
        );
    
    System.out.println(t.toString());
    
    t.setColors(false);
    t.setPong(true);
    
    try
    {
      t.connect();
    }
    catch (Exception e)
    {
      System.err.println("In class Iba:\n" + e.getMessage());
    }
  }
}
