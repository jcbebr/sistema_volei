package view;

import javax.swing.*;

import control.GameController;

import java.awt.*;
import java.awt.event.*;

public class SetViwer extends JPanel {

    private  JButton oBtnE01;
    private  JButton oBtnE02;

    private  JLabel oLbE01;
    private  JLabel oLbE02;

    public SetViwer() {
        super(new FlowLayout());
        oBtnE01 = new JButton("+");
        oLbE01 = new JLabel("0");
        oLbE02 = new JLabel("0");
        oBtnE02 = new JButton("+");

        oBtnE01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ret = GameController.getInstance().addPointTeam0();
                oLbE01.setText(ret);
            }
        });
        oBtnE02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oLbE02.setText(GameController.getInstance().addPointTeam1());
            }
        });

        addComponents(oBtnE01);        
        addComponents(oLbE01);        
        addComponents(oLbE02);        
        addComponents(oBtnE02);
    }

    private void addComponents(JComponent jc) {
        if (jc.getClass() == JLabel.class) {
            ((JLabel)jc).setHorizontalAlignment(JLabel.CENTER);
            ((JLabel)jc).setVerticalAlignment(JLabel.CENTER);
            ((JLabel)jc).setFont(((JLabel)jc).getFont().deriveFont(14f));
        }
        this.add(jc);
    }

    public void disable(){
        oBtnE01.setEnabled(false);
        oBtnE02.setEnabled(false);
    } 


}