package com.amtkxa.springbootreladomo.infrastructure.database;

import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.connectionmanager.SourcelessConnectionManager;
import com.gs.fw.common.mithra.connectionmanager.XAConnectionManager;
import com.gs.fw.common.mithra.databasetype.DatabaseType;

import java.sql.Connection;
import java.util.TimeZone;

public class DBConnectionManager implements SourcelessConnectionManager {
  protected static DBConnectionManager instance;
  private XAConnectionManager xaConnectionManager;

  protected DBConnectionManager() {
    this.createConnectionManager();
  }

  public static synchronized DBConnectionManager getInstance() {
    if (instance == null) {
      instance = new DBConnectionManager();
    }
    return instance;
  }

  /**
   * Set the properties necessary to create a connection to database.
   *
   * @apiNote XAConnectionManager is a utility class for a transactional connection manager.
   */
  private void createConnectionManager() {
    this.xaConnectionManager = new XAConnectionManager();
    xaConnectionManager.setDriverClassName("org.postgresql.Driver");
    xaConnectionManager.setJdbcConnectionString("jdbc:postgresql://localhost:5432/sampledb");
    xaConnectionManager.setJdbcUser("testuser");
    xaConnectionManager.setJdbcPassword("testuser");
    xaConnectionManager.setPoolName("My Connection Pool");
    xaConnectionManager.setInitialSize(1);
    xaConnectionManager.setPoolSize(10);
    xaConnectionManager.initialisePool();
  }

  /**
   * Returns a connection from the pool.
   *
   * @return connection
   * @apiNote If all connections are in use, this method will block, unless maxWait has been set.
   */
  @Override
  public Connection getConnection() {
    return xaConnectionManager.getConnection();
  }

  /**
   * Returns the database transactionType.
   *
   * @apiNote XAConnectionManager is a utility class for a transactional connection manager.
   */
  @Override
  public DatabaseType getDatabaseType() {
    return xaConnectionManager.getDatabaseType();
  }

  /**
   * Returns the timezone the database server is located in.
   *
   * @return timezone
   */
  @Override
  public TimeZone getDatabaseTimeZone() {
    return TimeZone.getTimeZone("Asia/Tokyo");
  }

  /**
   * Returns the database host name and port number.
   *
   * @apiNote XAConnectionManager is a utility class for a transactional connection manager.
   */
  @Override
  public String getDatabaseIdentifier() {
    return xaConnectionManager.getHostName() + ":" + xaConnectionManager.getPort();
  }

  @Override
  public BulkLoader createBulkLoader() throws BulkLoaderException {
    return null;
  }
}
