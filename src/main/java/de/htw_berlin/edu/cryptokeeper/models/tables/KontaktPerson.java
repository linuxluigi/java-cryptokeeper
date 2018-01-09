package de.htw_berlin.edu.cryptokeeper.models.tables;

import de.htw_berlin.edu.cryptokeeper.models.EntryType;
import de.htw_berlin.edu.cryptokeeper.models.MainTable;
import de.htw_berlin.edu.cryptokeeper.models.TableEntry;

public class KontaktPerson extends MainTable {
    public KontaktPerson() {
        // set table name
        super.setTable("kontakt_person");

        // set entries
        super.addTableEntrie(new TableEntry(
                "kontakt_id",
                EntryType.INT
        ));

        super.addTableEntrie(new TableEntry(
                "vornamen",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "nachnamen",
                EntryType.STRING
        ));

        TableEntry position = new TableEntry(
                "position",
                EntryType.SELECTABLE_VALUE
        );
        position.addselectableValue("Inhaber");
        position.addselectableValue("Geschäftsführer");
        position.addselectableValue("Assistent");
        super.addTableEntrie(position);

        super.addTableEntrie(new TableEntry(
                "email",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "telefonnummer",
                EntryType.STRING
        ));

        super.addTableEntrie(new TableEntry(
                "ansprechpartner_von",
                EntryType.INT
        ));
    }
}
