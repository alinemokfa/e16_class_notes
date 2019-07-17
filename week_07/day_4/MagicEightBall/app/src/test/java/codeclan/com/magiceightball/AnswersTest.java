package codeclan.com.magiceightball;

import org.junit.Test;

import java.util.ArrayList;

import codeclan.com.magiceightball.models.Answers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 09/11/2017.
 */

public class AnswersTest {
    @Test
    public void testAnswersStartWithTwo() {
        Answers answers = new Answers();
        int actual = answers.getNumberOfAnswers();
        assertEquals(2, actual);
    }

    @Test
    public void testCanGiveAnswersInConstructor() {
        ArrayList<String> listOfAnswers = new ArrayList();
        listOfAnswers.add("Naw");
        listOfAnswers.add("Outlook not so good");
        listOfAnswers.add("Forget it");
        listOfAnswers.add("Great");

        Answers answers = new Answers(listOfAnswers);
        int actual = answers.getNumberOfAnswers();

        assertEquals(4, actual);
    }

    @Test
    public void testCanGetRandomAnswer() {
        Answers answers = new Answers();
        String answer = answers.getRandomAnswer();
        assertNotNull(answer);
    }
}
