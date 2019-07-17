package example.codeclan.com.checkpoint_1_abstract_class;

/**
 * Created by user on 28/08/2017.
 */

public class GrizzlyBear extends Bear{
    public String gatherFood() {
        return super.gatherFood() + " fishing in the river";
    }

    public String hibernate() {
        return "Finding a nice cave to sleep";
    }
}
