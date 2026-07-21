import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentDashboard extends JFrame implements ActionListener {

    JButton startQuizBtn, logoutBtn;

    Color bg = new Color(245, 248, 250);
    Color blue = new Color(52, 152, 219);
    Color green = new Color(46, 204, 113);
    Color red = new Color(231, 76, 60);

    Font titleFont = new Font("Segoe UI", Font.BOLD, 26);
    Font btnFont = new Font("Segoe UI", Font.BOLD, 16);

    public StudentDashboard() {

        setTitle("Student Dashboard");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(bg);

        JLabel title = new JLabel("STUDENT DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(blue);
        title.setBounds(145, 30, 400, 40);
        add(title);

        JLabel welcome = new JLabel("Welcome! Ready to take the quiz?");
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        welcome.setBounds(180, 80, 300, 25);
        add(welcome);

        startQuizBtn = new JButton("📝 Start Quiz");
        startQuizBtn.setBounds(180, 150, 260, 50);
        styleButton(startQuizBtn, green);

        logoutBtn = new JButton("🚪 Logout");
        logoutBtn.setBounds(180, 230, 260, 50);
        styleButton(logoutBtn, red);

        add(startQuizBtn);
        add(logoutBtn);

        JLabel footer = new JLabel("Java Swing Quiz Management System");
        footer.setForeground(Color.GRAY);
        footer.setBounds(200, 400, 250, 25);
        add(footer);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {

        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(btnFont);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startQuizBtn) {

            if (QuestionStore.questions.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No questions available.\nPlease ask the admin to add questions.");

                return;
            }

            dispose();
            new QuizFrame();

        }

        else if (e.getSource() == logoutBtn) {

            dispose();
            new LoginFrame();

        }

    }
}