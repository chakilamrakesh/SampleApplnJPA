package com.ojas.servlet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPoolManager {

	Vector<Connection> connectionPool = new Vector<Connection>();

	public ConnectionPoolManager() {
		initialize();
	}

	private void initialize() {
		initializeConnectionPool();
	}

	public void initializeConnectionPool() {
		while (!checkIfConnectionPoolIsFull()) {
			System.out.println("Connection Pool size is NOT reached. Proceeding with adding new connections");
			connectionPool.addElement(createNewConnectionForPool());
		}
		System.out.println("Connection Pool size is full.");
	}

	private synchronized boolean checkIfConnectionPoolIsFull() {
		final int MAX_POOL_SIZE = AppConfig.getInstance().DB_MAX_CONNECTIONS;
		if (connectionPool.size() < MAX_POOL_SIZE) {
			System.out.println("checking pool size here.." + connectionPool.size());
			return false;
		}

		return true;
	}

	private Connection createNewConnectionForPool() {
		AppConfig config = AppConfig.getInstance();
		Connection connection = null;

		try {
			Class.forName(config.DRIVER_CLASS);
			connection = DriverManager.getConnection(config.DB_URL, config.DB_USERNAME, config.DB_PASSWORD);
			System.out.println("Connection is created: " + connection);

			return connection;
		} catch (SQLException sqle) {
			System.err.println("SQLException: " + sqle);
			return null;

		} catch (ClassNotFoundException cnfe) {
			System.err.println("ClassNotFoundException: " + cnfe);
			return null;
		}

		// return connection;
	}

	public synchronized Connection getConnectionFromPool() {
		Connection connection = null;
		// Check if there is a connection available. There are times when
		// all the connections in the pool may be used up
		if (connectionPool.size() > 0) {
			connection = (Connection) connectionPool.firstElement();
			connectionPool.removeElementAt(0);
		}
		// Giving away the connection from the connection pool
		return connection;
	}

	public synchronized void returnConnectionToPool(Connection connection) {
		// Adding the connection from the client back to the connection pool
		connectionPool.addElement(connection);
	}

}
