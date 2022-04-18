package baseball.contorller;

import baseball.domain.Suit;
import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final String RESTART_INPUT = "1";
    private static final String QUIT_INPUT = "2";

    public static void run() {
        boolean shouldStart = true;
        while (shouldStart) {
            startGame();
            shouldStart = shouldRestart();
        }
    }

    private static void startGame() {
        Suit computerSuit = Suit.create();

        Game game = new Game(computerSuit);

        boolean isGameCleared = false;
        while (!isGameCleared) {
            String input = InputView.readNumber();

            Suit userSuit = Suit.from(input);
            game.checkScore(userSuit);

            OutputView.printScore(game.getBallCount(), game.getStrikeCount());

            isGameCleared = game.isCleared();
        }
    }

    private static boolean shouldRestart() {
        String input = InputView.readAfterGameClear();

        if (input.equals(RESTART_INPUT)) {
            return true;
        }

        if (input.equals(QUIT_INPUT)) {
            OutputView.printQuit();
            return false;
        }

        throw new IllegalArgumentException();
    }
}
