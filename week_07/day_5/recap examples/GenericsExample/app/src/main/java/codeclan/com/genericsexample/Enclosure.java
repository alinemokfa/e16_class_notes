package codeclan.com.genericsexample;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2017.
 */

//public class HashMap<K,V>
//{
//}

public class Enclosure<T extends Animal>{
    // Because we say that T extends Animal,
    // Then whoever creates a Enclosure must make it of
    // type Animal or SubTypes

    // So Enclosure<Lion> is allowed
    // but Enclosure<String> is not since String does
    // not extend animal

    // Plus, it also means since we know T to be subtype
    // of animal. Then we know that it will have animal
    // properties and methods

    // so for example:

    //  public int getAnimalAtIndex0CashValue() {
    //      return this.arrayList.get(0).getCashValue();
    //  }

    // Will work since arraylist of T where T must extend Animal

    private ArrayList<T> arrayList;

    public Enclosure() {
        this.arrayList = new ArrayList();
    }

    public void add(T item) {
        this.arrayList.add(item);
    }


}
