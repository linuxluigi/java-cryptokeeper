package de.htw_berlin.edu.models;

import de.htw_berlin.edu.TableInterface;

import java.sql.*;

public class MainTable implements TableInterface {

    private String table;

    Connection connection;

    public MainTable(String table) {
        this.table = table;
    }

    public void showAllEntries(String tableName) throws SQLException {
        // get table
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *" +
                "FROM " + tableName + ";");

        // get the numbers of columns
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            System.out.format("%-15s", resultSetMetaData.getColumnLabel(i));
        }
        System.out.println(); // next line

        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.format("%-15s", resultSet.getString(i));
            }
            System.out.println(); // next line
        }
    }

    public void inserNewEntry(String tableName) {

    }

    public void deletEntry(int id) {

    }

    public void navigateTrhoughEntries() {

    }

    public void setTable(String table) {
        this.table = table;
    }
}
