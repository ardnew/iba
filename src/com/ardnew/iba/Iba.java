package com.ardnew.iba;

import java.util.Arrays;
import java.util.LinkedList;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   Iba.java
//
// description:
//   TODO
//
// author:
//   ardnew, andrew@ardnew.com
//
// date:
//   April 20, 2013
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Iba
{

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// application entry point - main method
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public static void main(String[] args)
  { 
    IRCThread t;
    
    IRCHost host = new IRCHost("irc.binaryshadow.org", 6667, null);    
    IRCUser user = new IRCUser("nickname", "username", "realname");
    
    LinkedList<IRCEventHandler> evhl = 
      new LinkedList<IRCEventHandler>(Arrays.asList(new IRCEventHandler("default handler")));
    
    // instantiate the connection thread (but do NOT dispatch)
    t = new IRCThread(host, user, evhl);
    
    // perform any pre-connect configurations
    t.setColors(false);
    t.setPong(true);
    
    // establish the connection and let the event handlers take control from here
    try
    {
      t.connect();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
