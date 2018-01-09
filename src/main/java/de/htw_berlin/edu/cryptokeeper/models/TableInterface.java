package de.htw_berlin.edu.cryptokeeper.models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface TableInterface {

    public void showAllEntries() throws SQLException;

    public void inserNewEntry();

    public void deletEntry();

    public void navigateThoughEntries() throws SQLException, IOException;

    public void setTable(String table);

    public String getTable();

    public void setConnection(Connection connection);

}
