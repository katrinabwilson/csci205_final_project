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
 * Package: FX Time
 * Class: FXModel
 *
 * Description: This is a class that keeps our timer calculations separate.
 * It serves as a vault that keeps our start times so that they won't get modified
 * at another point in the program. We
 *
 * *****************************************/
package CodeBash.model.FXTime;

public class FXModel {
    /** This is the starting time of 15 seconds */
    private static Integer STARTTIME = 15;
    /** Setter method for the start time desired */
    public void setSTARTTIME(Integer STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    /** This is the one we're actually decrementing */
    public Integer timeSeconds = STARTTIME;


}

