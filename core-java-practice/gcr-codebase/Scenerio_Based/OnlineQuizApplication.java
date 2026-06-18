import java.util.Scanner;

/**
 * Additional Problem 1: Online Quiz Application
 * 
 * Student answers are stored in an array.
 * String answers[] = {"A","B","C","D"};
 * 
 * Scenario:
 * The program compares answers using:
 * answers[5].equals("A")
 * 
 * Task:
 * - Identify possible exceptions (ArrayIndexOutOfBoundsException, NullPointerException)
 * - Handle them appropriately
 * - Continue checking the remaining answers
 */
public class OnlineQuizApplication {
    
    private String[] correctAnswers;
    private String[] studentAnswers;
    private int totalQuestions;
    
    public OnlineQuizApplication(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = new String[totalQuestions];
        this.studentAnswers = new String[totalQuestions];
    }
    
    /**
     * Set correct answers for the quiz
     */
    public void setCorrectAnswers(String... answers) {
        if (answers.length != totalQuestions) {
            throw new IllegalArgumentException("Number of answers must match total questions");
        }
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == null || !isValidOption(answers[i])) {
                throw new IllegalArgumentException("Invalid answer: " + answers[i]);
            }
            this.correctAnswers[i] = answers[i];
        }
    }
    
    /**
     * Set student answers
     */
    public void setStudentAnswers(String... answers) {
        if (answers.length != totalQuestions) {
            throw new IllegalArgumentException("Number of answers must match total questions");
        }
        this.studentAnswers = answers;
    }
    
    /**
     * Validate if answer is a valid option (A, B, C, or D)
     */
    public boolean isValidOption(String option) {
        return option != null && (option.equals("A") || option.equals("B") || 
                                 option.equals("C") || option.equals("D"));
    }
    
    /**
     * Check a single answer with proper exception handling
     */
    public boolean checkAnswer(int questionNumber) {
        try {
            // Check for valid index
            if (questionNumber < 0 || questionNumber >= totalQuestions) {
                throw new ArrayIndexOutOfBoundsException("Invalid question number: " + questionNumber);
            }
            
            // Check for null student answer
            if (studentAnswers[questionNumber] == null) {
                throw new NullPointerException("Student did not answer question " + (questionNumber + 1));
            }
            
            // Compare answers
            boolean isCorrect = studentAnswers[questionNumber].equals(correctAnswers[questionNumber]);
            return isCorrect;
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Grade the entire quiz
     */
    public void gradeQuiz() {
        System.out.println("\n--- Quiz Grading Results ---");
        int correctCount = 0;
        
        for (int i = 0; i < totalQuestions; i++) {
            try {
                if (studentAnswers[i] == null) {
                    System.out.println("Q" + (i + 1) + ": Not answered | Correct: " + 
                                     correctAnswers[i] + " | Status: ✗");
                } else {
                    boolean isCorrect = studentAnswers[i].equals(correctAnswers[i]);
                    System.out.println("Q" + (i + 1) + ": Student: " + studentAnswers[i] + 
                                     " | Correct: " + correctAnswers[i] + 
                                     " | Status: " + (isCorrect ? "✓" : "✗"));
                    if (isCorrect) {
                        correctCount++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Q" + (i + 1) + ": Error accessing answer");
            } catch (NullPointerException e) {
                System.out.println("Q" + (i + 1) + ": Null pointer exception");
            }
        }
        
        double percentage = (correctCount * 100.0) / totalQuestions;
        System.out.println("\nScore: " + correctCount + "/" + totalQuestions);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter total number of questions: ");
            int numQuestions = scanner.nextInt();
            scanner.nextLine();
            
            OnlineQuizApplication quiz = new OnlineQuizApplication(numQuestions);
            
            // Set correct answers
            System.out.println("\nEnter correct answers (A/B/C/D):");
            String[] correctAnswers = new String[numQuestions];
            
            for (int i = 0; i < numQuestions; i++) {
                System.out.print("Q" + (i + 1) + " correct answer: ");
                String answer = scanner.nextLine().trim().toUpperCase();
                
                if (!quiz.isValidOption(answer)) {
                    System.out.println("Invalid option! Please enter A, B, C, or D.");
                    i--;
                    continue;
                }
                correctAnswers[i] = answer;
            }
            
            quiz.setCorrectAnswers(correctAnswers);
            
            // Set student answers
            System.out.println("\nEnter student answers (A/B/C/D, or leave blank for unanswered):");
            String[] studentAnswers = new String[numQuestions];
            
            for (int i = 0; i < numQuestions; i++) {
                System.out.print("Q" + (i + 1) + " student answer: ");
                String answer = scanner.nextLine().trim().toUpperCase();
                
                if (answer.isEmpty()) {
                    studentAnswers[i] = null;
                } else if (!quiz.isValidOption(answer)) {
                    System.out.println("Invalid option! Answer skipped.");
                    studentAnswers[i] = null;
                    continue;
                } else {
                    studentAnswers[i] = answer;
                }
            }
            
            quiz.setStudentAnswers(studentAnswers);
            
            // Grade the quiz
            quiz.gradeQuiz();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
