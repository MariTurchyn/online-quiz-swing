package app;

import ui.LoginPanel;
import ui.QuizPanel;
import ui.ResultPanel;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame{
    private final CardLayout layout = new CardLayout();
    private final JPanel root = new JPanel(layout);

    private static final String CARD_LOGIN  = "login";
    private static final String CARD_QUIZ   = "quiz";
    private static final String CARD_RESULT = "result";

    public AppFrame() {
        setTitle("Online Quiz (Swing)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 640);
        setLocationRelativeTo(null);

        // Use native OS look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Screens + callbacks
        var login = new LoginPanel(this::onStartQuiz);
        var quiz = new QuizPanel(this::onQuizFinished); // real logic later
        var result = new ResultPanel(this::showLogin);

        root.add(login, CARD_LOGIN);
        root.add(quiz, CARD_QUIZ);
        root.add(result, CARD_RESULT);
        setContentPane(root);

        showLogin();
    }
    private void showLogin()  { layout.show(root, CARD_LOGIN); }
    private void showQuiz()   { layout.show(root, CARD_QUIZ); }
    private void showResult() { layout.show(root, CARD_RESULT); }

    private void onStartQuiz(String userName) {
        // (we’ll use userName later)
        showQuiz();
    }

    private void onQuizFinished(int score, int total) {
        // find ResultPanel and update its label
        for (Component c : root.getComponents()) {
            if (c instanceof ResultPanel rp) {
                rp.setResult(score, total);
                break;
            }
        }
        showResult();
    }
}
