package com.ardnew.iba.plugin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.HashMap;

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
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private static class fields
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
  private static final String NAME = "LOG";
  private static final String SLOG = "SYS";
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private HashMap<String, PrintWriter> _log;  
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public Log(IRCThread conn, boolean actv)
  {
    super(conn, Log.NAME, actv);
    
    this._log = new HashMap<String, PrintWriter>();
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public PrintWriter log(String target) throws ClassCastException, IOException
  {
    // automatically create a log file for whichever target we received
    
    if (!this._log.containsKey(target))
    {
      String s = this.logPath(target + Util.DEFAULT_LOG_FILE_EXTENSION);
      
      this._log.put(target, 
        new PrintWriter(new BufferedWriter(new FileWriter(Util.createFile(s, false), true))));
    }
    return this._log.get(target);
  }    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// public methods
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  
  public void append(String chan, String message)
  {
    if (this.actv())
    {
      try
      {
        this.log(chan).append(this.outputUserMessage(message));
        this.log(chan).flush();
      }
      catch (Exception ex)
      {
        this.printErrorUserMessage(
          Util.qe("error writing to log file \"" + this._log.get(chan) + "\" for append") + ex.getMessage());
      }
    }
  }
  
  public void append(String chan, String[] message)
  {
    for (String s : message) { this.append(chan, s); }
  }
  
  public String logPath(String fileName)
  {
    // 
    // see IbaConstant.java for these global constants
    //
    // returns the path: 
    //   /DEFAULT_LOG_PATH/DEFAULT_LOG_DIRNAME/connection-hostname/file-name
    //
    return Util.joinWithString(Util.PATH_DELIMITER,                  
      // root log directory
      Util.joinWithString(Util.PATH_DELIMITER, 
        Util.DEFAULT_LOG_PATH, 
        Util.DEFAULT_LOG_DIRNAME),
      // nick directory
      this.conn().user().nick(),
      // host directory
      this.conn().host().host(),
      // filename parameter
      fileName);
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods declared in super class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  @Override
  public void onRegistered()
  {
    this.append(Log.SLOG, "onRegistered: " + '\n');
  }

  @Override
  public void onDisconnected()
  {
    this.append(Log.SLOG, "onDisconnected: " + '\n');
  }

  @Override
  public void onError(String msg)
  {
    this.append(Log.SLOG, "onError: " + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onError(int num, String msg)
  {
    this.append(Log.SLOG, "onError: " + Util.q("" + num, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onInvite(String chan, IRCUser user, String passiveNick)
  {
    this.append(Log.SLOG, "onInvite: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + '\n');
  }

  @Override
  public void onJoin(String chan, IRCUser user)
  {
    this.append(chan, "onJoin: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + '\n');
  }

  @Override
  public void onKick(String chan, IRCUser user, String passiveNick, String msg)
  {
    this.append(chan, "onKick: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onMode(String chan, IRCUser user, IRCModeParser modeParser)
  {
    this.append(chan, "onMode: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + modeParser, " [", "] ") + '\n');
  }

  @Override
  public void onMode(IRCUser user, String passiveNick, String mode)
  {
    this.append(Log.SLOG, "onMode: " + Util.q("" + user, " [", "] ") + Util.q("" + passiveNick, " [", "] ") + Util.q("" + mode, " [", "] ") + '\n');
  }

  @Override
  public void onNick(IRCUser user, String newNick)
  {
    this.append(Log.SLOG, "onNick: " + Util.q("" + user, " [", "] ") + Util.q("" + newNick, " [", "] ") + '\n');
  }

  @Override
  public void onNotice(String target, IRCUser user, String msg)
  {
    this.append(target, "onNotice: " + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onPart(String chan, IRCUser user, String msg)
  {
    this.append(chan, "onPart: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onPing(String ping)
  {
    this.append(Log.SLOG, "onPing: " + Util.q("" + ping, " [", "] ") + '\n');
  }

  @Override
  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    this.append(
      target.equalsIgnoreCase(this.conn().user().nick()) ?
      user.getNick() :
      target, "onPrivmsg: " + Util.q("" + target, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onQuit(IRCUser user, String msg)
  {
    this.append(Log.SLOG, "onQuit: " + Util.q("" + user, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onReply(int num, String value, String msg)
  {
    this.append(Log.SLOG, "onReply: " + Util.q("" + num, " [", "] ") + Util.q("" + value, " [", "] ") + Util.q("" + msg, " [", "] ") + '\n');
  }

  @Override
  public void onTopic(String chan, IRCUser user, String topic)
  {
    this.append(chan, "onTopic: " + Util.q("" + chan, " [", "] ") + Util.q("" + user, " [", "] ") + Util.q("" + topic, " [", "] ") + '\n');
  }

  @Override
  public void unknown(String prefix, String command, String middle, String trailing)
  {
    this.append(Log.SLOG, "unknown: " + Util.q("" + prefix, " [", "] ") + Util.q("" + command, " [", "] ") + Util.q("" + middle, " [", "] ") + Util.q("" + trailing, " [", "] ") + '\n');
  }
}
