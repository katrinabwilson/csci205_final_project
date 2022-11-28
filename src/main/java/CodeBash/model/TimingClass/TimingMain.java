/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 * Name: Harmony Yeung
 * Section: 9am - 9:50am
 * Date: 11/13/2022
 * Time: 5:33 PM
 *
 * Project: csci205_final_project
 * Package: CodeBash.model.TimingClass
 * Class: TimingMain
 *
 * Description:
 *
 * ****************************************
 */
package CodeBash.model.TimingClass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimingMain extends Application {

  private TimingView theView;

  private TimingModel theModel;

  private TimingController theController;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void init() throws Exception {
    super.init();
    this.theModel = new TimingModel();
    this.theView = new TimingView(theModel);
    this.theController = new TimingController(theView, theModel);
  }

  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(this.theView.getRoot());

    scene.getStylesheets().add(
            getClass().getResource("/CodeBash/Model/TimingClass/Timing.css")
                    .toExternalForm()
    );

    primaryStage.setTitle("Timer");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();

  }
}