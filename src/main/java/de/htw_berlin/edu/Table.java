package de.htw_berlin.edu;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {

    private String table;

    Connection connection;

    public Table() {
        try {
            connectToDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void connectToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/fubu", "fubu", "");
    }

    public void disconnectFromDatabase() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllTableNames() throws SQLException {
        ArrayList<String> tableList = new ArrayList<String>();

        // get all table names from db
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT table_name\n" +
                "FROM information_schema.tables\n" +
                "WHERE table_schema='public'\n" +
                "      AND table_type='BASE TABLE';");

        while (resultSet.next()) {
            tableList.add(resultSet.getString("table_name"));
        }

        return tableList;
    }

    public void showAllEntries(String tableName) throws SQLException {
        // get table
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *\n" +
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

    public void inserNewEntry(String tableName) throws SQLException {
        // show user alle entries
        showAllEntries(tableName);

        // get columne label
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *\n" +
                "FROM " + tableName + " LIMIT 0;");

        // get the numbers of columns
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        String statementLabel = "";
        String statementValues = "";

        for (int i = 1; i <= columnsNumber; i++) {
            System.out.printf("Enter: %s%n", resultSetMetaData.getColumnLabel(i));

            statementLabel += resultSetMetaData.getColumnLabel(i);

            String userInput = readUserInput();
            if (isNumeric(userInput)) {
                statementValues += userInput;
            } else {
                statementValues += "'" + userInput + "'";
            }

            if (i != columnsNumber) {
                statementLabel += ", ";
                statementValues += ", ";
            }
        }

        String sqlCommand = "INSERT INTO " + table + " (" + statementLabel + ") " +
                "VALUES (" + statementValues + ");";

        statement = connection.createStatement();
        try {
            statement.executeQuery(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // show user alle entries
        showAllEntries(tableName);
    }

    public void deletEntry(int id) {

    }

    public void navigateTrhoughEntries() {

    }

    public static boolean isNumeric(String str) {
        if (str.substring(0, 1).equals("0")) {
            return false;
        }

        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
