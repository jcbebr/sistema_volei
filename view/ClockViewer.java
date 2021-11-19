package view;

import java.awt.event.*;
import java.time.Duration;
import javax.swing.*;
import java.awt.*;

public class ClockViewer extends JPanel {

    private Timer oTimer;
    private JLabel oLbTime;

    public ClockViewer(JFrame parent) {
        super(new BorderLayout());

        oLbTime = new JLabel("00:00:00");
        oLbTime.setHorizontalAlignment(JLabel.CENTER);
        oLbTime.setVerticalAlignment(JLabel.CENTER);
        oLbTime.setFont(oLbTime.getFont().deriveFont(18f));
        this.add(oLbTime, BorderLayout.CENTER);

        long lInitTime = System.currentTimeMillis();

        oTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long runningTime = System.currentTimeMillis() - lInitTime;
                Duration duration = Duration.ofMillis(runningTime);
                long hours = duration.toHours();
                duration = duration.minusHours(hours);
                long minutes = duration.toMinutes();
                duration = duration.minusMinutes(minutes);
                long seconds = duration.toMillis() / 1000;
                oLbTime.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });

        oTimer.start();
    }

}