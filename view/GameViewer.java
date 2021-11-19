package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import control.GameController;

public class GameViewer {

    private JFrame oFrame;
    private JPanel oContent;
    private ClockViewer oClock;
    private ArrayList<SetViwer> sets;

    private JLabel vteam01;
    private JLabel vteam02;

    public GameViewer() {
        GameController.getInstance().setView(this);

        oFrame = new JFrame();
        oFrame.setTitle("VJ");
        oFrame.setSize(200, 200);
        oFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oFrame.setResizable(false);

        oContent = new JPanel(null);
        oFrame.setContentPane(oContent);

        oClock = new ClockViewer(oFrame);
        addComponents(oClock);

        JPanel jTeam = new JPanel(new FlowLayout());
        jTeam.add(new JLabel(GameController.getInstance().getTeam0()));
        jTeam.add(new JLabel("  X  "));
        jTeam.add(new JLabel(GameController.getInstance().getTeam1()));
        addComponents(jTeam);

        JPanel jvTeam = new JPanel(new FlowLayout());
        vteam01 = new JLabel("0");
        jvTeam.add(vteam01);
        jvTeam.add(new JLabel("  X  "));
        vteam02 = new JLabel("0");
        jvTeam.add(vteam02);
        addComponents(jvTeam);

        addSet();
        oFrame.setVisible(true);
    }

    private void addComponents(final JComponent jc) {
        jc.setBounds(0, oContent.getComponentCount() * 50 + 5, oFrame.getWidth(), 35);
        oContent.add(jc);
    }

    public void disable() {
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).disable();
        }
    }

    public void addSet() {
        SetViwer set = new SetViwer();
        addComponents(set);
        sets = new ArrayList<SetViwer>();
        sets.add(set);
        oFrame.setSize(200, oContent.getComponentCount() * 60);
        oFrame.setLocationRelativeTo(null);
        oFrame.repaint();
    }

    public void setVicTeam0(String text){
        vteam01.setText(text);
    }

    public void setVicTeam1(String text){
        vteam02.setText(text);
    }

}