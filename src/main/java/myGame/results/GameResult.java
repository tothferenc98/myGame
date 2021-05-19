package myGame.results;

import java.time.ZonedDateTime;

/**
 * This class represents the result of the game played by the player.
 */
public class GameResult {

    private String userName;
    private String step;
    private String solved;
    private ZonedDateTime dateTime;

    /**
     * GameResult's constructor. Initializes the player name, the number of steps, and the date.
     * @param userName  is the player name
     * @param step gives the number of steps of the ball
     * @param solved indicates whether it has reached the target state
     */
    public GameResult(String userName, String step, String solved) {
        this.userName = userName;
        this.step = step;
        this.solved = solved;
        this.dateTime=ZonedDateTime.now().plusHours(2);
    }

    /**
     * Constructor without argument.
     */
    public GameResult(){}

    public String getUserName() {
        return userName;
    }

    public String getStep() {
        return step;
    }

    public String getSolved() {
        return solved;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setSolved(String solved) {
        this.solved = solved;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
