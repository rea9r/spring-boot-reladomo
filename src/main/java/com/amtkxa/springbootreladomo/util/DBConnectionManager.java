package com.amtkxa.springbootreladomo.util;

import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.connectionmanager.SourcelessConnectionManager;
import com.gs.fw.common.mithra.connectionmanager.XAConnectionManager;
import com.gs.fw.common.mithra.databasetype.DatabaseType;
import com.gs.fw.common.mithra.databasetype.Udb82DatabaseType;

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

    @Override
    public Connection getConnection() {
        return xaConnectionManager.getConnection();
    }

    @Override
    public DatabaseType getDatabaseType() {
        return Udb82DatabaseType.getInstance();
    }

    @Override
    public TimeZone getDatabaseTimeZone() {
        return TimeZone.getTimeZone("Asia/Tokyo");
    }

    // this uniquely identifies the database from which the connection is acquired
    @Override
    public String getDatabaseIdentifier() {
        return xaConnectionManager.getHostName() + ":" + xaConnectionManager.getPort();
    }

    @Override
    public BulkLoader createBulkLoader() throws BulkLoaderException {
        return null;
    }
}
