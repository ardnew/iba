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
public class IRCEventHandler implements IRCEventListener
{

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private String _name;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public IRCEventHandler(String name)
  {
    this._name = name;
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public String name()
  {
    return this._name;
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
      "IRCEventHandler=" +
      Util.q(
        Util.join(
          this.name()
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
    System.out.println("onRegistered()");
  }

  @Override
  public void onDisconnected()
  {
    System.out.println("onDisconnected()");
  }

  @Override
  public void onError(String msg)
  {
    System.out.println("onError():" + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onError(int num, String msg)
  {
    System.out.println("onError()" + Util.q("" + num, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onInvite(String chan, IRCUser user, String passiveNick)
  {
    System.out.println("onInvite()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] "));
  }

  @Override
  public void onJoin(String chan, IRCUser user)
  {
    System.out.println("onJoin()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] "));
  }

  @Override
  public void onKick(String chan, IRCUser user, String passiveNick, String msg)
  {
    System.out.println("onKick()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onMode(String chan, IRCUser user, IRCModeParser modeParser)
  {
    System.out.println("onMode()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + modeParser, " [", "] "));
  }

  @Override
  public void onMode(IRCUser user, String passiveNick, String mode)
  {
    System.out.println("onMode()" + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + mode, " [", "] "));
  }

  @Override
  public void onNick(IRCUser user, String newNick)
  {
    System.out.println("onNick()" + Util.q("" + user, " [", "] ") + Util.q("" + newNick, " [", "] "));
  }

  @Override
  public void onNotice(String target, IRCUser user, String msg)
  {
    System.out.println("onNotice()" + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onPart(String chan, IRCUser user, String msg)
  {
    System.out.println("onPart()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onPing(String ping)
  {
    System.out.println("onPing()" + Util.q("" + ping, " [", "] "));
  }

  @Override
  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    System.out.println("onPrivmsg()" + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onQuit(IRCUser user, String msg)
  {
    System.out.println("onQuit()" + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onReply(int num, String value, String msg)
  {
    System.out.println("onReply()" + Util.q("" + num, " [", "] ") + Util.q("" + value, " [", "] ") + Util.q("" + msg, " [", "] "));
  }

  @Override
  public void onTopic(String chan, IRCUser user, String topic)
  {
    System.out.println("onTopic()" + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + topic, " [", "] "));
  }

  @Override
  public void unknown(String prefix, String command, String middle, String trailing)
  {
    System.out.println("unknown()" + Util.q("" + prefix, " [", "] ") + Util.q("" + command, " [", "] ") + Util.q("" + middle, " [", "] ") + Util.q("" + trailing, " [", "] "));
  }
}
