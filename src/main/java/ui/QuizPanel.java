package ui;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

/**
 * Quiz screen (stub version).
 * For now, just a placeholder with a "Finish" button.
 */
public class QuizPanel extends JPanel {
    private final BiConsumer<Integer, Integer> onFinish; // callback: (score, totalQuestions)

    public QuizPanel(BiConsumer<Integer, Integer> onFinish) {
        this.onFinish = onFinish;

        setLayout(new BorderLayout());

        // Placeholder label in the center
        JLabel label = new JLabel("Quiz Screen (coming soon)", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
        add(label, BorderLayout.CENTER);

        // Temporary finish button for testing navigation
        JButton finish = new JButton("Finish (demo)");
        finish.addActionListener(e -> onFinish.accept(0, 0)); // send dummy score
        add(finish, BorderLayout.SOUTH);
    }
}
