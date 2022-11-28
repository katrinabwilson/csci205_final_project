/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 * Name: Harmony Yeung
 * Section: 9am - 9:50am
 * Date: 11/13/2022
 * Time: 3:00 AM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model.TimingClass
 * Class: TimingModel
 *
 * Description:
 *
 * ****************************************
 */
package CodeBash.model.TimingClass;

import javafx.beans.property.SimpleBooleanProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TimingModel {

    private JLabel counterLabel = new JLabel("");
    private javax.swing.Timer time;
    private SimpleBooleanProperty time15;
    private SimpleBooleanProperty time30;
    private SimpleBooleanProperty time45;
    private SimpleBooleanProperty time60;
    public int second;
    public int minute;
    private String ddSecond;
    private String ddMinute;
    private DecimalFormat dFormat = new DecimalFormat("00");

    public boolean isTime60() {
        return time60.get();
    }

    public SimpleBooleanProperty time60Property() {
        return time60;
    }

    public boolean isTime45() {
        return time45.get();
    }

    public SimpleBooleanProperty time45Property() {
        return time45;
    }

    public boolean isTime30() {
        return time30.get();
    }

    public SimpleBooleanProperty time30Property() {
        return time30;
    }

    public boolean isTime15() {
        return time15.get();
    }

    public SimpleBooleanProperty time15Property() {
        return time15;
    }

    TimingModel() {
        this.time15 = new SimpleBooleanProperty(false);
        this.time30 = new SimpleBooleanProperty(false);
        this.time45 = new SimpleBooleanProperty(false);
        this.time60 = new SimpleBooleanProperty(false);
        second = 0;
        minute=1;
        countdown();
        time.start();
    }

    public JLabel getCounterLabel() {
        return counterLabel;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String countdown() {
        time = new Timer(1000, e -> {
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
        });
        return counterLabel.getText();
    }
}