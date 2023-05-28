package codeacademy.learnintermediatejava.threading;
import java.lang.Thread;
import java.util.Random;

/****
 * This is an example of a class that is implemented as a Thread using lambdas. The class FortuneTeller has a
 * Thread lambda implementation that use this class CrystalBall to ask the question in a concurrent fashion.
 *
 *
 */
public class CrystalBall { //implements Runnable{ //extends Thread{
    private Question question;
    private boolean isThinking = false;
    /**
     * As the parallel execution is done using lambdas in the class FortuneTeller, there no need to have a constructor
     * to pass parameters to use in the run method, since the run method is also removed.
        public CrystalBall(Question question){
            this.question = question;

        }
     **/

    /**
     * This is the only method that needs to be overrided or extended when implementing Thread
     * With alamda implementation there no need to have the run method because the implementation
     * is expressed as a lambda
     *
       public void run(){
        ask(question);
      }
     */

    private int getSleepTimeInMs(Question.Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return 1000;
            case MEDIUM:
                return 2000;
            case HARD:
                return 3000;
            default:
                return 500;
        }
    }

    private String answer() {
        String[] answers = {
                "Signs point to yes!",
                "Certainly!",
                "No opinion",
                "Answer is a little cloudy. Try again.",
                "Surely.",
                "No.",
                "Signs point to no.",
                "It could very well be!"
        };
        return answers[new Random().nextInt(answers.length)];
    }

    private synchronized void think(Question question) {
        System.out.println("Hmm... Thinking");

        try {

            Thread.sleep(this.getSleepTimeInMs(question.getDifficulty()));

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Done!");
    }

    public void ask(Question question) {
        System.out.println("Good question! You asked: " + question.getQuestion());
        this.think(question);
        System.out.println("Answer to question : " + question.getQuestion() + ". This is the answer: " + this.answer());
    }
}
