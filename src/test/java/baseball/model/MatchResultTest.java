package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @Test
    public void printBallAndStrike(){
        MatchResult mr = new MatchResult();
        mr.report(BallStatus.BALL);
        mr.report(BallStatus.STRIKE);
        String result = mr.getResult();
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void printBall(){
        MatchResult mr = new MatchResult();
        mr.report(BallStatus.BALL);
        String result = mr.getResult();
        assertThat(result).isEqualTo("1볼");
    }

    @Test
    public void printNothing(){
        MatchResult mr = new MatchResult();
        String result = mr.getResult();
        assertThat(result).isEqualTo("낫싱");
    }

}