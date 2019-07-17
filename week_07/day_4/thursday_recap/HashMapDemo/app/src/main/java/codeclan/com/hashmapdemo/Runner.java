package codeclan.com.hashmapdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 09/11/2017.
 */

public class Runner {
    public static void main(String[] args) {
        School school = new School();

        school.addStudentScore("Darren", 85);

        int score = school.getStudentScore("Darren");

        System.out.println("Score is: " + score);

        //Get all student names (Remember studentScores.keys());
        Set<String> studentNames = school.allStudentNames();

        //Like with hashmap i can say new ArrayList<String>();
        //or new ArrayList<>();
        //but new ArrayList(); is easier
        ArrayList<String> studentsHigherThan70 = new ArrayList();

        for(String name : studentNames) {
            int studentScore = school.getStudentScore(name);

            if(studentScore > 70) {
                studentsHigherThan70.add(name);
            }
        }



//        String firstName = studentsHigherThan70.get(0);
//        System.out.println("First index from array: " + firstName);

        for(String name : studentsHigherThan70) {
            System.out.println(name);
        }
    }
}
