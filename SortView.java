package IA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SortView extends View {
    JButton sortByData;
    JButton sortByInTextCitation;
    JButton sortByTopic;
    JTextField parameter;

    public SortView() {
        super(1); // calls View(int) constructor (does nothing)
        this.setTitle("Sort Options");
        this.setSize(450, 320);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(backgroundGray);
        this.setLocationRelativeTo(null);

        // ==== TOP BAR (same style as View top bar) ====
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(primaryBlue);
        top.setPreferredSize(new Dimension(400, 55));
        top.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel title = new JLabel("Sort Cards", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        top.add(title, BorderLayout.CENTER);

        this.add(top, BorderLayout.NORTH);

        // ==== CENTER PANEL ====
        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.setBackground(backgroundGray);
        center.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.add(center, BorderLayout.CENTER);

        // Label
        JLabel label = new JLabel("How would you like to sort?", JLabel.CENTER);
        label.setFont(fieldFont);
        center.add(label, BorderLayout.NORTH);

        // Parameter input
        parameter = createField("Enter sorting parameter here", JTextField.CENTER);
        parameter.setPreferredSize(new Dimension(200, 35));
        center.add(parameter, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(backgroundGray);

        sortByData = createButton("Sort by Data", true);
        buttonPanel.add(sortByData);

        sortByInTextCitation = createButton("Sort by In Text Citation", true);
        buttonPanel.add(sortByInTextCitation);

        sortByTopic = createButton("Sort by Topic", true);
        buttonPanel.add(sortByTopic);

        center.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortByData) {
            Controller.sortByData(parameter.getText());
            this.dispose();
        } else if (e.getSource() == sortByInTextCitation) {
            Controller.sortByInTextCitation(parameter.getText());
            this.dispose();
        } else if (e.getSource() == sortByTopic) {
            Controller.sortByTopic(parameter.getText());
            this.dispose();
        }
    }
}