package de.htw_berlin.edu.cryptokeeper.models;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MainTable implements TableInterface {

    private String table;

    private Connection connection;

    private ArrayList<TableEntry> tableEntries = new ArrayList<TableEntry>();

    private int primaryEntry = 0;

    public void showAllEntries() throws SQLException {
        // get table
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *" +
                "FROM " + this.table + ";");

        // get the numbers of columns
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            System.out.format("%-28s", resultSetMetaData.getColumnLabel(i));
        }
        System.out.println(); // next line

        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.format("%-28s", resultSet.getString(i));
            }
            System.out.println(); // next line
        }
    }

    public void inserNewEntry() {
        String values = "";
        String labels = "";

        int counter = 1;

        for (TableEntry tableEntry : tableEntries) {
            String userInput = readUserInput(tableEntry);
            if (userInput != null) {
                values += userInput;
                labels += tableEntry.getName();

                if (counter < tableEntries.size()) {
                    values += ", ";
                    labels += ", ";
                }

            }

            counter++;
        }

        Statement statement = null;
        String sqlCommand = "INSERT INTO " + this.table + " (" + labels + ")" +
                "VALUES (" + values + ");";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletEntry() {

        String userInput = readUserInput(this.tableEntries.get(this.primaryEntry));

        Statement statement = null;
        String primaryKey = this.tableEntries.get(this.primaryEntry).getName();
        String sqlCommand = "DELETE FROM " + this.table +
                " WHERE " + primaryKey + "=" + userInput + ";";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void navigateThoughEntries() throws SQLException, IOException {
        // get table
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *" +
                "FROM " + this.table + ";");

        // get the numbers of columns
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            System.out.format("%-28s", resultSetMetaData.getColumnLabel(i));
        }
        System.out.println(); // next line

        List<String> rowList = new ArrayList<String>();

        while (resultSet.next()) {

            String row = "";
            for (int i = 1; i <= columnsNumber; i++) {
                row += String.format("%-28s", resultSet.getString(i));
            }
            rowList.add(row);
        }

        ListIterator<String> rowListIteration = rowList.listIterator();

        if (rowListIteration.hasNext()) {
            System.out.println(rowListIteration.next());
        }

        int b;
        Control:
        while (true) {
            b = System.in.read();
            switch (b) {
                case 'n': // next
                    if (rowListIteration.hasNext()) {
                        System.out.println(rowListIteration.next());
                    } else {
                        System.out.println("There is no next entry");
                    }
                    break;
                case 'e': // exit
                    System.out.println("exit");
                    break Control;
                case 'p': // previous
                    if (rowListIteration.hasPrevious()) {
                        System.out.println(rowListIteration.previous());
                    } else {
                        System.out.println("There is no previous entry");
                    }
                    break;
            }
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void addTableEntrie(TableEntry tableEntry) {
        this.tableEntries.add(tableEntry);
    }

    private String readUserInput(TableEntry tableEntry) {
        Scanner scanner = new Scanner(System.in);

        String userInput = null;

        switch (tableEntry.getEntryType()) {
            case INT:
                System.out.println("Please enter a int number for " + tableEntry.getName());
                userInput = String.valueOf(scanner.nextInt());
                break;
            case FLOAT:
                System.out.println("Please enter a float number for " + tableEntry.getName());
                userInput = String.valueOf(scanner.nextFloat());
                break;
            case STRING:
                System.out.println("Please enter a string for " + tableEntry.getName());
                userInput = "'" + scanner.nextLine() + "'";
                break;
            case SELECTABLE_VALUE:
                System.out.println("Please enter a string from the list below for " + tableEntry.getName());
                for (String value : tableEntry.getSelectableValues()) {
                    System.out.println(value);
                }
                userInput = "'" + scanner.nextLine() + "'";
                break;
        }

        return userInput;
    }

    public int getPrimaryEntry() {
        return primaryEntry;
    }

    public void setPrimaryEntry(int primaryEntry) {
        this.primaryEntry = primaryEntry;
    }
}
