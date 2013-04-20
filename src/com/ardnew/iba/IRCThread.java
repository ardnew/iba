package com.ardnew.iba;

import java.util.LinkedList;

import org.schwering.irc.lib.IRCConnection;

/**
 *
 * @author ardnew
 */
public class IRCThread extends IRCConnection
{
  private enum ConnectionState { csNone, csConnecting, csClosing, csActive };
  
  private IRCHost _host;
  private IRCUser _user;
  
  private LinkedList<IRCEventHandler> _hook;
  
  public IRCThread(IRCHost host, IRCUser user, LinkedList<IRCEventHandler> hook) throws IllegalArgumentException
  {
    super(host.host(), new int[]{ host.port() }, host.pass(), user.nick(), user.user(), user.name());
    
    try
    {
      for (IRCEventHandler e : hook) 
      { 
        this.addIRCEventListener(e); 
      }
    }
    catch (NullPointerException e)
    {
      hook = new LinkedList<IRCEventHandler>();
    }
    finally
    {
      this._host = host;
      this._user = user;
      this._hook = hook;      
    }
  }
  
  public IRCHost host()
  {
    return this._host;
  }
  
  public IRCUser user()
  {
    return this._user;
  }
  
  public LinkedList<IRCEventHandler> hook()
  {
    return this._hook;
  }
  
  @Override
  public String toString()
  {
    return 
      "IRCThread=" +
      Util.q(
        Util.join(
          this.host().toString(), 
          this.user().toString(),
          "IRCHookList=" + 
          Util.q(
            Util.join(
              this.hook().toArray()
            )
          )
        )
      );
  }
}
