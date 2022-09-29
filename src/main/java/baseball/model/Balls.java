package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private final int baseballCount = 3;
    private List<Ball> baseball = new ArrayList<>();

    public void addBaseball(Ball ball){
        validateAddingBalls();
        baseball.add(ball);
    }
    public MatchResult play(Balls userBall){
        MatchResult matchResult = new MatchResult();

        for(int i=0; i<baseballCount; i++){
            BallStatus status = this.play(userBall.getBaseball(i));
            matchResult.report(status);
        }
        return matchResult;
    }
    private BallStatus play(Ball ball){
        if(isStrike(ball)){
            return BallStatus.STRIKE;
        }
        if(isBall(ball)){
            return BallStatus.BALL;
        }

        return BallStatus.NONE;
    }

    private boolean isStrike(Ball ball){
        if(this.baseball.get(ball.getPosition()-1).equals(ball)) {
            return true;
        }
        return false;
    }
    private boolean isBall(Ball ball){
        int count=0;
        for(Ball b : this.baseball){
             count += isNumberMatch(b,ball);
        }
        if(count > 0 ) return true;
        return false;
    }

    private int isNumberMatch(Ball com, Ball user){
        boolean b = com.matchNumber(user);
        if(b) return 1;
        return 0;
    }
    private void validateAddingBalls(){
        if(this.baseball.size() >= 3) throw new IllegalArgumentException("공은 3개까지 선택할 수 있습니다.");
    }
    public Ball getBaseball(int i){
        if(i>=3) throw new IllegalArgumentException("인덱스는 0~2까지 가능합니다.");
        return baseball.get(i);
    }

    public int getBaseballSize(){
        return baseball.size();
    }
    public Balls getRandomBalls() {
        baseball = new ArrayList<>();
        for(int i=1; i<=baseballCount; i++) {
            baseball.add(Ball.getRandomBall(i));
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls = (Balls) o;
        return baseballCount == balls.baseballCount && Objects.equals(baseball, balls.baseball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballCount, baseball);
    }

}
