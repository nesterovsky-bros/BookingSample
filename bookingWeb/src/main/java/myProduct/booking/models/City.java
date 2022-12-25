package myProduct.booking.models;

import java.time.LocalDateTime;

public class City
{
  public int getCityID()
  {
    return cityID;
  }

  public void setCityID(int cityID)
  {
    this.cityID = cityID;
  }
  
  public String getCityName()
  {
    return cityName;
  }
  
  public void setCityName(String cityName)
  {
    this.cityName = cityName;
  }
  
  public int getStateProvinceID()
  {
    return stateProvinceID;
  }
  
  public void setStateProvinceID(int stateProvinceID)
  {
    this.stateProvinceID = stateProvinceID;
  }
  
  public Long getLatestRecordedPopulation()
  {
    return latestRecordedPopulation;
  }
  
  public void setLatestRecordedPopulation(Long latestRecordedPopulation)
  {
    this.latestRecordedPopulation = latestRecordedPopulation;
  }
  
  public int getLastEditedBy()
  {
    return lastEditedBy;
  }
  
  public void setLastEditedBy(int lastEditedBy)
  {
    this.lastEditedBy = lastEditedBy;
  }
  
  public LocalDateTime getValidFrom()
  {
    return validFrom;
  }
  
  public void setValidFrom(LocalDateTime validFrom)
  {
    this.validFrom = validFrom;
  }
  
  public LocalDateTime getValidTo()
  {
    return validTo;
  }
  
  public void setValidTo(LocalDateTime validTo)
  {
    this.validTo = validTo;
  }

  private int cityID;
  private String cityName;
  private int stateProvinceID;
  //Geography location;
  private Long latestRecordedPopulation;
  private int lastEditedBy;
  private LocalDateTime validFrom;
  private LocalDateTime validTo;
}