import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddQuestionFrame extends JFrame implements ActionListener {

    JTextArea txtQuestion;
    JTextField txtOp1, txtOp2, txtOp3, txtOp4, txtAnswer;

    JButton btnSave, btnClear, btnBack;

    public AddQuestionFrame() {

        setTitle("Add Question");
        setSize(700, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(245,248,250));

        Font titleFont = new Font("Segoe UI", Font.BOLD, 24);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 15);

        JLabel title = new JLabel("ADD NEW QUESTION");
        title.setFont(titleFont);
        title.setForeground(new Color(41,128,185));
        title.setBounds(190,20,320,35);
        add(title);

        JLabel qLabel = new JLabel("Question");
        qLabel.setFont(labelFont);
        qLabel.setBounds(40,80,120,25);
        add(qLabel);

        txtQuestion = new JTextArea();
        txtQuestion.setFont(fieldFont);
        txtQuestion.setLineWrap(true);
        txtQuestion.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtQuestion);
        scroll.setBounds(170,80,470,90);
        add(scroll);

        JLabel op1 = new JLabel("Option A");
        op1.setFont(labelFont);
        op1.setBounds(40,190,100,25);
        add(op1);

        txtOp1 = new JTextField();
        txtOp1.setBounds(170,190,470,35);
        txtOp1.setFont(fieldFont);
        add(txtOp1);

        JLabel op2 = new JLabel("Option B");
        op2.setFont(labelFont);
        op2.setBounds(40,240,100,25);
        add(op2);

        txtOp2 = new JTextField();
        txtOp2.setBounds(170,240,470,35);
        txtOp2.setFont(fieldFont);
        add(txtOp2);

        JLabel op3 = new JLabel("Option C");
        op3.setFont(labelFont);
        op3.setBounds(40,290,100,25);
        add(op3);

        txtOp3 = new JTextField();
        txtOp3.setBounds(170,290,470,35);
        txtOp3.setFont(fieldFont);
        add(txtOp3);

        JLabel op4 = new JLabel("Option D");
        op4.setFont(labelFont);
        op4.setBounds(40,340,100,25);
        add(op4);

        txtOp4 = new JTextField();
        txtOp4.setBounds(170,340,470,35);
        txtOp4.setFont(fieldFont);
        add(txtOp4);

        JLabel ans = new JLabel("Correct Answer");
        ans.setFont(labelFont);
        ans.setBounds(40,390,120,25);
        add(ans);

        txtAnswer = new JTextField();
        txtAnswer.setBounds(170,390,470,35);
        txtAnswer.setFont(fieldFont);
        add(txtAnswer);

        btnSave = new JButton("Save");
        btnSave.setBounds(70,500,150,45);

        btnClear = new JButton("Clear");
        btnClear.setBounds(260,500,150,45);

        btnBack = new JButton("Back");
        btnBack.setBounds(450,500,150,45);

        styleButton(btnSave, new Color(39,174,96));
        styleButton(btnClear, new Color(243,156,18));
        styleButton(btnBack, new Color(231,76,60));

        add(btnSave);
        add(btnClear);
        add(btnBack);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {

        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnSave){

            if(txtQuestion.getText().trim().isEmpty() ||
               txtOp1.getText().trim().isEmpty() ||
               txtOp2.getText().trim().isEmpty() ||
               txtOp3.getText().trim().isEmpty() ||
               txtOp4.getText().trim().isEmpty() ||
               txtAnswer.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields.");
                return;
            }

            Question q = new Question(
                    txtQuestion.getText().trim(),
                    txtOp1.getText().trim(),
                    txtOp2.getText().trim(),
                    txtOp3.getText().trim(),
                    txtOp4.getText().trim(),
                    txtAnswer.getText().trim()
            );

            QuestionStore.questions.add(q);

            JOptionPane.showMessageDialog(this,
                    "Question Added Successfully!");

            txtQuestion.setText("");
            txtOp1.setText("");
            txtOp2.setText("");
            txtOp3.setText("");
            txtOp4.setText("");
            txtAnswer.setText("");

        }

        else if(e.getSource()==btnClear){

            txtQuestion.setText("");
            txtOp1.setText("");
            txtOp2.setText("");
            txtOp3.setText("");
            txtOp4.setText("");
            txtAnswer.setText("");

        }

        else if(e.getSource()==btnBack){

            dispose();

        }

    }

}