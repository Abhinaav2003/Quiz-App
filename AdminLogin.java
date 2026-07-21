import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JLabel lblTitle, lblUser, lblPass;

    JTextField txtUser;
    JPasswordField txtPass;

    JButton btnLogin, btnBack;

    int attempts = 3;

    Color bg = new Color(245,248,250);
    Color blue = new Color(52,152,219);
    Color red = new Color(231,76,60);

    Font titleFont = new Font("Segoe UI", Font.BOLD, 28);
    Font normalFont = new Font("Segoe UI", Font.PLAIN, 16);
    Font btnFont = new Font("Segoe UI", Font.BOLD, 16);

    public AdminLogin() {

        setTitle("Admin Login");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(bg);

        lblTitle = new JLabel("🔒 ADMIN LOGIN");
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(blue);
        lblTitle.setBounds(120,30,300,40);
        add(lblTitle);

        lblUser = new JLabel("Username");
        lblUser.setFont(normalFont);
        lblUser.setBounds(70,110,100,25);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(180,110,220,35);
        txtUser.setFont(normalFont);
        add(txtUser);

        lblPass = new JLabel("Password");
        lblPass.setFont(normalFont);
        lblPass.setBounds(70,170,100,25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(180,170,220,35);
        txtPass.setFont(normalFont);
        add(txtPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(90,260,130,45);
        btnLogin.setBackground(blue);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(btnFont);
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnBack = new JButton("Back");
        btnBack.setBounds(260,260,130,45);
        btnBack.setBackground(red);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(btnFont);
        btnBack.setFocusPainted(false);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);
        add(btnBack);

        JLabel info = new JLabel("Default Username : admin   Password : admin123");
        info.setBounds(60,330,380,20);
        info.setForeground(Color.GRAY);
        add(info);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnLogin){

            String username = txtUser.getText().trim();
            String password = String.valueOf(txtPass.getPassword());

            if(username.equals("admin") && password.equals("admin123")){

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!");

                dispose();

                new AdminDashboard();

            }else{

                attempts--;

                if(attempts>0){

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Username or Password\n\nAttempts Left : "
                                    + attempts);

                }else{

                    JOptionPane.showMessageDialog(
                            this,
                            "Admin Login Locked!");

                    btnLogin.setEnabled(false);

                }

                txtPass.setText("");

            }

        }

        if(e.getSource()==btnBack){

            dispose();

            new LoginFrame();

        }

    }

}