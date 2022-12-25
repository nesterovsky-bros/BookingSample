package myProduct.booking.models;

import java.util.ArrayList;

import javax.sql.DataSource;

import jakarta.inject.Inject;

import myProduct.booking.AppConfig;

import static myProduct.booking.models.Functions.*;

public class WideWorldImporters
{
  @Inject
  public WideWorldImporters(AppConfig appConfig)
  {
    this.dataSource = appConfig.getDataSource();
  }
  
  public City getCity(int cityId)
    throws Exception
  {
    try(var connection = dataSource.getConnection())
    {
      var statement = connection.prepareStatement("""
        select
          CityID, 
          CityName,
          StateProvinceID,
          -- Location,
          LatestRecordedPopulation,
          LastEditedBy,
          ValidFrom,
          ValidTo      
        from 
          Application.Cities
        where
          CityID = ?
        """);
      
      setInt(statement, 1, cityId);
      
      try(var resultSet = statement.executeQuery())
      {
        if (resultSet.next())
        {
          var city = new City();
          
          city.setCityID(getInt(resultSet, "cityId"));
          city.setCityName(getString(resultSet, "cityName"));
          city.setStateProvinceID(getInt(resultSet, "stateProvinceID"));
          city.setLatestRecordedPopulation(
            getNullableLong(resultSet, "latestRecordedPopulation"));
          city.setLastEditedBy(getInt(resultSet, "lastEditedBy"));
          city.setValidFrom(getDateTime(resultSet, "validFrom"));
          city.setValidTo(getDateTime(resultSet, "validTo"));
          
          return city;
        }
      }
    }
    
    return null;
  }
  
  public ArrayList<City> getSearchCities(String search, int offset, int fetch)
    throws Exception
  {
    var result = new ArrayList<City>();
    
    try(var connection = dataSource.getConnection())
    {
      var statement = connection.prepareStatement("""
        select
          CityID, 
          CityName,
          StateProvinceID,
          -- Location,
          LatestRecordedPopulation,
          LastEditedBy,
          ValidFrom,
          ValidTo      
        from 
          Application.Cities
        where
          CityName like ?
        order by
          CityName
        offset ? rows
        fetch first ? rows only
        """);
      
      setString(statement, 1, search);
      setInt(statement, 2, offset);
      setInt(statement, 3, fetch);
      
      try(var resultSet = statement.executeQuery())
      {
        while(resultSet.next())
        {
          var city = new City();
          
          city.setCityID(getInt(resultSet, "cityId"));
          city.setCityName(getString(resultSet, "cityName"));
          city.setStateProvinceID(getInt(resultSet, "stateProvinceID"));
          city.setLatestRecordedPopulation(
            getNullableLong(resultSet, "latestRecordedPopulation"));
          city.setLastEditedBy(getInt(resultSet, "lastEditedBy"));
          city.setValidFrom(getDateTime(resultSet, "validFrom"));
          city.setValidTo(getDateTime(resultSet, "validTo"));

          result.add(city);
        }
      }
    }
    
    return result;
  }
  
  public boolean updateCityPopulation(int cityId, Long population)
    throws Exception
  {
    try(var connection = dataSource.getConnection())
    {
      var statement = connection.prepareStatement("""
        update Application.Cities
        set
          LatestRecordedPopulation = ?
        where
          CityId = ?
        """);
      
      setLong(statement, 1, population);
      setInt(statement, 2, cityId);
      
      return statement.executeUpdate() > 0;
    }
  }

  private DataSource dataSource;
}
