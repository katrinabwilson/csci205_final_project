/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Nahom Ayele
 * Section: Section 01-9am
 * Date: 12/1/22
 * Time: 11:19 AM
 *
 * Project: csci205_final_project
 * Package: TypingGame
 * Class: FXModel
 *
 * Description:
 *
 * *****************************************/
package CodeBash.model.FXTime;

import javafx.animation.Timeline;

public class FXModel {
    /** This is the starting time of 15 seconds */
    public Integer STARTTIME = 15;

    public void setSTARTTIME(Integer STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    /** This is the one we're actually decrementing */
    public Integer timeSeconds = STARTTIME;


}

