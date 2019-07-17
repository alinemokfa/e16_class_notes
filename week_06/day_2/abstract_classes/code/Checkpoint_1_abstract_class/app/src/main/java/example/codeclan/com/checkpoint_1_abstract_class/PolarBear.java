package example.codeclan.com.checkpoint_1_abstract_class;

/**
 * Created by user on 28/08/2017.
 */

public class PolarBear extends Bear{
    public String gatherFood() {
        return super.gatherFood() + " breaking the ice";
    }

    public String hibernate() {
        return "Finding a nice Igloo to sleep";
    }
}
