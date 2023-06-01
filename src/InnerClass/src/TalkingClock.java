import CallBack.TimePrinter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    private int interval;
    private boolean beep;


    /**
     * Конструирует говорящие часы
     *
     * @param interval интервал между сообщениями в миллисекундах
     * @param beep     истиннно, если часы должны издавать звуковой сигнал
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;

    }


    public void start() {
        /*
        class TimePrinter implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is "
                        + Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();


            }
        }
        var listener = new TimePrinter();
        */
        var listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is "
                        + Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
    /*
    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is "
                    + Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();


        }
    }

     */
}
