package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;

public class Investor extends MainTable {
    public Investor() {
        // set table name
        super.setTable("investor");

        // set entries
        super.addTableEntrie(new TableEntry(
                "investor_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "firmenname",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "straße",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "stadt",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "postleitzahl",
                EntryType.STRING
        ));
    }
}
