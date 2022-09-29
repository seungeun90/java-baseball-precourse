package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallTest {
    @Test
    public void ball_create(){
        Ball oneBall = new Ball(1,1);
        Ball nineBall = new Ball(9,1);
        assertThat(oneBall).isEqualTo(new Ball(1,1));
        assertThat(nineBall).isEqualTo(new Ball(9,1));
    }

    @Test
    public void ball_create_numberRangeException(){
        assertThrows(IllegalArgumentException.class, () -> new Ball(0,1));
        assertThrows(IllegalArgumentException.class, () -> new Ball(10,1));
    }

    @Test
    public void ball_position_equalityTest(){
        Ball fiveInOne = new Ball(5,1);
        Ball fiveInTwo = new Ball(5,2);
        assertThat(fiveInOne.equals(fiveInTwo)).isFalse();

        Ball fiveInTree1 = new Ball(5,3);
        Ball fiveInTree2 = new Ball(5,3);
        assertThat(fiveInTree1.equals(fiveInTree2)).isTrue();
    }

}