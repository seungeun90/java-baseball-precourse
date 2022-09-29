package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallsTest {

    @Nested
    class BallsEquality{
        @Test
        @DisplayName("랜덤으로 뽑는 볼 개수는 3개이다.")
        public void random_balls_size(){
            Balls balls = new Balls();
            Balls randomBalls = balls.getRandomBalls();
            int baseballCount = randomBalls.getBaseballSize();
            assertThat(baseballCount).isEqualTo(3);
        }

        @Test
        @DisplayName("볼의 생성 및 동등성 확인")
        public void balls_create(){
            Balls balls = new Balls();
            balls.addBaseball(new Ball(1,1));
            balls.addBaseball(new Ball(2,2));
            balls.addBaseball(new Ball(3,3));

            assertThat(balls.getBaseball(0)).isEqualTo(new Ball(1,1));
            assertThat(balls.getBaseball(1)).isEqualTo(new Ball(2,2));
            assertThat(balls.getBaseball(2)).isEqualTo(new Ball(3,3));
        }

        @Test
        @DisplayName("볼의 포지션이 하나라도 다르면 Balls 도 다르다.")
        public void balls_equality_false(){
            Balls ballsA = new Balls();
            ballsA.addBaseball(new Ball(1,1));
            ballsA.addBaseball(new Ball(2,2));

            Balls ballsB = new Balls();
            ballsB.addBaseball(new Ball(1,2));
            ballsB.addBaseball(new Ball(2,3));

            assertThat(ballsA.equals(ballsB)).isFalse();
        }

        @Test
        @DisplayName("볼을 3개 초과하면 exception발생")
        public void balls_add_exception(){
            Balls balls = new Balls();
            balls.addBaseball(new Ball(1,1));
            balls.addBaseball(new Ball(2,2));
            balls.addBaseball(new Ball(3,3));

            assertThrows(IllegalArgumentException.class, () -> balls.addBaseball(new Ball(4,4)));
        }
    }

    @Nested
    class BallsService {
        Balls computer = new Balls();
        @BeforeEach
        public void computerBall(){
            computer.addBaseball(new Ball(1,1));
            computer.addBaseball(new Ball(2,2));
            computer.addBaseball(new Ball(3,3));
        }
        @Test
        @DisplayName("1볼 1스트라이크")
        public void matchResult_1Ball_1Strike(){
            Balls user = new Balls();
            user.addBaseball(new Ball(1,3));
            user.addBaseball(new Ball(2,2));
            user.addBaseball(new Ball(9,1));

            MatchResult matchResult = computer.play(user);
            Assertions.assertThat(matchResult.getResult()).isEqualTo("1볼 1스트라이크");
        }
        @Test
        @DisplayName("3스트라이크")
        public void matchResult_3Strike(){
            Balls user = new Balls();
            user.addBaseball(new Ball(1,1));
            user.addBaseball(new Ball(2,2));
            user.addBaseball(new Ball(3,3));

            MatchResult matchResult = computer.play(user);
            Assertions.assertThat(matchResult.getResult()).isEqualTo("3스트라이크");
        }

        @Test
        @DisplayName("1볼")
        public void matchResult_1ball(){
            Balls user = new Balls();
            user.addBaseball(new Ball(6,1));
            user.addBaseball(new Ball(1,2));
            user.addBaseball(new Ball(9,3));

            MatchResult matchResult =  computer.play(user);
            Assertions.assertThat(matchResult.getResult()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("1스트라이크")
        public void matchResult_1strike(){
            Balls user = new Balls();
            user.addBaseball(new Ball(5,1));
            user.addBaseball(new Ball(2,2));
            user.addBaseball(new Ball(9,3));

            MatchResult matchResult = computer.play(user);
            Assertions.assertThat(matchResult.getResult()).isEqualTo("1스트라이크");
        }
    }


}