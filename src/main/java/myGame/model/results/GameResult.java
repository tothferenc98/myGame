package myGame.model.results;


public class GameResult {

    private String userName;

    private String step;

    private String solved;

    private String date;

    public GameResult(String userName, String step, String solved, String date) {
        this.userName = userName;
        this.step = step;
        this.solved = solved;
        this.date = date;
    }

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
