package IA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;

public class View extends JFrame implements ActionListener {
    JLabel title;
    JButton download;
    JButton upload;
    JButton sort;
    JButton clearSort;
    JButton previous;
    JButton next;
    JTextField topic;
    JTextField inTextCitation;
    JTextField citation;
    JTextArea data;
    JButton save;
    JButton delete;
    JButton saveAndClose;
    JButton add;

    Font buttonFont = new Font("Segoe UI", Font.PLAIN, 14);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
    Font titleFont = new Font("Segoe UI", Font.BOLD, 28);

    // Color palette
    Color primaryBlue = new Color(45, 90, 165);
    Color lightBlue = new Color(70, 120, 200);
    Color hoverBlue = new Color(55, 105, 185);
    Color backgroundGray = new Color(245, 247, 250);
    Color accentGray = new Color(220, 225, 230);
    Color buttonText = Color.WHITE;

    public View() {
        this.setSize(800, 550);
        this.setTitle("Davis Baker IA - Online Notetaking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(backgroundGray);
        this.setLayout(new BorderLayout(10, 10));

        // ==== TOP PANEL ====
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(primaryBlue);
        top.setPreferredSize(new Dimension(800, 60));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(top, BorderLayout.NORTH);

        JPanel topWest = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        topWest.setOpaque(false);
        top.add(topWest, BorderLayout.WEST);

        sort = createButton("Sort", false);
        topWest.add(sort);

        clearSort = createButton("Clear Sort", false);
        topWest.add(clearSort);

        title = new JLabel("Online Notetaking System", JLabel.CENTER);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        top.add(title, BorderLayout.CENTER);

        // filler to balance title perfectly center
        JPanel topEast = new JPanel();
        topEast.setOpaque(false);
        topEast.setPreferredSize(topWest.getPreferredSize());
        top.add(topEast, BorderLayout.EAST);

        // ==== LEFT & RIGHT PANELS ====
        JPanel left = new JPanel(new GridBagLayout());
        left.setBackground(accentGray);
        left.setPreferredSize(new Dimension(90, 400));
        this.add(left, BorderLayout.WEST);

        previous = createButton("Prev", true);
        previous.setPreferredSize(new Dimension(90, 40)); // fixed size
        left.add(previous);

        JPanel right = new JPanel(new GridBagLayout());
        right.setBackground(accentGray);
        right.setPreferredSize(new Dimension(90, 400));
        this.add(right, BorderLayout.EAST);

        next = createButton("Next", true);
        next.setPreferredSize(new Dimension(90, 40)); // fixed size
        right.add(next);

        // ==== CENTER ====
        JPanel center = new JPanel(new BorderLayout(10, 10));
        center.setBackground(backgroundGray);
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(center, BorderLayout.CENTER);

        // Top row (topic + in-text citation)
        JPanel centerTop = new JPanel(new GridLayout(1, 2, 10, 0));
        centerTop.setBackground(backgroundGray);
        center.add(centerTop, BorderLayout.NORTH);

        topic = createField("Topic Here", JTextField.LEFT);
        centerTop.add(topic);

        inTextCitation = createField("In Text Citation Here", JTextField.RIGHT);
        centerTop.add(inTextCitation);

        // Data area (main text)
        data = new JTextArea();
        data.setText("Data Here");
        data.setLineWrap(true);
        data.setWrapStyleWord(true);
        data.setFont(fieldFont);
        data.setBackground(Color.WHITE);
        data.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentGray),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        center.add(data, BorderLayout.CENTER);

        // Bottom row (buttons + citation field)
        JPanel centerBottom = new JPanel(new BorderLayout(10, 0));
        centerBottom.setBackground(backgroundGray);
        center.add(centerBottom, BorderLayout.SOUTH);

        JPanel centerBottomLeft = new JPanel(new GridLayout(1, 3, 10, 0));
        centerBottomLeft.setBackground(backgroundGray);
        centerBottom.add(centerBottomLeft, BorderLayout.WEST);

        save = createButton("Save", true);
        centerBottomLeft.add(save);

        add = createButton("Add", true);
        centerBottomLeft.add(add);

        delete = createButton("Delete", true);
        centerBottomLeft.add(delete);

        citation = createField("Citation Here", JTextField.RIGHT);
        citation.setPreferredSize(new Dimension(this.getWidth() / 2, 35));
        centerBottom.add(citation, BorderLayout.CENTER);

        // ==== BOTTOM BAR ====
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(primaryBlue);
        bottom.setPreferredSize(new Dimension(800, 55));
        bottom.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        this.add(bottom, BorderLayout.SOUTH);

        JPanel bottomWest = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        bottomWest.setOpaque(false);
        bottom.add(bottomWest, BorderLayout.WEST);

        saveAndClose = createButton("Save and Close", false);
        bottomWest.add(saveAndClose);

        JPanel bottomEast = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        bottomEast.setOpaque(false);
        bottom.add(bottomEast, BorderLayout.EAST);

        upload = createButton("Upload", false);
        bottomEast.add(upload);

        download = createButton("Download", false);
        bottomEast.add(download);

        // ==== Final setup ====
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Helper: Create uniform styled button
    private JButton createButton(String text, boolean bordered) {
        JButton b = new JButton(text);
        b.setFont(buttonFont);
        b.setBackground(lightBlue);
        b.setForeground(buttonText);
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorder(bordered
                ? BorderFactory.createLineBorder(primaryBlue, 2, true)
                : BorderFactory.createEmptyBorder(6, 12, 6, 12));

        // Hover animation
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(hoverBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(lightBlue);
            }
        });

        b.addActionListener(this);
        return b;
    }

    // Helper: Create styled text field
    private JTextField createField(String placeholder, int alignment) {
        JTextField f = new JTextField(placeholder);
        f.setHorizontalAlignment(alignment);
        f.setFont(fieldFont);
        f.setBackground(Color.WHITE);
        f.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentGray),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        return f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == download) {
            System.out.println("download clicked");
        } else if (e.getSource() == upload) {
            System.out.println("upload clicked");
        } else if (e.getSource() == sort) {
            System.out.println("sort clicked");
        } else if (e.getSource() == previous) {
            System.out.println("previous clicked");
        } else if (e.getSource() == next) {
            System.out.println("next clicked");
        } else if (e.getSource() == save) {
            Controller.editCard(topic.getText(), inTextCitation.getText(), citation.getText(), data.getText());
            Controller.updateView();
            Controller.showState();
        } else if (e.getSource() == clearSort) {
            System.out.println("clear sort clicked");
        } else if (e.getSource() == delete) {
            Controller.deleteCard();
            Controller.updateView();
        } else if (e.getSource() == saveAndClose) {
            System.out.println("save and close clicked");
        } else if (e.getSource() == add) {
            Controller.addCard();
            Controller.updateView();
        }
    }
}