package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자열이거나_null일_경우(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    void 숫자변환불가_문자열() {
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("1,2:가나");
        })
            .isInstanceOf(NumberFormatException.class)
        ;
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_기본구분자() {
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("-1,2,3");
        })
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("음수")
        ;
    }

    @Test
    void 음수_커스텀구분자() {
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("//;\n-1;2;3");
        })
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("음수")
        ;
    }

}