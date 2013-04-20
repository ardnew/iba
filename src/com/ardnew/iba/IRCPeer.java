package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class IRCPeer 
{
  private String _nick;
  private String _user; 
  private String _name;
  
  public IRCPeer(String nick, String user, String name)
  {
    this._nick = nick;
    this._user = user;
    this._name = name;
  }
  
  public String nick()
  {
    return this._nick;
  }
  
  public String user()
  {
    return this._user;
  }
  
  public String name()
  {
    return this._name;
  }
  
  @Override
  public String toString()
  {
    return Util.join(
      Util.q(this.nick()),
      Util.q(this.user()),
      Util.q(this.name())
    );
  }
}
