package com.ardnew.iba;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.schwering.irc.lib.IRCUtil;

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
public class Util implements IbaConstant
{
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// private static class fields
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  private static SimpleDateFormat _logDateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// static methods available to all objects
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public static String addrToIP(Integer n)
  {
    return null;
  }
  
  public static Integer hostToAddr(String s)
  {
    return 0;
  }
  
  public static boolean validChannel(String s)
  {
    return IRCUtil.isChan(s);
  }
  
  public static String q(String s, String p, String q)
  {
    return p + s + q;
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
  
  public static String lineBreak(Integer n)
  {
    return repeatString(CONSOLE_NEWLINE, n);
  }
  
  public static String joinWithString(String c, Object... o)
  {
    String s = "";
    
    if (o.length > 0)
    {
      s = o[0].toString();
      
      for (int i = 1; i < o.length; ++i) { s += c + o[i]; }
    }
    
    return s;
  }
  
  public static String pjoin(Object... o)
  {
    return joinWithString(TOKEN_DELIMITER + ' ', o);
  }
  
  public static String join(Object... o)
  {
    return joinWithString(TOKEN_DELIMITER, o);
  }
  
  public static String[] splitWhitespace(String s)
  {
    return s.split("\\s+");
  }
  
  public static File createFile(String s, boolean o /* overwrite? */) throws IOException
  {
    File f = new File(s);
    
    if (o && f.exists()) { f.delete(); }
    
    if (!f.exists()) 
    { 
      (new File(f.getParent())).mkdirs(); 
      f.createNewFile(); 
    }
    
    return f;
  }
  
  public static String currentDateLogFormat()
  {
    return _logDateFormat.format(new Date());
  }
}
