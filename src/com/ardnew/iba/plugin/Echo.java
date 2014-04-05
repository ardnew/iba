package com.ardnew.iba.plugin;

import com.ardnew.iba.IRCEventHandler;
import com.ardnew.iba.IRCThread;

import org.schwering.irc.lib.IRCUser;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   Echo.java
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
public final class Echo extends IRCEventHandler
{
     
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private static class fields
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  private static final String NAME = "ECHO";
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public Echo(IRCThread conn, boolean actv)
  {
    super(conn, Echo.NAME, actv);
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods declared in super class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

  @Override
  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    /*
    if (this.actv())
    {
      this.printOutputUserMessage(Util.q("PRIVMSG") + Util.q(target) + Util.q(user.getNick()) + Util.q(msg));  
    }
    */
  }  
}