import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentDashboard extends JFrame implements ActionListener {

    JButton startQuizButton;
    JButton logoutButton;

    public StudentDashboard() {

        setTitle("Student Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("STUDENT DASHBOARD");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(70, 20, 260, 30);
        add(title);

        startQuizButton = new JButton("Start Quiz");
        startQuizButton.setBounds(110, 90, 160, 40);
        add(startQuizButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(110, 150, 160, 40);
        add(logoutButton);

        startQuizButton.addActionListener(this);
        logoutButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startQuizButton) {

            if (QuestionStore.questions.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "No questions available.\nPlease ask the admin to add questions.");

                return;
            }

            new QuizFrame();
            dispose();

        }

        if (e.getSource() == logoutButton) {

            new LoginFrame();
            dispose();

        }

    }
}