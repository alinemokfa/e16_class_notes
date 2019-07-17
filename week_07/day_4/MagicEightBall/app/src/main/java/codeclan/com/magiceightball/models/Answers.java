package codeclan.com.magiceightball.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 09/11/2017.
 */

public class Answers {
    private ArrayList<String> answers;

    public Answers() {
        this.answers = new ArrayList();

        this.answers.add("Yes!");
        this.answers.add("That would be an ecumenical matter!");
    }

    public Answers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getNumberOfAnswers() {
        return this.answers.size();
    }

    private int getRandomNumber() {
        Random rand = new Random();
        int numberOfAnswers = this.getNumberOfAnswers();
        return rand.nextInt(numberOfAnswers);
    }

    public String getRandomAnswer() {
        int randomIndex = this.getRandomNumber();
        return answers.get(randomIndex);
    }
}
