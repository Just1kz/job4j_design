package ru.job4j.jdbc;

import java.sql.*;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final CustomSettingsConnect csc;

    public TableEditor(CustomSettingsConnect csc) throws Exception {
        this.csc = csc;
        initConnection();
    }

    private Connection initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(csc.getUrl(), csc.getLogin(), csc.getPassword());
        return this.connection;
    }

    public void createTable(String tableName) throws Exception {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s();",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public void dropTable(String tableName) throws Exception {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "drop table %s;",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public void addColumn(String tableName, String columnName, String type)
            throws Exception {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s add column %s %s;",
                        tableName,
                        columnName,
                        type
                );
                statement.execute(sql);
            }
        }
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s drop column %s;",
                        tableName,
                        columnName
                );
                statement.execute(sql);
            }
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName)
            throws Exception {
        try (Connection connection = initConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "alter table %s rename column %s to %s;",
                        tableName,
                        columnName,
                        newColumnName
                );
                statement.execute(sql);
            }
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null,
                tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
