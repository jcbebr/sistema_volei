import javax.swing.JOptionPane;

import control.GameController;
import view.GameViewer;

public class Main {

    public static void main(String[] args) {       
        // Inserindo info Equipe
        String team0 = JOptionPane.showInputDialog(null, "Equipe A:");
        String team1 = JOptionPane.showInputDialog(null, "Equipe B:");
        String hour = JOptionPane.showInputDialog(null, "Horário:");
        GameController.getInstance().initGame(team0, team1, hour);
        
        new GameViewer();
    }

}
