import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultFrame extends JFrame implements ActionListener {

    JButton btnHome, btnExit;

    public ResultFrame(int score, int total) {

        setTitle("Quiz Result");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 248, 250));

        Font titleFont = new Font("Segoe UI", Font.BOLD, 28);
        Font textFont = new Font("Segoe UI", Font.PLAIN, 18);

        int wrong = total - score;
        int percentage = (score * 100) / total;

        JLabel title = new JLabel("🎉 QUIZ RESULT");
        title.setFont(titleFont);
        title.setForeground(new Color(41, 128, 185));
        title.setBounds(140, 20, 300, 40);
        add(title);

        JLabel totalLabel = new JLabel("Total Questions : " + total);
        totalLabel.setFont(textFont);
        totalLabel.setBounds(120, 90, 300, 30);
        add(totalLabel);

        JLabel correctLabel = new JLabel("Correct Answers : " + score);
        correctLabel.setFont(textFont);
        correctLabel.setBounds(120, 130, 300, 30);
        add(correctLabel);

        JLabel wrongLabel = new JLabel("Wrong Answers : " + wrong);
        wrongLabel.setFont(textFont);
        wrongLabel.setBounds(120, 170, 300, 30);
        add(wrongLabel);

        JLabel percentLabel = new JLabel("Percentage : " + percentage + "%");
        percentLabel.setFont(textFont);
        percentLabel.setBounds(120, 210, 300, 30);
        add(percentLabel);

        JLabel resultLabel = new JLabel();
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        resultLabel.setBounds(120, 260, 300, 35);

        if (percentage >= 40) {
            resultLabel.setText("✅ RESULT : PASS");
            resultLabel.setForeground(new Color(39, 174, 96));
        } else {
            resultLabel.setText("❌ RESULT : FAIL");
            resultLabel.setForeground(Color.RED);
        }

        add(resultLabel);

        btnHome = new JButton("🏠 Home");
        btnHome.setBounds(100, 330, 140, 45);
        btnHome.setBackground(new Color(52, 152, 219));
        btnHome.setForeground(Color.WHITE);
        btnHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(this);
        add(btnHome);

        btnExit = new JButton("🚪 Exit");
        btnExit.setBounds(290, 330, 140, 45);
        btnExit.setBackground(new Color(231, 76, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(this);
        add(btnExit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnHome) {

            dispose();
            new LoginFrame();

        }

        if (e.getSource() == btnExit) {

            System.exit(0);

        }
    }
}