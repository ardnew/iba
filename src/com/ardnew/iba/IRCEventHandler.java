package com.ardnew.iba;

import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   IRCEventHandler.java
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
abstract public class IRCEventHandler implements IRCEventListener
{

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private IRCThread _conn;
  protected String _name;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public IRCEventHandler(IRCThread conn, String name)
  {
    this._conn = conn;
    this._name = name;
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public IRCThread conn()
  {
    return this._conn;
  }
    
  public String name()
  {
    return this._name;
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// protected methods
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  
  protected void outputMessage(String message)
  {
    System.out.println(Util.q(this.name() + ":" + this.conn().user().nick()) + message);
  }
  
  protected void outputMessage(String[] message)
  {
    for (String s : message) { outputMessage(s); }
  }
  
  protected void errorMessage(String message)
  {
    System.err.println(Util.errorLineSpan());
    System.err.println(Util.qe(this.name() + ":" + this.conn().user().nick()) + message);
    System.err.println(Util.errorLineSpan());
  }
  
  protected void errorMessage(String[] message)
  {
    for (String s : message) { errorMessage(s); }
  }  

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods declared in super class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public String toString()
  {
    return 
      "IRCEventHandler(" + this.hashCode() + ")=" +
      Util.q(
        Util.join(
          this.name(),
          this.conn().hashCode()
        )
      );
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods implementing interfaces
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public void onRegistered()
  {
    /* NOP */ ;
  }

  @Override
  public void onDisconnected()
  {
    /* NOP */ ;
  }

  @Override
  public void onError(String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onError(int num, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onInvite(String chan, IRCUser user, String passiveNick)
  {
    /* NOP */ ;
  }

  @Override
  public void onJoin(String chan, IRCUser user)
  {
    /* NOP */ ;
  }

  @Override
  public void onKick(String chan, IRCUser user, String passiveNick, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onMode(String chan, IRCUser user, IRCModeParser modeParser)
  {
    /* NOP */ ;
  }

  @Override
  public void onMode(IRCUser user, String passiveNick, String mode)
  {
    /* NOP */ ;
  }

  @Override
  public void onNick(IRCUser user, String newNick)
  {
    /* NOP */ ;
  }

  @Override
  public void onNotice(String target, IRCUser user, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onPart(String chan, IRCUser user, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onPing(String ping)
  {
    /* NOP */ ;
  }

  @Override
  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onQuit(IRCUser user, String msg)
  {
    /* NOP */ ;
  }

  @Override
  public void onReply(int num, String value, String msg)
  {
    /* NOP */ ;
  } 

  @Override
  public void onTopic(String chan, IRCUser user, String topic)
  {
    /* NOP */ ;
  }

  @Override
  public void unknown(String prefix, String command, String middle, String trailing)
  {
    /* NOP */ ;
  }
}
