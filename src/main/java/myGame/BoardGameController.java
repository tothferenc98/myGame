package myGame;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import org.tinylog.Logger;

import myGame.model.BoardGameModel;
import myGame.model.PawnDirection;
import myGame.model.Position;

public class BoardGameController {

    private enum SelectionPhase {
        SELECT_FROM,
        SELECT_TO;

        public SelectionPhase alter() {
            return switch (this) {
                case SELECT_FROM -> SELECT_TO;
                case SELECT_TO -> SELECT_FROM;
            };
        }
    }

    private SelectionPhase selectionPhase = SelectionPhase.SELECT_FROM;

    private List<Position> selectablePositions = new ArrayList<>();

    private Position selected;

    private BoardGameModel model = new BoardGameModel();

    @FXML
    private GridPane board;

    @FXML
    private void initialize() {
        createBoard();


        createPieces();

        setSelectablePositions();
        showSelectablePositions();

        board.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //System.out.println(event.getCode());
                if(event.getCode()==KeyCode.LEFT || event.getCode()==KeyCode.A){
                    left();
                }
                else if(event.getCode()==KeyCode.RIGHT || event.getCode()==KeyCode.D){
                    right();
                }
                else if(event.getCode()==KeyCode.UP || event.getCode()==KeyCode.W){
                    up();
                }
                else if(event.getCode()==KeyCode.DOWN || event.getCode()==KeyCode.S){
                    down();
                }
            }
        });


    }
    private void left() {

        System.out.println("bal");
        //model.move(pieceNumber, direction)


    }
    private void right() {
        System.out.println("jobb");
    }
    private void up() {
        System.out.println("fel");
    }
    private void down() {
        System.out.println("le");
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
        square.setOnMouseClicked(this::handleMouseClick);
        return square;
    }

    private void createPieces() {
        for (int i = 0; i < model.getPieceCount(); i++) {
            model.positionProperty(i).addListener(this::piecePositionChange);
            var piece = new Circle(50);
            piece.setFill(Color.BLUE);
            getSquare(model.getPiecePosition(i)).getChildren().add(piece);
        }
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        var position = new Position(row, col);
        Logger.debug("Click on square {}", position);
        handleClickOnSquare(position);
    }

    private void handleClickOnSquare(Position position) {
        switch (selectionPhase) {
            case SELECT_FROM -> {
                if (selectablePositions.contains(position)) {
                    selectPosition(position);
                    alterSelectionPhase();
                }
            }
            case SELECT_TO -> {
                if (selectablePositions.contains(position)) {
                    var pieceNumber = model.getPieceNumber(selected).getAsInt();
                    var direction = PawnDirection.of(position.row() - selected.row(), position.col() - selected.col());
                    Logger.debug("Moving piece {} {}", pieceNumber, direction);
                    model.move(pieceNumber, direction);
                    deselectSelectedPosition();
                    alterSelectionPhase();
                }
            }
        }
    }

    private void alterSelectionPhase() {
        selectionPhase = selectionPhase.alter();
        hideSelectablePositions();
        setSelectablePositions();
        showSelectablePositions();
    }

    private void selectPosition(Position position) {
        selected = position;
        showSelectedPosition();
    }

    private void showSelectedPosition() {
        var square = getSquare(selected);
        square.getStyleClass().add("selected");
    }

    private void deselectSelectedPosition() {
        hideSelectedPosition();
        selected = null;
    }

    private void hideSelectedPosition() {
        var square = getSquare(selected);
        square.getStyleClass().remove("selected");
    }

    private void setSelectablePositions() {
        selectablePositions.clear();
        switch (selectionPhase) {
            case SELECT_FROM -> selectablePositions.addAll(model.getPiecePositions());
            case SELECT_TO -> {
                var pieceNumber = model.getPieceNumber(selected).getAsInt();
                for (var direction : model.getValidMoves(pieceNumber)) {
                    selectablePositions.add(selected.moveTo(direction));
                }
            }
        }
    }

    private void showSelectablePositions() {
        for (var selectablePosition : selectablePositions) {
            var square = getSquare(selectablePosition);
            square.getStyleClass().add("selectable");
        }
    }

    private void hideSelectablePositions() {
        for (var selectablePosition : selectablePositions) {
            var square = getSquare(selectablePosition);
            square.getStyleClass().remove("selectable");
        }
    }

    private StackPane getSquare(Position position) {
        for (var child : board.getChildren()) {
            if (GridPane.getRowIndex(child) == position.row() && GridPane.getColumnIndex(child) == position.col()) {
                return (StackPane) child;
            }
        }
        throw new AssertionError();
    }

    private void piecePositionChange(ObservableValue<? extends Position> observable, Position oldPosition, Position newPosition) {
        Logger.debug("Move: {} -> {}", oldPosition, newPosition);
        StackPane oldSquare = getSquare(oldPosition);
        StackPane newSquare = getSquare(newPosition);
        newSquare.getChildren().addAll(oldSquare.getChildren());
        oldSquare.getChildren().clear();
    }

}