package example.codeclan.com.solution_extensions;

/**
 * Created by user on 29/08/2017.
 */

public class Piano extends Instrument {
    private String manufacturer;

    public Piano(String manufacturer, String colour, int buyPrice, int sellPrice) {
        super(colour, InstrumentType.KEYBOARD, buyPrice, sellPrice);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }

    public String play() {
        return "Plink Plonk";
    }

}
