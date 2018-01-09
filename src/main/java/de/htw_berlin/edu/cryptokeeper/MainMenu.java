package de.htw_berlin.edu.cryptokeeper;

import de.htw_berlin.edu.cryptokeeper.models.DatabaseConnection;
import de.htw_berlin.edu.cryptokeeper.models.tables.*;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private ArrayList<MainTable> tableList;

    private MainTable currentTable;

    private DatabaseConnection databaseConnection;

    public MainMenu() {
        // connect to database
        databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.connectToDatabase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // fill tableList
        tableList = new ArrayList<MainTable>();

        // investor
        Investor investor = new Investor();
        investor.setConnection(this.databaseConnection.getConnection());
        tableList.add(investor);

        // KontaktPerson
        KontaktPerson kontaktPerson = new KontaktPerson();
        kontaktPerson.setConnection(this.databaseConnection.getConnection());
        tableList.add(kontaktPerson);

        // algorithmus
        Algorithmus algorithmus = new Algorithmus();
        algorithmus.setConnection(this.databaseConnection.getConnection());
        tableList.add(algorithmus);

        // pruef_verfahren
        PruefVerfahren pruefVerfahren = new PruefVerfahren();
        pruefVerfahren.setConnection(this.databaseConnection.getConnection());
        tableList.add(pruefVerfahren);

        // krypto_coin
        KryptoCoin kryptoCoin = new KryptoCoin();
        kryptoCoin.setConnection(this.databaseConnection.getConnection());
        tableList.add(kryptoCoin);

        // boerse
        Boerse boerse = new Boerse();
        boerse.setConnection(this.databaseConnection.getConnection());
        tableList.add(boerse);

        // wallet
        Wallet wallet = new Wallet();
        wallet.setConnection(this.databaseConnection.getConnection());
        tableList.add(wallet);

        // transaktion
        Transaktion transaktion = new Transaktion();
        transaktion.setConnection(this.databaseConnection.getConnection());
        tableList.add(transaktion);
    }

    public void showMenu() throws SQLException {
        System.out.println("Select a table:");

        // iterate through every table
        for (int i = 0; i < tableList.size(); i++) {
            System.out.format("(%d) %s%n", i, tableList.get(i).getTable());
        }

        // end exit
        System.out.format("(%d) exit%n", tableList.size());

        int userInput = readUserIntInput(0, tableList.size());
        if (tableList.size() == userInput) {
            databaseConnection.disconnectFromDatabase();
            System.exit(0);
        } else {
            currentTable = tableList.get(userInput);
            showTableMenu(userInput);
        }
    }

    private void showTableMenu(int id) throws SQLException {
        System.out.format("Table: %s%n", tableList.get(id).getTable());

        System.out.println("(0) show all entries");
        System.out.println("(1) insert new entry");
        System.out.println("(2) delete entry");
        System.out.println("(3) navigate through all entries");
        System.out.println("(4) show main menu");

        int userInput = readUserIntInput(0, 4);

        switch (userInput) {
            case 0:
                currentTable.showAllEntries();
                showTableMenu(id);
                break;
            case 1:
                currentTable.inserNewEntry();
                showTableMenu(id);
                break;
            case 2:
                currentTable.showAllEntries();
                currentTable.deletEntry();
                showTableMenu(id);
                break;
            case 3:
                try {
                    currentTable.navigateThoughEntries();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
