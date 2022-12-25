package myProduct.booking.controllers;

import java.util.ArrayList;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import myProduct.booking.models.City;
import myProduct.booking.models.WideWorldImporters;

@Path("importers")
public class ImportersController
{
  @Inject
  private WideWorldImporters importers;
  
  @Path("welcome")
  @GET
  public String welcome(@QueryParam("name") String name) 
  {
    return name == null ? "Hello!" : "Hello, " + name + "!"; 
  } 

  @Path("city")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public City getCity(@QueryParam("id") int id)
    throws Exception
  {
    return importers.getCity(id);
  } 

  @Path("searchCity")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<City> getSearchCity(
    @QueryParam("search") String search,
    @QueryParam("offset") int offset,
    @QueryParam("fetch") int fetch)
    throws Exception
  {
    return importers.getSearchCities(search, offset, fetch <= 0 ? 100 : fetch);
  } 
}
