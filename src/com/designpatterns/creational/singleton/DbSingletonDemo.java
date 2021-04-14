package com.designpatterns.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

    public static void main(String[] args) {
        DbSingleton instance = DbSingleton.getInstance();
        System.out.println(instance);

        DbSingleton anotherInstance = DbSingleton.getInstance();
        System.out.println(anotherInstance);

        var timeBefore = System.currentTimeMillis();
        Connection connection = instance.getConnection();
        var timeAfter = System.currentTimeMillis();

        System.out.println("Time took to create the connection in milliseconds: %d".formatted((timeAfter - timeBefore)));

        Statement statement;
        try {
            statement = connection.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
            System.out.println("Table Created");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //This should take very little time to get the connection this time
        timeBefore = System.currentTimeMillis();
        connection = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("Time took to create the connection in milliseconds: %d".formatted((timeAfter - timeBefore)));
    }
}
