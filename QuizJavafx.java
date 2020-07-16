import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class QuizJavafx extends Application{
    @Override
    public void start(Stage primary){
        StackPane stackPane = new StackPane();
        Button load_bt = new Button("Load file");
        stackPane.getChildren().add(load_bt);
        load_bt.setOnAction(e->{
            try{
                FileChooser file = new FileChooser();
                File file_open = file.showOpenDialog(primary);
                Quiz_run quiz_run = new Quiz_run(file_open.getAbsolutePath());

                Scene scene2 = new Scene(quiz_run, 550, 400);
                primary.setScene(scene2);
                primary.show();
            }catch (Exception ex){
                System.out.print(ex);
                Alert invalid = new Alert(Alert.AlertType.ERROR);
                invalid.setHeaderText("InvalidQuizFormat");
                invalid.setTitle("QuizViewer EXCEPTION");
                invalid.setContentText("");
                invalid.show();

            }

        });
        Scene scene = new Scene(stackPane, 250, 250);
        primary.setScene(scene);
        primary.setTitle("Quiz Viewer");
        primary.show();
    }

}