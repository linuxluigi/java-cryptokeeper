package de.htw_berlin.edu.cryptokeeper.models;

import java.util.ArrayList;

public class TableEntry {
    private String name;
    private EntryType entryType;

    private ArrayList<String> selectableValues = new ArrayList<String>();

    public TableEntry(String name, EntryType entryType) {
        this.name = name;
        this.entryType = entryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public void addselectableValue(String value) {
        selectableValues.add(value);
    }

    public ArrayList<String> getSelectableValues() {
        return selectableValues;
    }
}
