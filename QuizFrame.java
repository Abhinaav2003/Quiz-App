import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizFrame extends JFrame implements ActionListener {

    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup group;
    private JButton nextButton;

    private int currentQuestion = 0;
    private int score = 0;

    public QuizFrame() {

        setTitle("Quiz");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 20, 620, 40);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel);

        option1 = new JRadioButton();
        option1.setBounds(50, 80, 500, 30);

        option2 = new JRadioButton();
        option2.setBounds(50, 120, 500, 30);

        option3 = new JRadioButton();
        option3.setBounds(50, 160, 500, 30);

        option4 = new JRadioButton();
        option4.setBounds(50, 200, 500, 30);

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        add(option1);
        add(option2);
        add(option3);
        add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(270, 280, 120, 40);
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();

        setVisible(true);
    }

    private void loadQuestion() {

        Question q = QuestionStore.questions.get(currentQuestion);

        questionLabel.setText("Q" + (currentQuestion + 1) + ". " + q.getQuestion());

        option1.setText(q.getOption1());
        option2.setText(q.getOption2());
        option3.setText(q.getOption3());
        option4.setText(q.getOption4());

        group.clearSelection();

        if (currentQuestion == QuestionStore.questions.size() - 1) {
            nextButton.setText("Finish");
        } else {
            nextButton.setText("Next");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String selected = "";

        if (option1.isSelected())
            selected = option1.getText();

        else if (option2.isSelected())
            selected = option2.getText();

        else if (option3.isSelected())
            selected = option3.getText();

        else if (option4.isSelected())
            selected = option4.getText();

        if (selected.equals(
                QuestionStore.questions.get(currentQuestion).getAnswer())) {

            score++;

        }

        currentQuestion++;

        if (currentQuestion < QuestionStore.questions.size()) {

            loadQuestion();

        } else {

            dispose();

            new ResultFrame(score, QuestionStore.questions.size());

        }

    }
}