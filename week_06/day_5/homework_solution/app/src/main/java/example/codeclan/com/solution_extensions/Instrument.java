package example.codeclan.com.solution_extensions;

import example.codeclan.com.solution_extensions.behaviours.Playable;

/**
 * Created by user on 29/08/2017.
 */

public abstract class Instrument extends StockItem implements Playable {
    private String colour;
    private InstrumentType type;

    public Instrument(String colour, InstrumentType type, int costPrice, int retailPrice) {
        super(costPrice, retailPrice);
        this.colour = colour;
        this.type = type;
    }

    public String getColour() {
        return this.colour;
    }

    public InstrumentType getType() {
        return this.type;
    }
}
