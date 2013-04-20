package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class IRCPeer 
{
  private String nick;
  private String user; 
  private String name;
  
  public IRCPeer(String nick, String user, String name)
  {
    this.nick = nick;
    this.user = user;
    this.name = name;
  }
  
  public String nick()
  {
    return this.nick;
  }
  
  public String user()
  {
    return this.user;
  }
  
  public String name()
  {
    return this.name;
  }
}
