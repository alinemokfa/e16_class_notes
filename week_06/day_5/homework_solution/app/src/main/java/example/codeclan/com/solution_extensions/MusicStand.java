package example.codeclan.com.solution_extensions;

/**
 * Created by user on 29/08/2017.
 */

public class MusicStand extends StockItem {

    private String colour;

    public MusicStand(String colour, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.colour = colour;
    }

    public String getColour() {
        return this.colour;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }
}
