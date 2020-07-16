import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Quiz_run extends BorderPane {
    private int i = 0;
    private int coun = 0;
    private RadioButton radioButton1 = new RadioButton();
    private RadioButton radioButton2 = new RadioButton();
    private RadioButton radioButton3 = new RadioButton();
    private RadioButton radioButton4 = new RadioButton();
    private TextField textfield = new TextField();
    public Quiz_run(String file) throws Exception{
        Map<Integer, String> ans = new HashMap<>();
        Quiz quiz = (Quiz)Quiz.loadFromFile(file);
        ArrayList<Question> questionList = quiz.getQuestions();
        TextArea question = new TextArea();
        question.setEditable(false);
        question.setWrapText(true);
        question.setPrefSize(400, 300);
        HBox bottomBox = new HBox(120);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(25, 45, 0, 45));
        Button Answer_Bt = new Button("Check answer");
        Button right = new Button(">>");
        Button left = new Button("<<");
        setTop(question);
        setRight(right);
        setLeft(left);
        setBottom(bottomBox);
        Label status = new Label(String.format("Status %d/%d questions", (i+1), questionList.size()));
        bottomBox.getChildren().add(status);
        bottomBox.getChildren().add(Answer_Bt);

        if(questionList.get(i) instanceof FillIn){
            question.setText(questionList.get(i).getDescription().replace("{black}", "_____"));
            setCenter(textfield);
        }
        else{
            question.setText(questionList.get(i).getDescription());
            radioButton1.setText(questionList.get(i).getAnswer());
            radioButton2.setText(((Test)questionList.get(i)).getOptionAt(0));
            radioButton3.setText(((Test)questionList.get(i)).getOptionAt(1));
            radioButton4.setText(((Test)questionList.get(i)).getOptionAt(2));
            ToggleGroup radiobuttons  = new ToggleGroup();
            radiobuttons.getToggles().add(radioButton1);
            radiobuttons.getToggles().add(radioButton2);
            radiobuttons.getToggles().add(radioButton3);
            radiobuttons.getToggles().add(radioButton4);
            vbox.getChildren().add(radioButton1);
            vbox.getChildren().add(radioButton2);
            vbox.getChildren().add(radioButton3);
            vbox.getChildren().add(radioButton4);
            setCenter(vbox);
        }

        right.setOnAction(e -> {
            System.out.println(1);
        });
        left.setOnAction(e -> {
            System.out.println(0);
        });
    }

}
