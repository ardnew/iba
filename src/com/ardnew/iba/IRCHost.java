package com.ardnew.iba;

import java.util.LinkedList;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   IRCHost.java
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
public class IRCHost
{
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private Integer _addr;
  private Integer _port;
  private String _host;
  private String _pass; 
  private LinkedList<IRCChan> _chan;
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// constructors 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public IRCHost(String host, Integer port, String pass, LinkedList<IRCChan> chan)
  {
    this._addr = Util.hostToAddr(host);
    this._port = port;
    this._host = host;
    this._pass = pass;
    this._chan = chan;
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// accessor/mutator methods for private instance members
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public Integer addr()
  {
    return this._addr;
  }
  
  public Integer port()
  {
    return this._port;
  }
  
  public String host()
  {
    return this._host;
  }
  
  public String pass()
  {
    return this._pass;
  }
  
  public LinkedList<IRCChan> chan()
  {
    return this._chan;
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
      "IRCHost(" + this.hashCode() + ")=" +
      Util.q(
        Util.join(
          this.addr().toString(),
          this.port().toString(),      
          this.host(),
          this.pass(),
          "IRCChanList(" + this.chan().hashCode() + ")=" +
          Util.q(
            Util.join(this.chan().toArray())
          )
        )
      );
  }
}
