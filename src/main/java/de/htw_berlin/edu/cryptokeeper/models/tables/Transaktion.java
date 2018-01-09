package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class Transaktion extends MainTable {
    public Transaktion() {
        // set table name
        super.setTable("transaktion");

        // set entries
        super.addTableEntrie(new TableEntry(
                "transaction_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "anzahl",
                EntryType.FLOAT
        ));

        super.addTableEntrie(new TableEntry(
                "zeitstempel",
                EntryType.AUTOFILL
        ));

        super.addTableEntrie(new TableEntry(
                "wechselkurs",
                EntryType.FLOAT
        ));

        TableEntry transaktionsArt = new TableEntry(
                "transaktions_art",
                EntryType.SELECTABLE_VALUE
        );
        transaktionsArt.addselectableValue("buy");
        transaktionsArt.addselectableValue("sell");
        super.addTableEntrie(transaktionsArt);

        super.addTableEntrie(new TableEntry(
                "gehandelt",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "gesichert_in",
                EntryType.INT
        ));

    }
}
