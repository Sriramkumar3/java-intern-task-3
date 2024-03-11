package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyCreationGUI extends JFrame implements ActionListener {
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JButton saveButton;

    public SurveyCreationGUI() {
        setTitle("Survey Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        inputPanel.add(new JScrollPane(descriptionArea));

        saveButton = new JButton("Save Survey");
        saveButton.addActionListener(this);

        add(inputPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            saveSurveyToDatabase();
        }
    }

    private void saveSurveyToDatabase() {
        String url = "jdbc:mysql://localhost:3306/survey_system";
        String username = "root";
        String password = "root";

        String title = titleField.getText();
        String description = descriptionArea.getText();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO surveys (title, description) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, description);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Survey saved successfully!");
                clearFields();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving survey!");
        }
    }

    private void clearFields() {
        titleField.setText("");
        descriptionArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SurveyCreationGUI surveyCreationGUI = new SurveyCreationGUI();
            surveyCreationGUI.setVisible(true);
        });
    }
}
