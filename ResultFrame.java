import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultFrame extends JFrame implements ActionListener {

    JLabel lblTitle;
    JLabel lblScore;
    JLabel lblPercentage;
    JLabel lblStatus;

    JButton btnHome;
    JButton btnExit;

    int score;
    int total;
    int percentage;

    public ResultFrame(int score, int total) {

        this.score = score;
        this.total = total;

        if (total == 0)
            percentage = 0;
        else
            percentage = (score * 100) / total;

        setTitle("Quiz Result");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(245,248,250));

        lblTitle = new JLabel("QUIZ RESULT");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(52,152,219));
        lblTitle.setBounds(180,30,250,40);
        add(lblTitle);

        lblScore = new JLabel("Score : " + score + " / " + total);
        lblScore.setFont(new Font("Segoe UI", Font.BOLD,20));
        lblScore.setBounds(170,100,250,35);
        add(lblScore);

        lblPercentage = new JLabel("Percentage : " + percentage + "%");
        lblPercentage.setFont(new Font("Segoe UI", Font.BOLD,20));
        lblPercentage.setBounds(170,150,250,35);
        add(lblPercentage);

        lblStatus = new JLabel();

        if (percentage >= 40) {
            lblStatus.setText("🎉 Status : PASS");
            lblStatus.setForeground(new Color(39,174,96));
        } else {
            lblStatus.setText("❌ Status : FAIL");
            lblStatus.setForeground(Color.RED);
        }

        lblStatus.setFont(new Font("Segoe UI", Font.BOLD,22));
        lblStatus.setBounds(170,210,250,35);
        add(lblStatus);

        btnHome = new JButton("Home");
        btnHome.setBounds(120,320,150,45);
        btnHome.setBackground(new Color(52,152,219));
        btnHome.setForeground(Color.WHITE);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(this);
        add(btnHome);

        btnExit = new JButton("Exit");
        btnExit.setBounds(320,320,150,45);
        btnExit.setBackground(new Color(231,76,60));
        btnExit.setForeground(Color.WHITE);
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

        else if (e.getSource() == btnExit) {

            System.exit(0);

        }

    }
}