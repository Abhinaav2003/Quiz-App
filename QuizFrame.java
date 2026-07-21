import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizFrame extends JFrame implements ActionListener {

    JLabel lblQuestion, lblProgress;

    JRadioButton rb1, rb2, rb3, rb4;

    ButtonGroup group;

    JButton btnNext;

    int current = 0;
    int score = 0;

    public QuizFrame() {

        setTitle("Quiz");
        setSize(750,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(245,248,250));

        lblProgress = new JLabel();
        lblProgress.setBounds(30,20,200,25);
        lblProgress.setFont(new Font("Segoe UI",Font.BOLD,16));
        add(lblProgress);

        lblQuestion = new JLabel();
        lblQuestion.setBounds(30,60,680,40);
        lblQuestion.setFont(new Font("Segoe UI",Font.BOLD,18));
        add(lblQuestion);

        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        rb4 = new JRadioButton();

        rb1.setBounds(60,130,600,30);
        rb2.setBounds(60,180,600,30);
        rb3.setBounds(60,230,600,30);
        rb4.setBounds(60,280,600,30);

        Font optionFont = new Font("Segoe UI",Font.PLAIN,16);

        rb1.setFont(optionFont);
        rb2.setFont(optionFont);
        rb3.setFont(optionFont);
        rb4.setFont(optionFont);

        rb1.setBackground(getContentPane().getBackground());
        rb2.setBackground(getContentPane().getBackground());
        rb3.setBackground(getContentPane().getBackground());
        rb4.setBackground(getContentPane().getBackground());

        group = new ButtonGroup();

        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);

        btnNext = new JButton("Next ➜");
        btnNext.setBounds(280,370,150,45);
        btnNext.setBackground(new Color(52,152,219));
        btnNext.setForeground(Color.WHITE);
        btnNext.setFont(new Font("Segoe UI",Font.BOLD,16));
        btnNext.setFocusPainted(false);
        btnNext.addActionListener(this);
        add(btnNext);

        loadQuestion();

        setVisible(true);
    }

    private void loadQuestion(){

        Question q = QuestionStore.questions.get(current);

        lblProgress.setText("Question " + (current+1) + " / " + QuestionStore.questions.size());

        lblQuestion.setText(q.getQuestion());

        rb1.setText(q.getOption1());
        rb2.setText(q.getOption2());
        rb3.setText(q.getOption3());
        rb4.setText(q.getOption4());

        group.clearSelection();

        if(current == QuestionStore.questions.size()-1)
            btnNext.setText("Finish");
        else
            btnNext.setText("Next ➜");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String selected = "";

        if(rb1.isSelected())
            selected = rb1.getText();

        if(rb2.isSelected())
            selected = rb2.getText();

        if(rb3.isSelected())
            selected = rb3.getText();

        if(rb4.isSelected())
            selected = rb4.getText();

        if(selected.equals(
                QuestionStore.questions.get(current).getAnswer()))
            score++;

        current++;

        if(current<QuestionStore.questions.size()){

            loadQuestion();

        }else{

            dispose();

            new ResultFrame(score,QuestionStore.questions.size());

        }

    }

}