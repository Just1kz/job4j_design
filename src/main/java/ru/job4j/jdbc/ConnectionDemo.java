package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/test1";
//        String login = "postgres";
//        String password = "SBRF_%1601";
        CustomSettingsConnect csc = new CustomSettingsConnect();
        try (Connection connection = DriverManager.getConnection(csc.getUrl(), csc.getLogin(), csc.getPassword())) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
