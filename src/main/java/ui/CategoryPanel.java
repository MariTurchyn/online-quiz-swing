package ui;

import model.Category;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/** Lets the user pick a quiz category. */
public class CategoryPanel extends JPanel {
    private final Consumer<Category> onPick;

    public CategoryPanel(Consumer<Category> onPick) {
        this.onPick = onPick;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Choose a Category", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(0, 1, 10, 10));
        for (Category c : Category.values()) {
            JButton b = new JButton(c.displayName());
            b.addActionListener(e -> onPick.accept(c));
            grid.add(b);
        }
        add(grid, BorderLayout.CENTER);
    }
}
