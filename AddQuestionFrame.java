import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddQuestionFrame extends JFrame implements ActionListener {

    JTextField questionField;
    JTextField option1Field;
    JTextField option2Field;
    JTextField option3Field;
    JTextField option4Field;
    JTextField answerField;

    JButton saveButton, clearButton;

    public AddQuestionFrame() {

        setTitle("Add Question");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("ADD NEW QUESTION");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(180, 10, 250, 30);
        add(title);

        JLabel qLabel = new JLabel("Question:");
        qLabel.setBounds(30, 60, 100, 25);
        add(qLabel);

        questionField = new JTextField();
        questionField.setBounds(130, 60, 420, 25);
        add(questionField);

        JLabel op1 = new JLabel("Option 1:");
        op1.setBounds(30, 100, 100, 25);
        add(op1);

        option1Field = new JTextField();
        option1Field.setBounds(130, 100, 420, 25);
        add(option1Field);

        JLabel op2 = new JLabel("Option 2:");
        op2.setBounds(30, 140, 100, 25);
        add(op2);

        option2Field = new JTextField();
        option2Field.setBounds(130, 140, 420, 25);
        add(option2Field);

        JLabel op3 = new JLabel("Option 3:");
        op3.setBounds(30, 180, 100, 25);
        add(op3);

        option3Field = new JTextField();
        option3Field.setBounds(130, 180, 420, 25);
        add(option3Field);

        JLabel op4 = new JLabel("Option 4:");
        op4.setBounds(30, 220, 100, 25);
        add(op4);

        option4Field = new JTextField();
        option4Field.setBounds(130, 220, 420, 25);
        add(option4Field);

        JLabel ans = new JLabel("Correct Answer:");
        ans.setBounds(30, 260, 120, 25);
        add(ans);

        answerField = new JTextField();
        answerField.setBounds(150, 260, 400, 25);
        add(answerField);

        saveButton = new JButton("Save");
        saveButton.setBounds(150, 330, 120, 40);
        saveButton.addActionListener(this);
        add(saveButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(320, 330, 120, 40);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {

            String question = questionField.getText().trim();
            String op1 = option1Field.getText().trim();
            String op2 = option2Field.getText().trim();
            String op3 = option3Field.getText().trim();
            String op4 = option4Field.getText().trim();
            String answer = answerField.getText().trim();

            if (question.isEmpty() || op1.isEmpty() || op2.isEmpty()
                    || op3.isEmpty() || op4.isEmpty() || answer.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields.");

                return;
            }

            QuestionStore.questions.add(
                    new Question(question, op1, op2, op3, op4, answer));

            JOptionPane.showMessageDialog(this,
                    "Question Added Successfully!");

            questionField.setText("");
            option1Field.setText("");
            option2Field.setText("");
            option3Field.setText("");
            option4Field.setText("");
            answerField.setText("");

        } else if (e.getSource() == clearButton) {

            questionField.setText("");
            option1Field.setText("");
            option2Field.setText("");
            option3Field.setText("");
            option4Field.setText("");
            answerField.setText("");

        }
    }
}