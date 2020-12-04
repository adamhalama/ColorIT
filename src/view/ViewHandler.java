package view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ProjectManagementModel;

public class ViewHandler
{
    // this is just a backbone of the view handler just so there is at least something
    private final Scene currentScene;
    private Stage primaryStage;
    private final ProjectManagementModel model;

    public ViewHandler(ProjectManagementModel model)
    {
        this.model = model;
        this.currentScene = new Scene(new Region());
        //copied form the GradeListGUI example
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        /*
         also from the GL GUI example
         but "openView("mainMenu");" is missing
          or "openView("projectTab");"
         */
    }

}
