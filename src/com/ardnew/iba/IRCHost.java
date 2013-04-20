package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class IRCHost
{
  private Integer addr;
  private Integer port;
  private String  host;
  private String  pass; 
  
  public IRCHost(String host, Integer port, String pass)
  {
    this.addr = Util.hostToAddr(host);
    this.port = port;
    this.host = host;
    this.pass = pass;
  }
  
  public Integer addr()
  {
    return this.addr;
  }
  
  public Integer port()
  {
    return this.port;
  }
  
  public String host()
  {
    return this.host;
  }
  
  public String pass()
  {
    return this.pass;
  }
}
