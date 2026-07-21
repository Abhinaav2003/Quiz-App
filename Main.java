import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Add some default questions
        QuestionStore.questions.add(new Question(
                "What is Java?",
                "Programming Language",
                "Operating System",
                "Database",
                "Browser",
                "Programming Language"));

        QuestionStore.questions.add(new Question(
                "Which company developed Java?",
                "Microsoft",
                "Oracle",
                "Google",
                "Apple",
                "Oracle"));

        QuestionStore.questions.add(new Question(
                "Which keyword is used to inherit a class?",
                "implements",
                "extends",
                "import",
                "package",
                "extends"));

        QuestionStore.questions.add(new Question(
                "Which package is used for Swing?",
                "java.sql",
                "java.io",
                "javax.swing",
                "java.net",
                "javax.swing"));

        QuestionStore.questions.add(new Question(
                "Which year was Java developed?",
                "1995",
                "1996",
                "1997",
                "1998",
                "1995"));

        // Launch Login Window
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}