import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewResultFrame extends JFrame {

    JTable table;

    public ViewResultFrame() {

        setTitle("Student Results");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {
                "Student Name",
                "Total Questions",
                "Correct",
                "Wrong",
                "Percentage"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Result r : ResultStore.results) {

            model.addRow(new Object[] {
                    r.getStudentName(),
                    r.getTotalQuestions(),
                    r.getCorrectAnswers(),
                    r.getWrongAnswers(),
                    r.getPercentage() + "%"
            });

        }

        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}