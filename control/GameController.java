package control;

import javax.swing.JOptionPane;

import model.Game;
import model.Team;
import view.GameViewer;

public class GameController {

    private static GameController instance;
    private Game game;
    private GameViewer view;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public GameController() {
        super();
    }

    public void initGame(String team0, String team1, String hour) {
        game = new Game();
        game.setTeam0(new Team(0, team0));
        game.setTeam1(new Team(1, team1));
    }

    public String getTeam0() {
        return game.getTeam0().getName();
    }

    public String getTeam1() {
        return game.getTeam1().getName();
    }

    public String addPointTeam0() {
        int currentSet = game.getCurrentSet();
        addPoint(game.getTeam0());
        return "" + getPointsTeam(game.getTeam0(), currentSet);
    }

    public String addPointTeam1() {
        int currentSet = game.getCurrentSet();
        addPoint(game.getTeam1());
        return "" + getPointsTeam(game.getTeam1(), currentSet);
    }

    private void addPoint(Team team) {
        if (game.getSets().size() == 0) {
            int[] points = new int[] { 0, 0 };
            points[team.getId()]++;
            game.getSets().add(points);
        } else {
            game.getSets().get(game.getCurrentSet())[team.getId()]++;
        }
        checkSet();
    }

    private int getPointsTeam(Team team, int set) {
        return game.getSets().get(set)[team.getId()];
    }

    private void checkSet() {
        int currentSet = game.getCurrentSet();
        int[] currentPoints = game.getSets().get(currentSet);
        if (currentSet < 4) {
            checkSetPoints(currentPoints, 25);
        } else {
            checkSetPoints(currentPoints, 15);
        }

    }

    private void checkSetPoints(int[] currentPoints, int limitPoints) {
        for (int i = 0; i < 2; i++) {
            if (currentPoints[i] >= limitPoints) {
                int oteam = i + 1 > 1 ? 0 : i + 1;
                if (currentPoints[i] - currentPoints[oteam] > 1) {
                    checkGame(i);
                }
            }
        }
    }

    private void checkGame(int team) {
        Team winner;
        if (team == game.getTeam0().getId()) {
            winner = game.getTeam0();
        } else {
            winner = game.getTeam1();
        }

        if (winner.getWins() == 2) {
            int ret = JOptionPane.showConfirmDialog(null, "Deseja finalizar o jogo?", "Atenção",
                    JOptionPane.YES_NO_OPTION);

            if (ret == JOptionPane.YES_OPTION) {
                winner.setWins(winner.getWins() + 1);
                game.setCurrentSet(game.getCurrentSet() + 1);
                game.getSets().add(new int[] { 0, 0 });
                view.disable();
                updateWins(winner);
                JOptionPane.showMessageDialog(null, "Equipe ganhadora: "+winner.getName());
            } else {
                game.getSets().get(game.getCurrentSet())[team] = game.getSets().get(game.getCurrentSet())[team] - 1;
            }
        } else {

            int ret = JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo set?", "Atenção",
                    JOptionPane.YES_NO_OPTION);

            if (ret == JOptionPane.YES_OPTION) {
                winner.setWins(winner.getWins() + 1);
                game.setCurrentSet(game.getCurrentSet() + 1);
                game.getSets().add(new int[] { 0, 0 });
                view.disable();
                view.addSet();
                updateWins(winner);
            } else {
                game.getSets().get(game.getCurrentSet())[team] = game.getSets().get(game.getCurrentSet())[team] - 1;
            }
        }
    }

    private void updateWins(Team winner) {
        if (winner.getId() == game.getTeam0().getId()) {
            view.setVicTeam0(winner.getWins() + "");
        } else if (winner.getId() == game.getTeam1().getId()) {
            view.setVicTeam1(winner.getWins() + "");
        }
    }

    public void setView(GameViewer view) {
        this.view = view;
    }

}