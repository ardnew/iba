package com.ardnew.iba;

import org.schwering.irc.lib.IRCConnection;

/**
 *
 * @author ardnew
 */
public class IRCThread extends IRCConnection
{
  private enum ConnectionState { csNone, csConnecting, csClosing, csActive };
  
  private IRCHost host;
  private IRCUser user;
  
  public IRCThread(IRCHost host, IRCUser user)
  {
    super(host.host(), new int[]{ host.port() }, host.pass(), user.nick(), user.user(), user.name());
    
    this.host = host;
    this.user = user;
  }
  
  public IRCHost host()
  {
    return this.host;
  }
  
  public IRCUser user()
  {
    return this.user;
  }
}
