package de.htw_berlin.edu;

import java.sql.SQLException;

public interface TableInterface {

    public void showAllEntries(String tableName) throws SQLException;

    public void inserNewEntry(String tableName);

    public void deletEntry(int id);

    public void navigateTrhoughEntries();

    public void setTable(String table);

}
