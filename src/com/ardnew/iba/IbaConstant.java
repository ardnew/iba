package com.ardnew.iba;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// file:
//   IbaConstant.java
//
// description:
//   TODO
//
// author:
//   ardnew, andrew@ardnew.com
//
// date:
//   April 24, 2013
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public interface IbaConstant
{
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// global static fields
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  public static final String  CONSOLE_NEWLINE = System.getProperty("line.separator");  
  public static final String  PATH_DELIMITER = System.getProperty("file.separator");
  
  public static final String  TOKEN_LEADING_BRACKET = "[";
  public static final String  TOKEN_TRAILING_BRACKET = "]";
  
  public static final String  TOKEN_LEADING_BRACKET_ERROR = "[[**";
  public static final String  TOKEN_TRAILING_BRACKET_ERROR = "**]]";
  
  public static final String  TOKEN_DELIMITER = ";";
  
  public static final String  ERROR_LINE_CHARACTER = "*";
  public static final Integer ERROR_LINE_LENGTH = 20; 
  
  public static final String  DEFAULT_LOG_PATH = System.getProperty("user.dir");
  public static final String  DEFAULT_LOG_DIRNAME = "log";
  public static final String  DEFAULT_LOG_FILE_EXTENSION = ".log";
  
  public static final String  DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
}
