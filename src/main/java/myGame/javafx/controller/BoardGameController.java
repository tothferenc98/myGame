package myGame.javafx.controller;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.stage.Stage;
import myGame.results.GameResult;
import myGame.results.GameResultSerializer;
import org.tinylog.Logger;

import myGame.model.BoardGameModel;
import myGame.model.PawnDirection;
import myGame.model.Position;

public class BoardGameController {

    private BoardGameModel model = new BoardGameModel();

    private String userName;
    private int steps=0;
    private boolean inTarget=false;

    @FXML
    private GridPane board;


    @FXML
    private Label usernameLabel;

    @FXML
    private Label stepLabel;

    @FXML
    private Label solvedLabel;

    @FXML
    private Button doneButton;

    @FXML
    private Button resetButton;


    @FXML
    private void initialize() {
        createBoard();
        createTargetLabel();
        createCircle();
        board.setOnKeyPressed(this::handleOnKeyPressed);

    }
    @FXML
    private void handleOnKeyPressed(KeyEvent event)
    {
        //Logger.debug(event.getCode());
        if(inTarget==false)
        {
            if(event.getCode()==KeyCode.A){
                left();
            }
            else if(event.getCode()==KeyCode.D){
                right();
            }
            else if(event.getCode()==KeyCode.W){
                up();
            }
            else if(event.getCode()==KeyCode.S){
                down();
            }
        }


    }

    public void resetGame(ActionEvent actionEvent) throws IOException {
        Position original = new Position(1,4);
        if(!model.circlePosition.equals(original)){
            positionChange(model.circlePosition, original);
            model.circlePosition=original;
        }

    }

    public void finishGame(ActionEvent actionEvent) throws IOException {
        if(!inTarget){solvedLabel.setText("Defeat");}

        GameResult result = new GameResult(usernameLabel.getText(), stepLabel.getText(),  solvedLabel.getText());
        GameResultSerializer.serialize(result);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/list.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void left() {
        Position old = model.circlePosition;
        try {
            model.move(PawnDirection.LEFT);
            positionChange(old,model.circlePosition);
            stepIncreaser();

        }catch (Exception e){}

    }
    private void right() {
        Position old = model.circlePosition;
        try{
            model.move(PawnDirection.RIGHT);
            positionChange(old,model.circlePosition);
            stepIncreaser();
        }catch (Exception e){}

    }
    private void up() {
        Position old = model.circlePosition;
        try{
            model.move(PawnDirection.UP);
            positionChange(old,model.circlePosition);
            stepIncreaser();
        }catch (Exception e){}

    }
    private void down() {
        Position old = model.circlePosition;
        try{
            model.move(PawnDirection.DOWN);
            positionChange(old,model.circlePosition);
            stepIncreaser();
        }catch (Exception e){}


    }

    public void stepIncreaser(){
        steps+=1;
        stepLabel.setText(String.valueOf(steps));
    }

    private void createBoard() {
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getColumnCount(); j++) {
                var square = createSquare();
                board.add(square, j, i);


                if(i==0){
                    switch(j) {
                        case 0,3 -> square.getStyleClass().add("right");
                        case 1,4 -> square.getStyleClass().add("left");
                        case 2,6 -> square.getStyleClass().add("down");
                    }
                }
                if(i==1){
                    switch(j) {
                        case 2,6 -> square.getStyleClass().add("up");
                    }
                }
                if(i==2){
                    switch(j) {
                        case 1 -> square.getStyleClass().add("down");
                        case 2,5 -> square.getStyleClass().add("right");
                        case 3,6 -> square.getStyleClass().add("left");
                    }
                }
                if(i==3){
                    switch(j) {
                        case 1 -> square.getStyleClass().add("up");
                        case 3 -> square.getStyleClass().add("rightAndDown");
                        case 4 -> square.getStyleClass().add("leftAndRight");
                        case 5 -> square.getStyleClass().add("left");
                        case 6 -> square.getStyleClass().add("down");
                    }
                }
                if(i==4){
                    switch(j) {
                        case 0,4 -> square.getStyleClass().add("down");
                        case 3,6 -> square.getStyleClass().add("up");
                    }
                }
                if(i==5){
                    switch(j) {
                        case 0,4 -> square.getStyleClass().add("up");
                        case 1 -> square.getStyleClass().add("right");
                        case 2 -> square.getStyleClass().add("target");
                        case 3 -> square.getStyleClass().add("left");
                    }
                }
                if(i==6){
                    switch(j) {
                        case 3,5 -> square.getStyleClass().add("right");
                        case 4,6 -> square.getStyleClass().add("left");
                        case 2 -> square.getStyleClass().add("up");
                    }
                }
            }
        }
    }

    private StackPane createSquare() {
        var square = new StackPane();
        square.getStyleClass().add("square");
        return square;
    }

    private Label createTargetLabel() {
        var label = new Label();
        label.setText("Cél");
        label.getStyleClass().add("targetLabel");
        board.add(label, 2, 5);

        return label;
    }

    private Circle createCircle() {

        var circle = new Circle(35);
        circle.setFill(Color.BLUE);
        getSquare(model.circlePosition).getChildren().add(circle);
        return circle;
    }

    public void initdata(String userName) {
        this.userName = userName;
        usernameLabel.setText(this.userName);
    }


    private StackPane getSquare(Position position) {
        for (var child : board.getChildren()) {
            if (GridPane.getRowIndex(child) == position.row() && GridPane.getColumnIndex(child) == position.col()) {
                return (StackPane) child;
            }
        }
        throw new AssertionError();
    }

    private void positionChange(Position oldPosition, Position newPosition) throws IOException {
        Logger.info("Move: {} -> {}", oldPosition, newPosition);
        StackPane oldSquare = getSquare(oldPosition);
        StackPane newSquare = getSquare(newPosition);
        newSquare.getChildren().addAll(oldSquare.getChildren());
        oldSquare.getChildren().clear();
        Position target = new Position(5,2);
        if(newPosition.equals(target)){
            inTarget=true;
            resetButton.setDisable(true);
            doneButton.setText("Player list");
            solvedLabel.setText("Victory");

        }
    }
}
