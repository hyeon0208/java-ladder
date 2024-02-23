package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @Nested
    @DisplayName("사다리 높이 입력 형식 테스트")
    class LadderHeightFormatTest {
        @Test
        @DisplayName("정수형태가 입력되면 정상적으로 생성된다")
        void createLadderHeightSuccessWithFormat() {
            LadderHeight height = new LadderHeight("2");
            Assertions.assertThat(height.getValue()).isEqualTo(2);
        }

        @Test
        @DisplayName("정수형태가 아니라면 예외가 발생한다")
        void createLadderHeightFailByFormat() {
            Assertions.assertThatThrownBy(() -> new LadderHeight("a"))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.INTEGER_FORMAT);
        }
    }

    @Nested
    @DisplayName("사다리 높이 범위 테스트")
    class LadderHeightRangeTest {
        @ParameterizedTest
        @ValueSource(strings = {"2", "10"})
        @DisplayName("높이가 2 이상, 10 이하라면 정상적으로 생성된다")
        void createLadderHeightSuccessWithRange(String value) {
            LadderHeight ladderHeight = new LadderHeight(value);
            int expected = Integer.parseInt(value);
            Assertions.assertThat(ladderHeight.getValue()).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "11"})
        @DisplayName("높이가 2 미만, 10 초과라면 예외가 발생한다")
        void createLadderHeightFailByRange(String value) {
            Assertions.assertThatThrownBy(() -> new LadderHeight(value))
                    .isInstanceOf(ValidationException.class)
                    .hasMessage(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }
}
