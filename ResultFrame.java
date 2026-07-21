import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultFrame extends JFrame implements ActionListener {

    JButton homeButton;

    public ResultFrame(int score, int total) {

        setTitle("Quiz Result");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        int percentage = (score * 100) / total;

        JLabel title = new JLabel("QUIZ RESULT");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(130, 20, 200, 30);
        add(title);

        JLabel totalLabel = new JLabel("Total Questions : " + total);
        totalLabel.setBounds(80, 80, 250, 25);
        add(totalLabel);

        JLabel correctLabel = new JLabel("Correct Answers : " + score);
        correctLabel.setBounds(80, 120, 250, 25);
        add(correctLabel);

        JLabel wrongLabel = new JLabel("Wrong Answers : " + (total - score));
        wrongLabel.setBounds(80, 160, 250, 25);
        add(wrongLabel);

        JLabel percentLabel = new JLabel("Percentage : " + percentage + "%");
        percentLabel.setBounds(80, 200, 250, 25);
        add(percentLabel);

        JLabel resultLabel;

        if (percentage >= 40) {
            resultLabel = new JLabel("Result : PASS");
        } else {
            resultLabel = new JLabel("Result : FAIL");
        }

        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setBounds(80, 230, 200, 30);
        add(resultLabel);

        homeButton = new JButton("Back to Home");
        homeButton.setBounds(130, 270, 170, 35);
        homeButton.addActionListener(this);
        add(homeButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        dispose();

        new LoginFrame();

    }
}