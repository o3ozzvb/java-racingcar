package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.anyOf;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 RandomMovable전략을 가지면 이동하거나 이동하지 않는다")
    public void 자동차가_RandomMovable전략을_가지면_이동하거나_이동하지_않는다() {
        //given
        Movable movable = new RandomMovable();
        RacingCar car = RacingCar.create(movable);
        //when
        car.move();
        //then
        assertThat(car.getStatus()).isSubsetOf("-", "--");
    }
}
