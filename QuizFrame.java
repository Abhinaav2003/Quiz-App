import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizFrame extends JFrame implements ActionListener {

    JLabel lblQuestion, lblNumber;

    JRadioButton rb1, rb2, rb3, rb4;

    ButtonGroup group;

    JButton nextBtn;

    int current = 0;
    int score = 0;

    public QuizFrame() {

        setTitle("Quiz");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        lblNumber = new JLabel();
        lblNumber.setBounds(30, 20, 100, 30);
        lblNumber.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblNumber);

        lblQuestion = new JLabel();
        lblQuestion.setBounds(30, 60, 620, 40);
        lblQuestion.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblQuestion);

        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        rb4 = new JRadioButton();

        rb1.setBounds(50,130,500,30);
        rb2.setBounds(50,180,500,30);
        rb3.setBounds(50,230,500,30);
        rb4.setBounds(50,280,500,30);

        rb1.setBackground(Color.WHITE);
        rb2.setBackground(Color.WHITE);
        rb3.setBackground(Color.WHITE);
        rb4.setBackground(Color.WHITE);

        group = new ButtonGroup();

        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(270,360,120,40);
        nextBtn.addActionListener(this);
        add(nextBtn);

        if (QuestionStore.getQuestionCount() == 0) {

            JOptionPane.showMessageDialog(this,
                    "No Questions Available");

            dispose();
            new StudentDashboard();
            return;
        }

        loadQuestion();

        setVisible(true);
    }

    private void loadQuestion() {

        Question q = QuestionStore.getQuestion(current);

        lblNumber.setText("Q." + (current + 1));

        lblQuestion.setText(q.getQuestion());

        rb1.setText(q.getOption1());
        rb2.setText(q.getOption2());
        rb3.setText(q.getOption3());
        rb4.setText(q.getOption4());

        group.clearSelection();

        if (current == QuestionStore.getQuestionCount() - 1) {
            nextBtn.setText("Finish");
        } else {
            nextBtn.setText("Next");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String answer = "";

        if (rb1.isSelected())
            answer = rb1.getText();

        else if (rb2.isSelected())
            answer = rb2.getText();

        else if (rb3.isSelected())
            answer = rb3.getText();

        else if (rb4.isSelected())
            answer = rb4.getText();

        if (answer.equalsIgnoreCase(
                QuestionStore.getQuestion(current).getAnswer())) {

            score++;

        }

        current++;

        if (current < QuestionStore.getQuestionCount()) {

            loadQuestion();

        } else {

            String studentName = JOptionPane.showInputDialog(
                    this,
                    "Enter Student Name");

            if (studentName == null ||
                    studentName.trim().isEmpty()) {

                studentName = "Unknown";

            }

            ResultStore.addResult(

                    new Result(
                            studentName,
                            QuestionStore.getQuestionCount(),
                            score
                    )

            );

            dispose();

            new ResultFrame(
                    score,
                    QuestionStore.getQuestionCount()
            );

        }

    }

}