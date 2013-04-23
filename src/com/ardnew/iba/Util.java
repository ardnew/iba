package com.ardnew.iba;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   Util.java
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
public class Util
{
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// static class fields for convenience in utility routines
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public static final String TOKEN_LEADING_BRACKET = "[";
  public static final String TOKEN_TRAILING_BRACKET = "]";
  public static final String TOKEN_LEADING_BRACKET_ERROR = "[[**";
  public static final String TOKEN_TRAILING_BRACKET_ERROR = "**]]";
  public static final String ERROR_LINE_CHARACTER = "*";
  public static final String TOKEN_DELIMITER = "; ";
  public static final String NEWLINE = System.getProperty("line.separator");  
  public static final Integer ERROR_LINE_LENGTH = 40;  
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// static methods available to all objects
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public static String addrToIP(Integer addr)
  {
    return null;
  }
  
  public static Integer hostToAddr(String host)
  {
    return 0;
  }
  
  public static String q(String s, String prec, String post)
  {
    return prec + s + post;
  }
  
  public static String q(String s, String c)
  {
    return q(s, c, c);
  }
  
  public static String q(String s)
  {
    return q(s, TOKEN_LEADING_BRACKET, TOKEN_TRAILING_BRACKET);
  }
  
  public static String qe(String s)
  {
    return q(s, TOKEN_LEADING_BRACKET_ERROR, TOKEN_TRAILING_BRACKET_ERROR);
  }
  
  public static String errorLineSpan()
  {
    return repeatString(ERROR_LINE_CHARACTER, ERROR_LINE_LENGTH);
  }
  
  public static String repeatString(String c, Integer n)
  {
    String t = "";
    
    while (n-->0) { t += c; }
    
    return t;
  }
  
  public static String join(Object... o)
  {
    String s = "";
    
    if (o.length > 0)
    {
      s = o[0].toString();
      
      for (int i = 1; i < o.length; ++i) { s += TOKEN_DELIMITER + o[i]; }
    }
    
    return s;
  }
}
