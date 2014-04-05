package com.ardnew.iba.plugin;

import java.util.LinkedList;

import com.ardnew.iba.Iba;
import com.ardnew.iba.IRCChan;
import com.ardnew.iba.IRCEventHandler;
import com.ardnew.iba.IRCThread;
import com.ardnew.iba.Util;

import org.schwering.irc.lib.IRCUser;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   Control.java
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
public final class Control extends IRCEventHandler
{
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// local type definitions
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public enum ConnectionState { csNone, csActive };
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private static class fields
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  private static final String NAME = "CONTROL";

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private ConnectionState _stat;  

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public Control(IRCThread conn, boolean actv)
  {
    super(conn, Control.NAME, actv);
    
    this.stat(ConnectionState.csNone);
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public ConnectionState stat()
  {
    return this._stat;
  }
  
  public void stat(ConnectionState stat)
  {
    this._stat = stat;
  }  
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// public instance methods
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public boolean isConnected()
  {
    return this.conn().isConnected() && this.stat() == ConnectionState.csActive;
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// overridden methods implementing interfaces
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  @Override
  public void onDisconnected()
  {
    if (!this.isConnected())
    {
      this.printErrorUserMessage(Util.qe("RECEIVED DISCONNECT") + Util.lineBreak(2) + this.conn().toString() + Util.lineBreak(1));
    }
  }

  @Override
  public void onRegistered()
  {
    if (this.actv())
    {
      this.stat(ConnectionState.csActive);
      this.printOutputUserMessage("identity verified, connection established.");
    }
  }  

  @Override
  public void onReply(int num, String value, String msg)
  {
    if (this.actv())
    {
      switch (num)
      {
        case RPL_ENDOFMOTD:
          
          if (this.stat() == ConnectionState.csActive)
          {
            // join all of our channels
            for (IRCChan c : this.conn().host().chan())
            {
              this.conn().doJoin(c.name(), c.pass());
            }
          }
          break;
          
        default:
          
          break;
      }
    }
  } 
  
  @Override
  public void onPart(String chan, IRCUser user, String msg)
  {
    if (this.actv())
    {
      if (user.getNick().equalsIgnoreCase(this.conn().user().nick()))
      {
        LinkedList<IRCChan> l = this.conn().host().chan();

        for (IRCChan c : l  )
        {
          if (chan.equalsIgnoreCase(c.name())) 
          { 
            l.remove(c); 
          }
          System.out.println("!!!-------[" + chan + "] == [" + c.name() + "] " + String.valueOf(chan.equalsIgnoreCase(c.name())));
        }
      }
    }
  }  
  
  @Override
  public void onPrivmsg(String target, IRCUser user, String msg)
  {
    if (this.actv())
    {
      String[] s = Util.splitWhitespace(msg);
      
      if (s[0].equalsIgnoreCase(this.conn().user().nick()))
      {
      
        switch (s.length)
        {
          case 3:

            if (s[1].equalsIgnoreCase("join"))
            {
              if (Util.validChannel(s[2]))
              {
                this.conn().doJoin(s[2]);
              }
            }
            else if (s[1].equalsIgnoreCase("threads"))
            {
              if (s[2].equalsIgnoreCase("show"))
              {
                for (IRCThread t : Iba.pool())
                {
                  this.conn().doPrivmsg(target, t.toString());
                }
              }
              else
              if (s[2].equalsIgnoreCase("clean"))
              {
                IRCThread t = null;
                for (int i = Iba.pool().size() - 1; i >= 0; --i)
                {
                  t = Iba.pool().get(i);

                  if (t.isAlive() && !t.isConnected() || !t.isAlive()) 
                  { 
                    Iba.pool().remove(i);
                  }
                }
              }
            }

          case 2:

            if (s[1].equalsIgnoreCase("quit"))
            {
              this.conn().doQuit("received quit");
            }
            else
            if (s[1].equalsIgnoreCase("part"))
            {
              this.conn().doPart(target, "received part");
            }

          case 1:
          case 0:
        }
      }
    }
  }  
}
