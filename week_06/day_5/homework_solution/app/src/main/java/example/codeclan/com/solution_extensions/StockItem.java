package example.codeclan.com.solution_extensions;

import example.codeclan.com.solution_extensions.behaviours.Sellable;

/**
 * Created by user on 29/08/2017.
 */

public abstract class StockItem implements Sellable {
    protected int buyPrice;
    protected int sellPrice;

    public StockItem(int buyPrice, int sellPrice) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getBuyPrice() {
        return this.buyPrice;
    }

    public int getSellPrice() {
        return this.sellPrice;
    }
}
