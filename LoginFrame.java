import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JButton adminButton, studentButton, exitButton;
    JLabel title;

    public LoginFrame() {

        setTitle("Quiz Management System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        title = new JLabel("QUIZ MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(70, 30, 350, 40);
        add(title);

        adminButton = new JButton("Admin Login");
        adminButton.setBounds(150, 100, 180, 40);
        adminButton.addActionListener(this);
        add(adminButton);

        studentButton = new JButton("Student Login");
        studentButton.setBounds(150, 160, 180, 40);
        studentButton.addActionListener(this);
        add(studentButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(150, 220, 180, 40);
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == adminButton) {
            dispose();
            new AdminLogin();
        }

        else if (e.getSource() == studentButton) {
            dispose();
            new AdminLogin();
        }

        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}