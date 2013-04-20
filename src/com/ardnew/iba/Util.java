package com.ardnew.iba;

/**
 *
 * @author ardnew
 */
public class Util
{
  public static final Character TOKEN_LEADING_BRACKET = '[';
  public static final Character TOKEN_TRAILING_BRACKET = ']';
  
  public static final String TOKEN_DELIMITER = "; ";
  
  
  
  public static String addrToIP(Integer addr)
  {
    return null;
  }
  
  public static Integer hostToAddr(String host)
  {
    return 0;
  }
  
  
  
  public static String q(String s, Character prec, Character post)
  {
    return prec + s + post;
  }
  
  public static String q(String s, Character c)
  {
    return q(s, c, c);
  }
  
  public static String q(String s)
  {
    return q(s, TOKEN_LEADING_BRACKET, TOKEN_TRAILING_BRACKET);
  }
  
  public static String join(String c, Object... o)
  {
    String s = "";
    
    if (o.length > 0)
    {
      s = o[0].toString();
      
      for (int i = 1; i < o.length; ++i) { s += c + o[i]; }
    }
    
    return s;
  }
  
  public static String join(Object... o)
  { 
    return join(TOKEN_DELIMITER, o);
  }
}
