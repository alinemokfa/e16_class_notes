package com.codeclan.example.interfaces_startpoint;

import java.util.ArrayList;

/**
 * Created by user on 24/10/2017.
 */

class Bear {
    private String name;
    private ArrayList<Salmon> belly;

    public Bear(String name) {
        this.name = name;
        this.belly = new ArrayList<Salmon>();
    }

    public String getName() {
        return name;
    }

    public void eat(Salmon salmon){
        belly.add(salmon);
    }

    public int foodCount(){
        return belly.size();
    }

    public void sleep() {
        belly.clear();
    }
}
