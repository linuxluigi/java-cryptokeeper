package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class Wallet extends MainTable {
    public Wallet() {
        // set table name
        super.setTable("wallet");

        // set entries
        super.addTableEntrie(new TableEntry(
                "wallet_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "addresse",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "gesicherter",
                EntryType.INT
        ));
    }
}
