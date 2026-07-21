import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton addBtn, viewBtn, deleteBtn, resultBtn, logoutBtn;

    Color bg = new Color(245, 248, 250);
    Color blue = new Color(52, 152, 219);
    Color green = new Color(46, 204, 113);
    Color orange = new Color(243, 156, 18);
    Color purple = new Color(155, 89, 182);
    Color red = new Color(231, 76, 60);

    Font titleFont = new Font("Segoe UI", Font.BOLD, 26);
    Font btnFont = new Font("Segoe UI", Font.BOLD, 16);

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(650, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(bg);

        JLabel title = new JLabel("ADMIN DASHBOARD");
        title.setFont(titleFont);
        title.setForeground(blue);
        title.setBounds(160, 20, 350, 40);
        add(title);

        addBtn = new JButton("➕ Add Question");
        addBtn.setBounds(180, 90, 250, 45);
        styleButton(addBtn, green);

        viewBtn = new JButton("📄 View Questions");
        viewBtn.setBounds(180, 150, 250, 45);
        styleButton(viewBtn, blue);

        deleteBtn = new JButton("❌ Delete Question");
        deleteBtn.setBounds(180, 210, 250, 45);
        styleButton(deleteBtn, orange);

        resultBtn = new JButton("📊 View Student Results");
        resultBtn.setBounds(180, 270, 250, 45);
        styleButton(resultBtn, purple);

        logoutBtn = new JButton("🚪 Logout");
        logoutBtn.setBounds(180, 330, 250, 45);
        styleButton(logoutBtn, red);

        add(addBtn);
        add(viewBtn);
        add(deleteBtn);
        add(resultBtn);
        add(logoutBtn);

        JLabel footer = new JLabel("Quiz Management System");
        footer.setBounds(220, 450, 250, 25);
        footer.setForeground(Color.GRAY);
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

        if (e.getSource() == addBtn) {

            new AddQuestionFrame();

        }

        else if (e.getSource() == viewBtn) {

            new ViewQuestionFrame();

        }

        else if (e.getSource() == deleteBtn) {

            String input = JOptionPane.showInputDialog(
                    this,
                    "Enter Question Number to Delete");

            if (input == null)
                return;

            try {

                int index = Integer.parseInt(input) - 1;

                if (index >= 0 && index < QuestionStore.questions.size()) {

                    QuestionStore.questions.remove(index);

                    JOptionPane.showMessageDialog(
                            this,
                            "Question Deleted Successfully!");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Question Number!");

                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid number.");

            }

        }

        else if (e.getSource() == resultBtn) {

            new ViewResultFrame();

        }

        else if (e.getSource() == logoutBtn) {

            dispose();
            new LoginFrame();

        }

    }
}