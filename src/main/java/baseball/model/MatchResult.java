package baseball.model;

public class MatchResult {
    private int ball;
    private int strike;

    public String getResult(){
        StringBuffer result = new StringBuffer();
        result.append(BallStatus.BALL.getResult(this.ball));
        result.append(BallStatus.STRIKE.getResult(this.strike));

        if(hasNothing()){
            result.append(BallStatus.NONE.getResult(-1));
        }

        return result.toString().trim();
    }

    public boolean isGameOver(){
        return this.strike == 3 ? true : false;
    }
    public void report(BallStatus status){
        if(status==BallStatus.BALL) this.ball+=1;
        if(status==BallStatus.STRIKE) this.strike+=1;
    }

    public boolean hasBall(){
        return this.ball > 0;
    }

    public boolean hasStrike(){
        return this.strike > 0;
    }
    public boolean hasNothing(){
        return (! hasBall()) && (! hasStrike());
    }
}
