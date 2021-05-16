package myGame.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import myGame.model.results.GameResult;
import myGame.model.results.GameResultDeserializer;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.List;


public class ListController {

    @FXML
    private TableView<GameResult> playerListTable;

    @FXML
    private TableColumn<GameResult, String> userName;

    @FXML
    private TableColumn<GameResult, String> step;

    @FXML
    private TableColumn<GameResult, String> solved;

    @FXML
    private TableColumn<GameResult, String> date;


    private String userName2;
    private String step2;
    private String solved2;

    public void back(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/launch.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Loading launch scene.");
    }

    @FXML
    public void initialize(){
        List<GameResult> leaderboardList = GameResultDeserializer.deserialize();
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        step.setCellValueFactory(new PropertyValueFactory<>("step"));
        solved.setCellValueFactory(new PropertyValueFactory<>("solved"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(leaderboardList);
        playerListTable.setItems(observableResult);
        Logger.info("Loading scoreboard");
    }

}
