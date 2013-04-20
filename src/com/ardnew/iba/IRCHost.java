package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class IRCHost
{
  private Integer _addr;
  private Integer _port;
  private String  _host;
  private String  _pass; 
  
  public IRCHost(String host, Integer port, String pass)
  {
    this._addr = Util.hostToAddr(host);
    this._port = port;
    this._host = host;
    this._pass = pass;
  }
  
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
  
  @Override
  public String toString()
  {
    return Util.join(
      Util.q(this.addr().toString()),
      Util.q(this.port().toString()),      
      Util.q(this.host()),
      Util.q(this.pass())
    );
  }
}
