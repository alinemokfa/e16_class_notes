package example.codeclan.com.solution_extensions;

/**
 * Created by user on 29/08/2017.
 */

public class Guitar extends Instrument  {
    private String model;
    private int numberOfStrings;

    public Guitar(String model, String colour, int numberOfStrings, int costPrice, int retailPrice) {
        super(colour, InstrumentType.STRING, costPrice, retailPrice);
        this.numberOfStrings = numberOfStrings;
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public int getNumberOfStrings() {
        return this.numberOfStrings;
    }

    public String play() {
        return "Kerrang!!!";
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }

}
