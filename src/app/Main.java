package app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import view.StartGameView;

public class Main {

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new StartGameView().setVisible(true);
        });
    }
}
