package de.htw_berlin.edu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
    }
}
