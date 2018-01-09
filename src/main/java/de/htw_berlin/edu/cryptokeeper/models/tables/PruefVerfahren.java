package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class PruefVerfahren extends MainTable {
    public PruefVerfahren() {
        // set table name
        super.setTable("pruef_verfahren");

        // set entries
        super.addTableEntrie(new TableEntry(
                "pruef_verfahren_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "name",
                EntryType.STRING
        ));
    }
}
