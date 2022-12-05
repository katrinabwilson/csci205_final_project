/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Harmony Yeung, Nahom Ayele, Nolan Sauers, Katrina Wilson
 * Section: Section 01-9am
 * Date: 11/12/22
 * Time: 6:01 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash.CodeBashModel
 * Class: Times
 *
 * Description:
 * The timer that outlines timer in CodeBash
 * *****************************************/
package CodeBash.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;

/**
 * The class to test out a timer
 */
public class Times {

    /** the window to keep everything in */
    JFrame window;

    /** The label that the timer is in */
    JLabel counterLabel;

    /** The default font of the timer */
    Font font1 = new Font("Arial", Font.PLAIN, 70);

    /** The imported timer class */
    javax.swing.Timer time;

    /** The amount of seconds */
    int second;

    /** The amount of minutes */
    int minute;

    /** Seconds but formatted */
    String ddSecond;

    /** Minutes but formatted */
    String ddMinute;

    /** Format for the timer */
    DecimalFormat dFormat = new DecimalFormat("00");

    /**
     * The main class
     * @param args - the argument
     */
    public static void main(String[] args) {
        new Times();
    }

    /**
     * Initializes the style and the timer
     */
    public Times() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        counterLabel = new JLabel("");
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);

        window.add(counterLabel);
        window.setVisible(true);

        counterLabel.setText("01:00");
        second = 0;
        minute=1;
        countdown();
        time.start();
    }

    /**
     * The actual countdown
     *
     * @return the counterLabel with the amount of time the user has left
     */
    public String countdown() {
        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);

                if (second == -1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                if (minute == 0 && second == 0) {
                    time.stop();
                }
            }
        });
        return counterLabel.getText();
    }
}

