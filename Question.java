import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Quiz {

    private static final int TIME_LIMIT = 10; // in seconds
    private static final int NUM_QUESTIONS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question[] questions = new Question[NUM_QUESTIONS];
        int score = 0;

        // Initialize questions
        questions[0] = new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0);
        questions[1] = new Question("Which planet is closest to the sun?", new String[]{"Mercury", "Venus", "Earth", "Mars"}, 0);
        questions[2] = new Question("Who wrote the novel '1984'?", new String[]{"George Orwell", "Aldous Huxley", "Ray Bradbury", "Arthur C. Clarke"}, 0);
        questions[3] = new Question("What is the square root of 64?", new String[]{"8", "6", "10", "12"}, 0);
        questions[4] = new Question("Which country is known as the 'Land of the Rising Sun'?", new String[]{"China", "Japan", "South Korea", "North Korea"}, 1);

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            Question question = questions[i];
            System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestion());
            for (int j = 0; j < question.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + question.getOptions()[j]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    scanner.nextLine();
                    timer.cancel();
                }
            }, TIME_LIMIT * 1000);

            System.out.print("\nEnter your answer (1-" + question.getOptions().length + "): ");
            int answer = scanner.nextInt() - 1;
            if (answer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getOptions()[question.getCorrectAnswer()]);
            }
            timer.cancel();
        }

        System.out.println("\nYour final score is: " + score + " out of " + NUM_QUESTIONS);
        scanner.close();
    }
}
