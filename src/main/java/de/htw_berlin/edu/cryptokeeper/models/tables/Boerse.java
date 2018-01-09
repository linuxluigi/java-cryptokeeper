package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class Boerse extends MainTable {
    public Boerse() {
        // set table name
        super.setTable("boerse");

        // set entries
        super.addTableEntrie(new TableEntry(
                "boerse_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "name",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "url",
                EntryType.STRING
        ));
    }
}
