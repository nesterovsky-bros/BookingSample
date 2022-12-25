package myProduct.booking.models;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Utility functions to work with JDBC.
 */
public final class Functions
{
  public static String getString(ResultSet resultSet, String name)
    throws Exception
  {
    return resultSet.getString(name);
  }

  public static int getInt(ResultSet resultSet, String name)
    throws Exception
  {
    return resultSet.getInt(name);
  }

  public static Integer getNullableInt(
    ResultSet resultSet, 
    String name)
    throws Exception
  {
    var result = resultSet.getInt(name);
    
    return resultSet.wasNull() ? null : (Integer)result;
  }

  public static long getLong(ResultSet resultSet, String name)
    throws Exception
  {
    return resultSet.getLong(name);
  }

  public static Long getNullableLong(
    ResultSet resultSet, 
    String name)
    throws Exception
  {
    var result = resultSet.getLong(name);
    
    return resultSet.wasNull() ? null : (Long)result;
  }

  public static BigDecimal getDecimal(
    ResultSet resultSet, 
    String name)
    throws Exception
  {
    return resultSet.getBigDecimal(name);
  }

  public static double getDouble(ResultSet resultSet, String name)
    throws Exception
  {
    return resultSet.getDouble(name);
  }

  public static Double getNullableDouble(
    ResultSet resultSet, 
    String name)
    throws Exception
  {
    var result = resultSet.getDouble(name);
    
    return resultSet.wasNull() ? null : (Double)result;
  }

  public static boolean getBoolean(ResultSet resultSet, String name)
    throws Exception
  {
    return resultSet.getBoolean(name);
  }

  public static Boolean getNullableBoolean(
    ResultSet resultSet, 
    String name)
    throws Exception
  {
    var result = resultSet.getBoolean(name);
    
    return resultSet.wasNull() ? null : (Boolean)result;
  }

  public static LocalDate getDate(ResultSet resultSet, String name)
    throws Exception
  {
    var result = resultSet.getDate(name);
    
    return result == null ? null : result.toLocalDate();
  }

  public static LocalTime getTime(ResultSet resultSet, String name)
    throws Exception
  {
    var result = resultSet.getTime(name);
    
    return result == null ? null : result.toLocalTime();
  }

  public static LocalDateTime getDateTime(ResultSet resultSet, String name)
    throws Exception
  {
    var result = resultSet.getTimestamp(name);
    
    return result == null ? null : result.toLocalDateTime();
  }

  public static void setString(
    PreparedStatement statement, 
    int index, 
    String value)
    throws Exception
  {
    statement.setString(index, value);
  }

  public static void setInt(
    PreparedStatement statement, 
    int index, 
    int value)
    throws Exception
  {
    statement.setInt(index, value);
  }

  public static void setInt(
    PreparedStatement statement, 
    int index, 
    Integer value)
    throws Exception
  {
    if (value == null)
    {
      statement.setNull(index, Types.INTEGER);
    }
    else
    {
      statement.setInt(index, value);
    }
  }

  public static void setLong(
    PreparedStatement statement, 
    int index, 
    long value)
    throws Exception
  {
    statement.setLong(index, value);
  }

  public static void setLong(
    PreparedStatement statement, 
    int index, 
    Long value)
    throws Exception
  {
    if (value == null)
    {
      statement.setNull(index, Types.BIGINT);
    }
    else
    {
      statement.setLong(index, value);
    }
  }

  public static void setDecimal(
    PreparedStatement statement, 
    int index, 
    BigDecimal value)
    throws Exception
  {
    statement.setBigDecimal(index, value);
  }

  public static void setDouble(
    PreparedStatement statement, 
    int index, 
    double value)
    throws Exception
  {
    statement.setDouble(index, value);
  }

  public static void setDouble(
    PreparedStatement statement, 
    int index, 
    Double value)
    throws Exception
  {
    if (value == null)
    {
      statement.setNull(index, Types.DOUBLE);
    }
    else
    {
      statement.setDouble(index, value);
    }
  }

  public static void setBoolean(
    PreparedStatement statement, 
    int index, 
    boolean value)
    throws Exception
  {
    statement.setBoolean(index, value);
  }

  public static void setBoolean(
    PreparedStatement statement, 
    int index, 
    Boolean value)
    throws Exception
  {
    if (value == null)
    {
      statement.setNull(index, Types.BOOLEAN);
    }
    else
    {
      statement.setBoolean(index, value);
    }
  }

  public static void setDate(
    PreparedStatement statement, 
    int index, 
    LocalDate value)
    throws Exception
  {
    statement.setDate(index, value == null ? null : Date.valueOf(value));
  }

  public static void setTime(
    PreparedStatement statement, 
    int index, 
    LocalTime value)
    throws Exception
  {
    statement.setTime(index, value == null ? null : Time.valueOf(value));
  }

  public static void setDateTime(
    PreparedStatement statement, 
    int index, 
    LocalDateTime value)
    throws Exception
  {
    statement.setTimestamp(
      index, 
      value == null ? null : Timestamp.valueOf(value));
  }
}
