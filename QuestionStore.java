import java.util.ArrayList;

public class QuestionStore {

    // Stores all quiz questions
    public static ArrayList<Question> questions = new ArrayList<>();

    // Add a new question
    public static void addQuestion(Question question) {
        questions.add(question);
    }

    // Delete a question by index
    public static boolean deleteQuestion(int index) {

        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            return true;
        }

        return false;
    }

    // Get a question by index
    public static Question getQuestion(int index) {

        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }

        return null;
    }

    // Total number of questions
    public static int getQuestionCount() {
        return questions.size();
    }

    // Add some sample questions
    public static void loadSampleQuestions() {

        if (!questions.isEmpty()) {
            return;
        }

        questions.add(new Question(
                "What is the capital of India?",
                "Delhi",
                "Mumbai",
                "Lucknow",
                "Chennai",
                "Delhi"
        ));

        questions.add(new Question(
                "Which language is used for Android Development?",
                "Python",
                "Java",
                "PHP",
                "C",
                "Java"
        ));

        questions.add(new Question(
                "2 + 5 = ?",
                "5",
                "6",
                "7",
                "8",
                "7"
        ));

        questions.add(new Question(
                "Which company developed Java?",
                "Microsoft",
                "Google",
                "Sun Microsystems",
                "Apple",
                "Sun Microsystems"
        ));
    }
}