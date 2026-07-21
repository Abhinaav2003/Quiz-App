import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel subtitleLabel;

    JButton adminButton;
    JButton studentButton;
    JButton exitButton;

    Color background = new Color(245, 248, 250);
    Color blue = new Color(41, 128, 185);
    Color green = new Color(39, 174, 96);
    Color red = new Color(231, 76, 60);

    Font titleFont = new Font("Segoe UI", Font.BOLD, 28);
    Font subFont = new Font("Segoe UI", Font.PLAIN, 16);
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 16);

    public LoginFrame() {

        setTitle("Quiz Management System");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(background);

        titleLabel = new JLabel("Quiz Management System");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(blue);
        titleLabel.setBounds(90, 30, 420, 40);
        add(titleLabel);

        subtitleLabel = new JLabel("Welcome! Please choose your login.");
        subtitleLabel.setFont(subFont);
        subtitleLabel.setBounds(150, 75, 300, 30);
        add(subtitleLabel);

        adminButton = new JButton("Admin Login");
        adminButton.setBounds(180, 140, 220, 45);
        adminButton.setBackground(blue);
        adminButton.setForeground(Color.WHITE);
        adminButton.setFont(buttonFont);
        adminButton.setFocusPainted(false);
        adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminButton.addActionListener(this);
        add(adminButton);

        studentButton = new JButton("Student Login");
        studentButton.setBounds(180, 205, 220, 45);
        studentButton.setBackground(green);
        studentButton.setForeground(Color.WHITE);
        studentButton.setFont(buttonFont);
        studentButton.setFocusPainted(false);
        studentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentButton.addActionListener(this);
        add(studentButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 270, 220, 45);
        exitButton.setBackground(red);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(buttonFont);
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(this);
        add(exitButton);

        JLabel footer = new JLabel("Developed by Abhinav & Anshu", SwingConstants.CENTER);
        footer.setBounds(0, 370, 600, 30);
        footer.setForeground(Color.GRAY);
        add(footer);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == adminButton) {

            dispose();
            new AdminLogin();

        } else if (e.getSource() == studentButton) {

            dispose();
            new StudentDashboard();

        } else if (e.getSource() == exitButton) {

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}