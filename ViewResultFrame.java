import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ViewResultFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    JLabel totalLabel;
    JLabel averageLabel;
    JLabel highestLabel;

    JButton refreshBtn;
    JButton closeBtn;

    public ViewResultFrame() {

        setTitle("Student Result Management");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color blue = new Color(41,128,185);
        Color green = new Color(39,174,96);
        Color orange = new Color(243,156,18);

        //---------------- Header ----------------//

        JPanel header = new JPanel();
        header.setBackground(blue);

        JLabel title = new JLabel("STUDENT RESULT MANAGEMENT");

        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI",Font.BOLD,26));

        header.add(title);

        add(header,BorderLayout.NORTH);

        //---------------- Statistics ----------------//

        JPanel stats = new JPanel(new GridLayout(1,3,15,15));
        stats.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        totalLabel = new JLabel();
        averageLabel = new JLabel();
        highestLabel = new JLabel();

        totalLabel.setFont(new Font("Segoe UI",Font.BOLD,18));
        averageLabel.setFont(new Font("Segoe UI",Font.BOLD,18));
        highestLabel.setFont(new Font("Segoe UI",Font.BOLD,18));

        totalLabel.setForeground(blue);
        averageLabel.setForeground(green);
        highestLabel.setForeground(orange);

        stats.add(totalLabel);
        stats.add(averageLabel);
        stats.add(highestLabel);

        //---------------- Table ----------------//

        String columns[]={
                "Student",
                "Total",
                "Correct",
                "Wrong",
                "Percentage"
        };

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);

        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI",Font.PLAIN,15));

        JTableHeader head = table.getTableHeader();
        head.setFont(new Font("Segoe UI",Font.BOLD,15));

        JScrollPane scroll = new JScrollPane(table);

        JPanel center = new JPanel(new BorderLayout());

        center.add(stats,BorderLayout.NORTH);
        center.add(scroll,BorderLayout.CENTER);

        add(center,BorderLayout.CENTER);

        //---------------- Bottom ----------------//

        JPanel bottom = new JPanel();

        refreshBtn = new JButton("Refresh");
        closeBtn = new JButton("Close");

        bottom.add(refreshBtn);
        bottom.add(closeBtn);

        add(bottom,BorderLayout.SOUTH);

        refreshBtn.addActionListener(e->loadData());

        closeBtn.addActionListener(e->dispose());

        loadData();

        setVisible(true);
    }

    private void loadData(){

        model.setRowCount(0);

        int highest = 0;
        int totalPercentage = 0;

        for(Result r : ResultStore.results){

            model.addRow(new Object[]{

                    r.getStudentName(),
                    r.getTotalQuestions(),
                    r.getCorrectAnswers(),
                    r.getWrongAnswers(),
                    r.getPercentage()+" %"

            });

            totalPercentage += r.getPercentage();

            if(r.getPercentage()>highest)
                highest=r.getPercentage();

        }

        int totalStudents = ResultStore.results.size();

        int average = 0;

        if(totalStudents>0)
            average = totalPercentage/totalStudents;

        totalLabel.setText("👥 Total Students : "+totalStudents);

        averageLabel.setText("📈 Average : "+average+" %");

        highestLabel.setText("🏆 Highest : "+highest+" %");

    }

}