package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class Iba
{
  public static void main(String[] args)
  {
    String n = "testlib";
    
    IRCThread t;
    
    t = new IRCThread(
          new IRCHost("irc.binaryshadow.org", 6667, null), 
          new IRCUser(n, n, n), 
          null);
    
    System.out.println(t.toString());
  }
}
