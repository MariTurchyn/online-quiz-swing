package app;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Create the GUI on the Event Dispatch Thread (Swing best practice)
        SwingUtilities.invokeLater(() -> new AppFrame().setVisible(true));
    }
}
