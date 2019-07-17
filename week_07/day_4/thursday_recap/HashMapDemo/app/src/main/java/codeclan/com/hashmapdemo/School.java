package codeclan.com.hashmapdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by user on 09/11/2017.
 */

public class School {
    private HashMap<String, Integer> studentScores;

    public School() {
        //we could say
        // studentScores = new HashMap<String, Integer>();
        // or
        // studentScores = new HashMap<>();
        this.studentScores = new HashMap();
    }

    // I could overload the constructor if i wanted to
    // provide some initial student scores
    //    public School(HashMap<String, Integer> studentScores) {
    //      this.studentScores = studentScores;
    //    }

    // i am going to add to the hashmap,
    // i don't need to return anything
    public void addStudentScore(String name, int score) {
        //In ruby it is too easy
        //We just say
        //studentScores[name] = score
        this.studentScores.put(name, score);
    }

    public Set<String> allStudentNames() {
        // return studentScores.keys()
        Set<String> studentNames = this.studentScores.keySet();
        // ["Darren"]
        return studentNames;
    }

    public int getStudentScore(String name) {
        //return studentScores[name]
        return this.studentScores.get(name);
    }

}
