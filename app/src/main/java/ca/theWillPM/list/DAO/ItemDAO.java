package ca.theWillPM.list.DAO;

import java.util.ArrayList;
import java.util.List;

import ca.theWillPM.list.model.Item;

public class ItemDAO {

    private final static ArrayList<Item> items = new ArrayList<>();

    public void save(Item item) {
        items.add(item);
    }

    public List<Item> all() {
        return new ArrayList<>(items);
    }
}
