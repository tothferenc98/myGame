package myGame.results;

/**
 * This class represents the result of the game played by the player.
 */
public class GameResult {

    private String userName;
    private String step;
    private String solved;
    private String date;

    /**
     * GameResult's constructor. Initializes the player name, the number of steps, and the date.
     * @param userName  is the player name
     * @param step gives the number of steps of the ball
     * @param solved indicates whether it has reached the target state
     * @param date get the end time of the game state
     */
    public GameResult(String userName, String step, String solved, String date) {
        this.userName = userName;
        this.step = step;
        this.solved = solved;
        this.date = date;
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

    public String getDate() {
        return date;
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

    public void setDate(String date) {
        this.date = date;
    }

}
