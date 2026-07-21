public class Result {

    private String studentName;
    private int totalQuestions;
    private int correctAnswers;
    private int wrongAnswers;
    private int percentage;

    public Result(String studentName, int totalQuestions, int correctAnswers) {

        this.studentName = studentName;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = totalQuestions - correctAnswers;

        if (totalQuestions == 0) {
            this.percentage = 0;
        } else {
            this.percentage = (correctAnswers * 100) / totalQuestions;
        }
    }

    // Getters

    public String getStudentName() {
        return studentName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getPercentage() {
        return percentage;
    }

    // Setters

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = totalQuestions - correctAnswers;

        if (totalQuestions == 0) {
            this.percentage = 0;
        } else {
            this.percentage = (correctAnswers * 100) / totalQuestions;
        }
    }

    @Override
    public String toString() {
        return "Student : " + studentName +
               "\nTotal Questions : " + totalQuestions +
               "\nCorrect Answers : " + correctAnswers +
               "\nWrong Answers : " + wrongAnswers +
               "\nPercentage : " + percentage + "%";
    }
}