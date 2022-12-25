package myProduct.booking;

import javax.sql.DataSource;

import jakarta.annotation.Resource;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppConfig
{
  public DataSource getDataSource()
  {
    return dataSource;
  }

  @Resource(name = "jdbc/MyDatasource")
  private DataSource dataSource;
}
