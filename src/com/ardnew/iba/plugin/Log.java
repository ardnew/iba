package com.ardnew.iba.plugin;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

import com.ardnew.iba.IRCEventHandler;
import com.ardnew.iba.IRCThread;
import com.ardnew.iba.Util;

import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   Log.java
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
public final class Log extends IRCEventHandler
{
  
  private static final String NAME = "LOG";
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private PrintWriter log;
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public Log(IRCThread conn)
  {
    super(conn, Log.NAME);
    
    String fn = super.conn().user().nick() + ".log";
    
    try
    {
      this.log = new PrintWriter(new BufferedWriter(new FileWriter(fn, true)));
    }
    catch (Exception e)
    {
      errorMessage("error opening log file \"" + fn + "\" for append: " + e.getMessage());
    }
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public PrintWriter log()
  {
    return this.log;
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// public methods
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  
  public void append(String message)
  {
    this.log().append(Util.q(this.name() + ":" + this.conn().user().nick()) + message);
    this.log().flush();
  }
  
  public void append(String[] message)
  {
    for (String s : message) { append(s); }
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods declared in super class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  @Override
  public void onRegistered()
  {
    append("onRegistered: " + '\n');
  }

  @Override
  public void onDisconnected()
  {
    append("onDisconnected: " + '\n');
  }

  @Override
  public void onError(String msg)
  {
    append("onError: " + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onError(int num, String msg)
  {
    append("onError: " + Util.q("" + num, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onInvite(String chan, IRCUser user, String passiveNick)
  {
    append("onInvite: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + '\n');
  }

  @Override
  public void onJoin(String chan, IRCUser user)
  {
    append("onJoin: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + '\n');
  }

  @Override
  public void onKick(String chan, IRCUser user, String passiveNick, String msg)
  {
    append("onKick: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onMode(String chan, IRCUser user, IRCModeParser modeParser)
  {
    append("onMode: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + modeParser, " [", "] ") + '\n');
  }

  @Override
  public void onMode(IRCUser user, String passiveNick, String mode)
  {
    append("onMode: " + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + mode, " [", "] ") + '\n');
  }

  @Override
  public void onNick(IRCUser user, String newNick)
  {
    append("onNick: " + Util.q("" + user, " [", "] ") + Util.q("" + newNick, " [", "] ") + '\n');
  }

  @Override
  public void onNotice(String target, IRCUser user, String msg)
  {
    append("onNotice: " + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onPart(String chan, IRCUser user, String msg)
  {
    append("onPart: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onPing(String ping)
  {
    append("onPing: " + Util.q("" + ping, " [", "] ") + '\n');
  }

  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    append("onPrivmsg: " + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onQuit(IRCUser user, String msg)
  {
    append("onQuit: " + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onReply(int num, String value, String msg)
  {
    append("onReply: " + Util.q("" + num, " [", "] ") + Util.q("" + value, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onTopic(String chan, IRCUser user, String topic)
  {
    append("onTopic: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + topic, " [", "] ") + '\n');
  }

  @Override
  public void unknown(String prefix, String command, String middle, String trailing)
  {
    append("unknown: " + Util.q("" + prefix, " [", "] ") + Util.q("" + command, " [", "] ") + Util.q("" + middle, " [", "] ") + Util.q("" + trailing, " [", "] ") + '\n');
  }
}
