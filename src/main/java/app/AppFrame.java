package app;

import model.Category;
import model.Question;
import service.QuizService;
import ui.CategoryPanel;
import ui.LoginPanel;
import ui.QuizPanel;
import ui.ResultPanel;
import ui.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppFrame extends JFrame {
    private final CardLayout layout = new CardLayout();
    private final JPanel root = new JPanel(layout);

    private static final String CARD_LOGIN    = "login";
    private static final String CARD_CATEGORY = "category";
    private static final String CARD_QUIZ     = "quiz";
    private static final String CARD_RESULT   = "result";

    private String playerName = "";
    private QuizPanel quizPanel;               // current quiz instance
    private final QuizService service = new QuizService();

    public AppFrame() {
        setTitle("Online Quiz (Swing)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 640);
        setLocationRelativeTo(null);

        BackgroundPanel bg = new BackgroundPanel("/bg.jpg");
        setContentPane(bg);

        root.setOpaque(false);
        bg.add(root);

        // Screens + callbacks
        var login    = new LoginPanel(this::onStartWithName);
        var category = new CategoryPanel(this::onCategoryPicked);
        var result   = new ResultPanel(this::showCategory); // after results, go back to category picker

        root.add(login,    CARD_LOGIN);
        root.add(category, CARD_CATEGORY);
        root.add(result,   CARD_RESULT);


        showLogin();
    }

    private void showLogin()    { layout.show(root, CARD_LOGIN); }
    private void showCategory() { layout.show(root, CARD_CATEGORY); }
    private void showQuiz()     { layout.show(root, CARD_QUIZ); }
    private void showResult()   { layout.show(root, CARD_RESULT); }

    // from LoginPanel
    private void onStartWithName(String userName) {
        this.playerName = userName;
        showCategory();
    }

    // from CategoryPanel
    private void onCategoryPicked(Category category) {
        List<Question> questions = service.getQuestions(category);

        // remove previous quiz card if exists
        if (quizPanel != null) {
            root.remove(quizPanel);
        }
        quizPanel = new QuizPanel(questions, this::onQuizFinished);
        root.add(quizPanel, CARD_QUIZ);

        // refresh layout (optional polish)
        root.revalidate();
        root.repaint();

        showQuiz();
    }


    // from QuizPanel
    private void onQuizFinished(int score, int total) {
        // update result panel
        for (Component c : root.getComponents()) {
            if (c instanceof ResultPanel rp) {
                rp.setResult(score, total); // (name/category can be added later)
                break;
            }
        }
        showResult();
    }
}
