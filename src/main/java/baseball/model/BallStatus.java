package baseball.model;

public enum BallStatus {
    BALL("볼"), STRIKE("스트라이크"), NONE("낫싱");

    private String status;
    BallStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
    public String getResult(int number){
        if(this.getStatus() == BallStatus.NONE.getStatus()){
            return this.getStatus();
        }
        if( number > 0 ) {
            return number + status + " ";
        }
        return "";
    }
}
