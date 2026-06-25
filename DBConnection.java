package com.acc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DBConnection Utility Class
 * --------------------------
 * This class helps to connect your Java program with a MySQL database.
 * Whenever you need a database connection, call getDBConnection() method.
 */
public class DBConnection {

    /*
     * getDBConnection Method
     * ---------------------
     * 1. Loads the MySQL JDBC driver.
     * 2. Connects to the database using URL, username, and password.
     * 3. Returns the Connection object so you can use it to run queries.
     */
    public static Connection getDBConnection() {

        Connection con = null; // Variable to hold the database connection

        try {
            /*
             * Load MySQL JDBC Driver
             * This tells Java which database driver to use.
             */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /*
             * Connect to the database
             * Provide URL, username, and password of your database.
             */
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exam?useSSL=false", "root", "root"
            );
            

        } catch (ClassNotFoundException e) {
            /*
             * This happens if JDBC driver is not found in your project.
             */
            e.printStackTrace();

        } catch (SQLException e) {
            /*
             * This happens if connection to database fails.
             * For example: wrong URL, username, password, or database not running.
             */
            e.printStackTrace();
        }

        // Return the connection object to be used in other classes
        return con;
    }
}
