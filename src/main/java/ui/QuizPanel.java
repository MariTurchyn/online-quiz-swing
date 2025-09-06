package ui;

import model.Question;
import service.QuizService;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.function.BiConsumer;


public class QuizPanel extends JPanel {
    private final BiConsumer<Integer, Integer> onFinish; // callback: (score, total)
    private final List<Question> questions;

    private int currentIndex = 0;
    private int score = 0;

    // UI components
    private final JLabel questionLabel = new JLabel("", SwingConstants.CENTER);
    private final JRadioButton[] optionButtons = new JRadioButton[4];
    private final ButtonGroup group = new ButtonGroup();
    private final JButton nextButton = new JButton("Next");

    public QuizPanel(BiConsumer<Integer, Integer> onFinish) {
        this.onFinish = onFinish;

        // Get questions from service
        QuizService service = new QuizService();
        this.questions = service.getQuestions();

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Question at the top
        questionLabel.setFont(questionLabel.getFont().deriveFont(Font.BOLD, 18f));
        add(questionLabel, BorderLayout.NORTH);

        // Options in the middle
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 6, 6));
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        // Next button at the bottom
        nextButton.addActionListener(e -> onNext());
        add(nextButton, BorderLayout.SOUTH);

        // Load the first question
        loadQuestion();
    }

    private void loadQuestion() {
        Question q = questions.get(currentIndex);
        questionLabel.setText(q.getText());

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(q.getOptions().get(i));
        }

        group.clearSelection();

        // Last question? change button text
        if (currentIndex == questions.size() - 1) {
            nextButton.setText("Finish");
        } else {
            nextButton.setText("Next");
        }
    }

    private void onNext() {
        // Find selected answer
        int selected = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selected = i;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            return;
        }

        // Check correctness
        if (selected == questions.get(currentIndex).getCorrectIndex()) {
            score++;
        }

        currentIndex++;
        if (currentIndex < questions.size()) {
            loadQuestion();
        } else {
            // Quiz finished → tell AppFrame
            onFinish.accept(score, questions.size());
        }
    }
}
