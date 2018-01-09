package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class KryptoCoin extends MainTable {
    public KryptoCoin() {
        // set table name
        super.setTable("krypto_coin");

        // set entries
        super.addTableEntrie(new TableEntry(
                "coin_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "name",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "kuerzel",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "berechnet_mit",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "geprueft_mit",
                EntryType.INT
        ));
    }
}
