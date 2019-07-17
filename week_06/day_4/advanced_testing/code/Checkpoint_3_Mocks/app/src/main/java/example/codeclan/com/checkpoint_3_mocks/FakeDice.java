package example.codeclan.com.checkpoint_3_mocks;

/**
 * Created by user on 29/08/2017.
 */

import java.util.*;

public class FakeDice implements Rollable {

    int numberOfSides;

    public FakeDice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int roll(){
        return 3;
    }
}
