package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Result screen: shows the user's score and lets them return to login.
 */
public class ResultPanel extends JPanel {
    private final Runnable onBack; // callback to return to login
    private final JLabel resultLabel = new JLabel("Your score: 0 / 0", SwingConstants.CENTER);

    public ResultPanel(Runnable onBack) {
        this.onBack = onBack;

        setLayout(new BorderLayout());
        setOpaque(false); // <—


        // Score display in the center
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 20f));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(resultLabel, BorderLayout.CENTER);

        // Back button at the bottom
// in ui/ResultPanel.java
        JButton back = new JButton("Back to Categories");
        back.addActionListener(e -> onBack.run());
        add(back, BorderLayout.SOUTH);
    }

    // Update score label with actual results
    public void setResult(int score, int total) {
        resultLabel.setText("Your score: " + score + " / " + total);
    }
}
