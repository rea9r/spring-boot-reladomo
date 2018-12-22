package com.amtkxa.springbootreladomo.infrastructure.database;

import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.connectionmanager.SourcelessConnectionManager;
import com.gs.fw.common.mithra.connectionmanager.XAConnectionManager;
import com.gs.fw.common.mithra.databasetype.DatabaseType;

import java.sql.Connection;
import java.util.Properties;
import java.util.TimeZone;

public class DBConnectionManager implements SourcelessConnectionManager {
  protected static DBConnectionManager instance;
  private XAConnectionManager xaConnectionManager;

  public static final String JDBC_DRIVER_CLASS_NAME_KEY = "jdbcDriverClassName";
  public static final String JDBC_SUB_PROTOCOL = "jdbcSubProtocol";
  public static final String HOST_KEY = "host";
  public static final String PORT_KEY = "port";
  public static final String DATABASE_KEY = "database";
  public static final String USERNAME_KEY = "username";
  public static final String PASSWORD_KEY = "password";
  public static final String TIMEZONE_KEY = "timeZone";

  private String jdbcDriverClassName;
  private String jdbcSubProtocol;
  private String host;
  private String port;
  private String database;
  private String username;
  private String password;
  private TimeZone timeZone;

  public static synchronized DBConnectionManager getInstance(Properties properties) {
    if (instance == null) {
      instance = new DBConnectionManager();
    }
    instance.init(properties);
    return instance;
  }

  private void init(Properties properties) {
    this.jdbcDriverClassName = properties.getProperty(JDBC_DRIVER_CLASS_NAME_KEY);
    this.jdbcSubProtocol = properties.getProperty(JDBC_SUB_PROTOCOL);
    this.host = properties.getProperty(HOST_KEY);
    this.port = properties.getProperty(PORT_KEY);
    this.database = properties.getProperty(DATABASE_KEY);
    this.username = properties.getProperty(USERNAME_KEY);
    this.password = properties.getProperty(PASSWORD_KEY);
    this.timeZone = TimeZone.getTimeZone(properties.getProperty(TIMEZONE_KEY));
    this.createConnectionManager();
  }

  /**
   * Set the properties necessary to create a connection to database.
   *
   * @apiNote XAConnectionManager is a utility class for a transactional connection manager.
   */
  private void createConnectionManager() {
    this.xaConnectionManager = new XAConnectionManager();
    xaConnectionManager.setDriverClassName(jdbcDriverClassName);
    xaConnectionManager.setJdbcConnectionString("jdbc:" + jdbcSubProtocol+ "://" + host + ":" + port + "/" + database);
    xaConnectionManager.setJdbcUser(username);
    xaConnectionManager.setJdbcPassword(password);
    xaConnectionManager.setPoolName(host + ":" + database + ": connection pool");
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
    return timeZone;
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
