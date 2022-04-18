package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SuitTest {

    @Test
    void create() {
        // Given
        // When
        Suit suit = Suit.create();

        // Then
        List<Integer> list = suit.getNumbers();
        Set<Integer> set = new HashSet<>(list);
        assertThat(list.size()).isEqualTo(set.size());
    }

    @Test
    void from() {
        // Given
        String input = "123";

        // When
        Suit suit = Suit.from(input);

        // Then
        assertThat(suit.getNumbers()).containsExactly(1, 2, 3);
    }

    @Test
    void from_길이예외발생() {
        // Given
        String input = "1234";

        // When
        // Then
        assertThatThrownBy(() -> Suit.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 길이입니다.");
    }

    @Test
    void from_중복예외발생() {
        // Given
        String input = "122";

        // When
        // Then
        assertThatThrownBy(() -> Suit.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복이 존재합니다.");
    }

    @Test
    void from_숫자예외발생() {
        // Given
        String input = "12a";

        // When
        // Then
        assertThatThrownBy(() -> Suit.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    void from_범위예외발생() {
        // Given
        String input = "120";

        // When
        // Then
        assertThatThrownBy(() -> Suit.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 정해진 범위를 벗어납니다.");
    }
}