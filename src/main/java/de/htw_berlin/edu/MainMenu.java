package de.htw_berlin.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private ArrayList<String> tableList;

    private Table table = new Table();

    public MainMenu() {
        // fill tableList
        try {
            tableList = table.getAllTableNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showMenu() throws SQLException {
        System.out.println("Select a table:");

        // iterate through every table
        for (int i = 0; i < tableList.size(); i++) {
            System.out.format("(%d) %s%n", i, tableList.get(i));
        }

        // end exit
        System.out.format("(%d) exit%n", tableList.size());

        int userInput = readUserIntInput(0, tableList.size());
        if (tableList.size() == userInput) {
            table.disconnectFromDatabase();
            System.exit(0);
        } else {
            table.setTable(tableList.get(userInput));
            showTableMenu(userInput);
        }
    }

    private void showTableMenu(int id) throws SQLException {
        System.out.format("Table: %s%n", tableList.get(id));

        System.out.println("(0) show all entries");
        System.out.println("(1) insert new entry");
        System.out.println("(2) delete entry");
        System.out.println("(3) navigate through all entries");
        System.out.println("(4) show main menu");

        int userInput = readUserIntInput(0, 4);

        switch (userInput) {
            case 0:
                table.showAllEntries(tableList.get(id));
                showTableMenu(id);
                break;
            case 1:
                table.inserNewEntry(tableList.get(id));
                showTableMenu(id);
                break;
            case 2:
                System.out.println("delete");
                showTableMenu(id);
                break;
            case 3:
                System.out.println("navigate");
                showTableMenu(id);
                break;
            case 4:
                showMenu();
                break;
        }
    }

    private int readUserIntInput(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        if (i < min | i > max) {
            return readUserIntInput(min, max);
        } else {
            return i;
        }
    }

}
