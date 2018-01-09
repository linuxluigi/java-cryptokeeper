package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class Algorithmus extends MainTable {
    public Algorithmus() {
        // set table name
        super.setTable("algorithmus");

        // set entries
        super.addTableEntrie(new TableEntry(
                "algorithmus_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "name",
                EntryType.STRING
        ));
    }
}
