package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Ball {
    private static final int startIdx = 1;
    private static final int endIdx = 9;
    private int number;
    private int position;

    public Ball(int number, int position) {
        validateBall(number);
        validatePosition(position);
        this.number = number;
        this.position = position;
    }

    private void validateBall(int number){
        if(number < startIdx || number > endIdx) throw new IllegalArgumentException("숫자는 0보다 크고 10보다 작아야합니다.");
    }
    private void validatePosition(int number){
        if(number < 1 || number > 3) throw new IllegalArgumentException("포지션은는 0보다 크고 4보다 작아야합니다.");
    }
    public static Ball getRandomBall(int position){
        return new Ball(Randoms.pickNumberInRange(startIdx,endIdx),position);
    }

    public boolean matchNumber(Ball ball){
        return this.getNumber() == ball.getNumber();
    }

    public int getNumber() {
        return number;
    }
    public int getPosition(){ return position; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
