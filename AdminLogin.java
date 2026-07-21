import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel userLabel;
    JLabel passLabel;

    JTextField txtUsername;
    JPasswordField txtPassword;

    JButton btnLogin;
    JButton btnBack;

    int attempts = 3;

    public AdminLogin() {

        setTitle("Admin Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("ADMIN LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(120, 20, 200, 30);
        add(titleLabel);

        userLabel = new JLabel("Username");
        userLabel.setBounds(40, 80, 100, 25);
        add(userLabel);

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 80, 180, 25);
        add(txtUsername);

        passLabel = new JLabel("Password");
        passLabel.setBounds(40, 120, 100, 25);
        add(passLabel);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 120, 180, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(70, 190, 100, 35);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnBack = new JButton("Back");
        btnBack.setBounds(210, 190, 100, 35);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogin) {

            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            // Default Admin Username and Password
            if (username.equals("admin") && password.equals("admin123")) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                dispose();
                new AdminDashboard();

            } else {

                attempts--;

                if (attempts > 0) {

                    JOptionPane.showMessageDialog(this,
                            "Invalid Username or Password\nAttempts Left : "
                                    + attempts);

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Admin Account Locked!");

                    btnLogin.setEnabled(false);

                }

            }

        }

        if (e.getSource() == btnBack) {

            dispose();
            new LoginFrame();

        }

    }
}