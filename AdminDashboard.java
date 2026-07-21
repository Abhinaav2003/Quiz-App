import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton addBtn, viewBtn, deleteBtn, logoutBtn;

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("ADMIN DASHBOARD");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(90, 20, 300, 30);
        add(heading);

        addBtn = new JButton("Add Question");
        addBtn.setBounds(120, 80, 180, 40);
        add(addBtn);

        viewBtn = new JButton("View Questions");
        viewBtn.setBounds(120, 140, 180, 40);
        add(viewBtn);

        deleteBtn = new JButton("Delete Question");
        deleteBtn.setBounds(120, 200, 180, 40);
        add(deleteBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(120, 260, 180, 40);
        add(logoutBtn);

        addBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        setVisible(true);
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

            String input = JOptionPane.showInputDialog(this, "Enter Question Number (starting from 1):");

            try {

                int index = Integer.parseInt(input) - 1;

                if (index >= 0 && index < QuestionStore.questions.size()) {

                    QuestionStore.questions.remove(index);

                    JOptionPane.showMessageDialog(this, "Question Deleted Successfully");

                } else {

                    JOptionPane.showMessageDialog(this, "Invalid Question Number");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, "Invalid Input");

            }

        }

        else if (e.getSource() == logoutBtn) {

            dispose();
            new LoginFrame();

        }

    }
}