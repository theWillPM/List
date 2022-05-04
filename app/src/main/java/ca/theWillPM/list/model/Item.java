package ca.theWillPM.list.model;

import androidx.annotation.NonNull;

public class Item {
    private final String name;
    private final String price;
    private final String date;

    public Item(String name, String price, String date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() { return name; }
}
