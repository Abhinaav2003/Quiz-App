import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewQuestionFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewQuestionFrame() {

        setTitle("View Questions");
        setSize(900, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("No.");
        model.addColumn("Question");
        model.addColumn("Option 1");
        model.addColumn("Option 2");
        model.addColumn("Option 3");
        model.addColumn("Option 4");
        model.addColumn("Answer");

        table = new JTable(model);
        table.setRowHeight(25);

        loadQuestions();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadQuestions() {

        model.setRowCount(0);

        if (QuestionStore.questions.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "No Questions Available.");

            return;
        }

        int no = 1;

        for (Question q : QuestionStore.questions) {

            model.addRow(new Object[]{
                    no++,
                    q.getQuestion(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4(),
                    q.getAnswer()
            });

        }
    }
}