package ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * Login screen: lets the user enter their name before starting the quiz.
 */
public class LoginPanel extends JPanel {
    private final Consumer<String> onStart; // callback to notify parent when user clicks "Start Quiz"

    public LoginPanel(Consumer<String> onStart) {
        this.onStart = onStart;

        setLayout(new BorderLayout());

        // Title label at the top
        JLabel title = new JLabel("Welcome to the Quiz", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Input form: name field + button
        JPanel form = new JPanel(new GridLayout(3, 1, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField();
        JButton startBtn = new JButton("Start Quiz");

        form.add(nameLabel);
        form.add(nameField);
        form.add(startBtn);
        add(form, BorderLayout.CENTER);

        // Handle button click
        startBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name.");
                return;
            }
            onStart.accept(name); // pass name back to AppFrame
        });
    }
}
