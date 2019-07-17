package example.codeclan.com.solution_extensions;

import java.util.ArrayList;

import example.codeclan.com.solution_extensions.behaviours.Sellable;

/**
 * Created by user on 29/08/2017.
 */

public class Shop {
    private String name;
    private ArrayList<Sellable> stock;

    public Shop(String name) {
        this.name = name;
        this.stock = new ArrayList<Sellable>();
    }

    public String getName() {
        return this.name;
    }

    public int stockCount() {
        return this.stock.size();
    }

    public void addToStock(Sellable item) {
        this.stock.add(item);
    }

    public void removeFromStock(Sellable item) {
        this.stock.remove(item);
    }

    public int totalPotentialProfit() {
        int total = 0;
        for (Sellable item : stock) {
            total += item.calculateMarkup();
        }
        return total;
    }
}

