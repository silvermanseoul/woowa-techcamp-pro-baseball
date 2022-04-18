package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void checkScore() {
        // Given
        Suit suit1 = Suit.from("123");
        Game game = new Game(suit1);

        // When
        Suit suit2 = Suit.from("123");
        game.checkScore(suit2);

        // Then
        assertThat(game.getBallCount()).isEqualTo(0);
        assertThat(game.getStrikeCount()).isEqualTo(3);
    }
}